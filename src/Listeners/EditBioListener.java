/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import social.User;


public class EditBioListener implements ActionListener {

    private User user;
    private JToggleButton button;
    private JTextArea textArea;

    /**
     * Create a bio editor listener
     * @param user
     * @param btn
     * @param tArea
     */
    public EditBioListener(User user, JToggleButton btn, JTextArea tArea) {
        this.user = user;
        this.button = btn;
        this.textArea = tArea;
    }

    /**
     * Change the bio field of the user.
     * @param ae
     */
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
