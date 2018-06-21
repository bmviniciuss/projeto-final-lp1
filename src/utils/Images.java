
package utils;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import social.Uid;

public class Images {

    public static final String ROOT_PATH = "./images/";

    public static String getPath(Uid object) {
        return ROOT_PATH + object.getUuid() + "/";
    }

    private static void createFolder(Uid object) {
        String objPath = getPath(object);
        File objectFolder = new File(objPath);
        if (!objectFolder.exists()) {
            objectFolder.mkdirs();
        }
    }

    public static void uploadImage(File image, Uid object) {
        String objPath = getPath(object);
        File objFolder = new File(objPath);
        createFolder(object);
        copyFile(image, object);

    }

    private static void copyFile(File image, Uid object) {
        String objPath = getPath(object);

        // image destination
        String imgPath = objPath + image.getName();
        File imgDest = new File(imgPath);
        if (!imgDest.exists()) {
            Path source = image.toPath();
            Path destination = imgDest.toPath();
            try {
                Files.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }

    public static Icon photoPost(File file) {
        ImageIcon imageIcon = new ImageIcon(file.getPath());
        Image img = imageIcon.getImage();
        int w = imageIcon.getIconWidth();
        int h = imageIcon.getIconHeight();
        Dimension imgDim = new Dimension(w, h);
        Dimension boundary = new Dimension(600, 400);
        Dimension newDim = getScaledDimension(imgDim, boundary);
        Image newImg = img.getScaledInstance((int) newDim.getWidth(), (int) newDim.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    public static Icon profilePic(File file) {
        ImageIcon imageIcon = new ImageIcon(file.getPath());
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

}
