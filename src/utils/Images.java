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
import social.Uid;
import social.User;

/**
 *
 * @author bmvin
 */
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
    public static Icon photoPost(File file) {
        ImageIcon imageIcon = new ImageIcon(file.getPath());
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(476, 301, Image.SCALE_DEFAULT);
        return new ImageIcon(newImg);
    }

    public static Icon profilePic(File file) {
        ImageIcon imageIcon = new ImageIcon(file.getPath());
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

}
