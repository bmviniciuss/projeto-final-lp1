/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import social.Post;
import social.User;
import utils.Messages;
import utils.Validators;

/**
 *
 * @author bmvin
 */
public class AddPostDialog extends javax.swing.JDialog {
    private User originUser;
    private User targetUser; 
    
    /**
     * Creates new form AddPostDialog
     * @param parent
     * @param modal
     * @param originUser
     * @param targetUser
     */
    public AddPostDialog(java.awt.Frame parent, boolean modal, User originUser, User targetUser) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle(targetUser.getName());
        nameLabel.setText("Post to: " + targetUser.getName());
        this.originUser = originUser;
        this.targetUser = targetUser;
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        postArea = new javax.swing.JTextArea();
        nameLabel = new javax.swing.JLabel();
        postButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        postArea.setColumns(20);
        postArea.setRows(5);
        jScrollPane1.setViewportView(postArea);

        postButton.setText("Post");
        postButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(postButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postButton)
                    .addComponent(exitButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButtonActionPerformed
        // TODO add your handling code here:
        String content = "";
        String warnings = "";
        
        content = postArea.getText().trim();
        if(!Validators.checkNotEmptyStringNotNull(content)) {
            System.out.println("EMPTY");
            warnings += Messages.EMPTY_POST_ERROR;
        }
        
        if(!warnings.equals("")) {
             JOptionPane.showMessageDialog(this, warnings, Messages.EMPTY_POST, JOptionPane.WARNING_MESSAGE);
        } else {
            Post p = new Post(originUser, content, true);
            this.targetUser.addPost(p);
            this.dispose();
        }
    }//GEN-LAST:event_postButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextArea postArea;
    private javax.swing.JButton postButton;
    // End of variables declaration//GEN-END:variables
}