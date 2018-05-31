/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import social.User;

/**
 *
 * @author bmvin
 */
public class DataSerializer {

    public static void serializeData(String fileName, Object toSerialize) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(toSerialize);
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HashMap desirializeData(String filename) {
        HashMap map = null;
        File file = new File(filename);
        if (file.exists() && !file.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);

                map = (HashMap) ois.readObject();
                ois.close();
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
            }
        }
        
        return map;
    }

    public static HashMap<String, User> desirializeUsersData(String fileName) {
        HashMap<String, User> map = null;
        map = desirializeData(fileName);
        return map;
    }

    public static HashMap<String, String> desirializeAuthenticationData(String fileName) {
        HashMap<String, String> map = null;
        map = desirializeData(fileName);
        return map;
    }

}
