/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import social.User;

/**
 *
 * @author bmvin
 */
public class EditBioListener implements ActionListener {

    private User user;
    private JToggleButton button;
    private JTextArea textArea;

    public EditBioListener(User user, JToggleButton btn, JTextArea tArea) {
        this.user = user;
        this.button = btn;
        this.textArea = tArea;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (this.button.isSelected()) {
            this.textArea.setEditable(true);
            this.button.setText("Save");
        } else {
            this.textArea.setEditable(false);
            this.button.setText("Edit");
            String text = this.textArea.getText();
            this.user.setBio(text);
        }
        
        textArea.setText(this.user.getBio());
        
        
    }
}
