package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import social.Database;

/**
 * Class that serializes the database, and serializes when application is closed
 * @author bmvin
 */
public class DataSerializer {

    public static void serializeDatabase(String filename, Database database) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(database);

            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Database deserializeDatabase(String filename) {
        Database db = new Database();

        File file = new File(filename);

        if (file.exists() && !file.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);

                db = (Database) ois.readObject();

                ois.close();
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
            }
        }

        return db;
    }

}
