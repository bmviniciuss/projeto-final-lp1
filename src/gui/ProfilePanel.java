/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;
import social.Database;
import social.Post;
import social.User;

/**
 *
 * @author bmvin
 */
public class ProfilePanel extends javax.swing.JPanel {

    private JFrame parent;
    private User currentUser;
    private Database db;

    /**
     * Creates new form ProfilePanel
     */
    public ProfilePanel() {
        initComponents();
        
        updateProfilePic();
        updateProfileName();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        bioLabel = new javax.swing.JLabel();
        editBioButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        postList = new javax.swing.JList<>();
        makePostLabel = new javax.swing.JLabel();
        clearPostButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        postTextArea = new javax.swing.JTextArea();
        makePostButton = new javax.swing.JButton();
        addPhotoButton = new javax.swing.JButton();
        publicPostToggle = new javax.swing.JCheckBox();

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        bioLabel.setText("Bio:");

        editBioButton.setText("Edit");

        bioTextArea.setColumns(20);
        bioTextArea.setRows(5);
        jScrollPane1.setViewportView(bioTextArea);

        postList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(postList);

        makePostLabel.setText("Make a Post:");

        clearPostButton.setText("Clear");

        postTextArea.setColumns(20);
        postTextArea.setRows(5);
        jScrollPane3.setViewportView(postTextArea);

        makePostButton.setText("Make Post");

        addPhotoButton.setText("Add Photo");

        publicPostToggle.setText("Public Post");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(makePostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(clearPostButton))
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(makePostButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addPhotoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(publicPostToggle))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bioLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editBioButton))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bioLabel)
                    .addComponent(editBioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makePostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearPostButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makePostButton)
                            .addComponent(addPhotoButton)
                            .addComponent(publicPostToggle))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPhotoButton;
    private javax.swing.JLabel bioLabel;
    private javax.swing.JTextArea bioTextArea;
    private javax.swing.JButton clearPostButton;
    private javax.swing.JButton editBioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton makePostButton;
    private javax.swing.JLabel makePostLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JList<Post> postList;
    private javax.swing.JTextArea postTextArea;
    private javax.swing.JCheckBox publicPostToggle;
    // End of variables declaration//GEN-END:variables

    /**
     * @param parent the parent to set
     */
    public void setParent(JFrame parent) {
        this.parent = parent;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * @param db the db to set
     */
    public void setDb(Database db) {
        this.db = db;
    }

    private void updateProfilePic() {
        System.out.println("ProfilePanel ProfilePic");
    }

    private void updateProfileName() {
        nameLabel.setName(this.currentUser.getName());
    }
}
