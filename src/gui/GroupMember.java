package gui;

import java.awt.Frame;
import java.io.File;
import social.Database;
import social.Group;
import social.User;
import utils.Images;
import utils.Wrapers;

/**
 * Group Member View with Group Controls
 *
 * @author bmvin
 */
public class GroupMember extends javax.swing.JDialog {

    private Database db;
    private User currentUser;
    private User targetUser;
    private Group currentGroup;
    private Frame parentFrame;

    /**
     * Creates new form GroupMember
     *
     * @param parent
     * @param modal
     * @param currentUser
     * @param targetUser
     * @param currentGroup
     * @param db
     */
    public GroupMember(java.awt.Frame parent, boolean modal, User currentUser, User targetUser, Group currentGroup, Database db) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(parent);
        this.currentUser = currentUser;
        this.targetUser = targetUser;
        this.currentGroup = currentGroup;
        this.db = db;
        this.parentFrame = parent;

        showInfo();
        setTitle(currentGroup.getGroupName() + " - " + targetUser.getName());
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilePic = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioArea = new javax.swing.JTextArea();
        deleteButton = new javax.swing.JButton();
        makeAdmiButton = new javax.swing.JButton();
        blockFromGroupButton = new javax.swing.JButton();
        viewProfileButton = new javax.swing.JButton();
        unblockButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        profilePic.setMaximumSize(new java.awt.Dimension(150, 200));
        profilePic.setMinimumSize(new java.awt.Dimension(150, 200));
        profilePic.setPreferredSize(new java.awt.Dimension(150, 200));

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        bioArea.setColumns(20);
        bioArea.setRows(5);
        jScrollPane1.setViewportView(bioArea);

        deleteButton.setText("Delete From Group");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        makeAdmiButton.setText("Make Admin");
        makeAdmiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeAdmiButtonActionPerformed(evt);
            }
        });

        blockFromGroupButton.setText("Block From Group");
        blockFromGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockFromGroupButtonActionPerformed(evt);
            }
        });

        viewProfileButton.setText("View Profile");
        viewProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProfileButtonActionPerformed(evt);
            }
        });

        unblockButton.setText("Unblock from Group");
        unblockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unblockButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewProfileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeAdmiButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blockFromGroupButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unblockButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(makeAdmiButton)
                    .addComponent(blockFromGroupButton)
                    .addComponent(viewProfileButton)
                    .addComponent(unblockButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProfileButtonActionPerformed
        PublicProfile pp = new PublicProfile(parentFrame, true, targetUser, currentUser, db);
        buttonsVisibility();
    }//GEN-LAST:event_viewProfileButtonActionPerformed

    private void blockFromGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockFromGroupButtonActionPerformed
        if (isAdmin(currentUser)) {
            currentGroup.addToBlocked(targetUser.getUuid());
            currentGroup.removeUser(currentUser, targetUser);
            targetUser.removeGroup(currentGroup.getUuid());
        }
        buttonsVisibility();
    }//GEN-LAST:event_blockFromGroupButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (isAdmin(currentUser)) {
            currentGroup.removeUser(currentUser, targetUser);
            targetUser.removeGroup(currentGroup.getUuid());
        }
        dispose();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void makeAdmiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeAdmiButtonActionPerformed
        if (isAdmin(currentUser)) {
            currentGroup.makeUserAdmin(targetUser.getUuid(), targetUser);
        }
        buttonsVisibility();
    }//GEN-LAST:event_makeAdmiButtonActionPerformed

    private void unblockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unblockButtonActionPerformed
        if (currentGroup.isInBlocked(targetUser.getUuid()) && isAdmin(currentUser)) {
            currentGroup.removeFromBlocked(targetUser.getUuid());
            dispose();
        }
    }//GEN-LAST:event_unblockButtonActionPerformed

    /**
     * Show Dialog's info
     */
    private void showInfo() {

        nameLabel.setText(targetUser.getName());

        bioArea.setEditable(false);
        bioArea.setText(targetUser.getBio());

        showProfilePic();

        buttonsVisibility();
    }

    /**
     * Check buttons visibility
     */
    private void buttonsVisibility() {
        viewProfileButton.setVisible(true);

        if (currentGroup.isAdmin(currentUser.getUuid())) {
            if (currentGroup.isAdmin(targetUser.getUuid())) {
                makeAdmiButton.setVisible(false);
            }
            if (!currentGroup.isInBlocked(targetUser.getUuid())) {
                blockFromGroupButton.setVisible(true);
                unblockButton.setVisible(false);
            }
            if (currentGroup.isMember(targetUser.getUuid())) {
                deleteButton.setVisible(true);
            }
            if (currentGroup.getOwner().getUuid().equals(targetUser.getUuid())) {
                deleteButton.setVisible(false);
                blockFromGroupButton.setVisible(false);
                makeAdmiButton.setVisible(false);
            }
            if (currentGroup.isInBlocked(targetUser.getUuid())) {
                makeAdmiButton.setVisible(false);
                blockFromGroupButton.setVisible(false);
                deleteButton.setVisible(false);
                unblockButton.setVisible(true);
                viewProfileButton.setVisible(true);
            }
        } else {
            deleteButton.setVisible(false);
            makeAdmiButton.setVisible(false);
            blockFromGroupButton.setVisible(false);
            unblockButton.setVisible(false);
        }

    }

    /**
     * Display User's profile picture
     */
    private void showProfilePic() {
        File pic = targetUser.getProfilePic();
        if (pic == null || !pic.exists()) {
            profilePic.setText(Wrapers.htmlWraper("No Profile Picture Found."));
        } else {
            profilePic.setIcon(Images.profilePic(pic));
            profilePic.setText(null);
        }
    }

    /**
     * Check if user is a group's Admin
     *
     * @param user
     * @return boolean
     */
    private boolean isAdmin(User user) {
        return currentGroup.isAdmin(user.getUuid());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bioArea;
    private javax.swing.JButton blockFromGroupButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton makeAdmiButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel profilePic;
    private javax.swing.JButton unblockButton;
    private javax.swing.JButton viewProfileButton;
    // End of variables declaration//GEN-END:variables

}
