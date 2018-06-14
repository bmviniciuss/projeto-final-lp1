/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import social.User;

/**
 *
 * @author bmvin
 */
public class Images {

    public static final String ROOT_PATH = "./images/";

    public static String getUserPath(User user) {
        return ROOT_PATH + user.getUuid() + "/";
    }

    private static void createUserFolder(User user) {
        String userPath = getUserPath(user);
        File userFolder = new File(userPath);
        if (!userFolder.exists()) {
            userFolder.mkdirs();
        }
    }

    public static void uploadUserImage(File image, User user) {
        String userPath = getUserPath(user);
        File userFolder = new File(userPath);
        createUserFolder(user);
        copyFile(image, user);

    }

    private static void copyFile(File image, User user) {
        String userPath = getUserPath(user);

        // image destination
        String imgPath = userPath + image.getName();
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

    public static Icon profilePic(File file) {
        ImageIcon imageIcon = new ImageIcon(file.getPath());
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

}
