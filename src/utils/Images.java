/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author bmvin
 */
public class Images {

    public static Icon profilePic(String path) {
        ImageIcon imageIcon =  new ImageIcon(path);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

}
