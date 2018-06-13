package gui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import social.Database;
import social.User;
import social.Post;
import social.UserInteraction;
import utils.Images;
import utils.Validators;
import utils.Wrapers;

public class PublicProfile extends javax.swing.JDialog {

    private User targetUser;
    private User originUser;
    private Database db;

    /**
     * Creates new form PublicProfile
     *
     * @param parent
     * @param modal
     * @param target User's information
     * @param origin From where the 'request' is from
     * @param db Database instace
     */
    public PublicProfile(java.awt.Frame parent, boolean modal, User target, User origin, Database db) {
        super(parent, modal);
        initComponents();
        this.targetUser = target;
        this.originUser = origin;
        this.db = db;

        setLocationRelativeTo(parent);
        setTitle("Social App - " + this.targetUser.getName());
        nameLabel.setText(this.targetUser.getName());

        showInfo();
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

        nameLabel = new javax.swing.JLabel();
        addFriendButton = new javax.swing.JButton();
        blockUserButton = new javax.swing.JButton();
        unblockUserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        postsList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        bioArea = new javax.swing.JTextArea();
        profilePic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        addFriendButton.setText("Add as Friend");
        addFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendButtonActionPerformed(evt);
            }
        });

        blockUserButton.setText("Block User");
        blockUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockUserButtonActionPerformed(evt);
            }
        });

        unblockUserButton.setText("Unblock User");
        unblockUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unblockUserButtonActionPerformed(evt);
            }
        });

        postsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        postsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postsListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(postsList);

        bioArea.setColumns(20);
        bioArea.setRows(5);
        jScrollPane2.setViewportView(bioArea);

        profilePic.setMaximumSize(new java.awt.Dimension(150, 200));
        profilePic.setMinimumSize(new java.awt.Dimension(150, 200));
        profilePic.setPreferredSize(new java.awt.Dimension(150, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addFriendButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blockUserButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unblockUserButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addFriendButton)
                            .addComponent(blockUserButton)
                            .addComponent(unblockUserButton))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showInfo() {
        // set bio if exists.
        setBioArea();

        // addFriend, Block and Unblock buttons logic.
        setAddFriendBlockFriendButtons();

        // users posts.
        setUsersPosts();
    }

    public void setBioArea() {
        bioArea.setEditable(false);
        String bio = targetUser.getBio();
        if (Validators.checkNotEmptyStringNotNull(bio)) {
            bioArea.setText(bio);
        }

//        if (!Validators.checkNotEmptyStringNotNull(this.targetUser.getProfilePic())) {
//            profilePic.setText(Wrapers.htmlWraper("No Profile Picture Found. \n Click Here to add one."));
//        } else {
//            profilePic.setIcon(Images.profilePic(this.targetUser.getProfilePic()));
//            profilePic.setText(null);
//        }
    }

    public void setAddFriendBlockFriendButtons() {
        // addFriend, blockUser buttons logic
        if (this.originUser.userIsBlocked(this.targetUser.getUuid())) {
            blockUserButton.setVisible(false);
            addFriendButton.setVisible(false);
            unblockUserButton.setVisible(true);
        } else {
            if (this.targetUser.getRequests().contains(this.originUser.getUuid())) {
                addFriendButton.setVisible(false);
            } else {
                addFriendButton.setVisible(true);
            }
            blockUserButton.setVisible(true);
            unblockUserButton.setVisible(false);
        }
        // blocked by person
        if (this.targetUser.userIsBlocked(this.originUser.getUuid())) {
            addFriendButton.setVisible(false);
            blockUserButton.setVisible(false);
            unblockUserButton.setVisible(false);
        }
        if (this.originUser.getFriends().contains(this.targetUser.getUuid())) {
            addFriendButton.setVisible(false);
        }
    }

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendButtonActionPerformed
        // TODO add your handling code here:
        UserInteraction.sendRequest(this.originUser, this.targetUser);
//        this.targetUser.sendRequest(this.originUser.getUuid());
        showInfo();
    }//GEN-LAST:event_addFriendButtonActionPerformed

    private void blockUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockUserButtonActionPerformed
        // TODO add your handling code here:
        this.originUser.blockUser(this.targetUser.getUuid());
        showInfo();
    }//GEN-LAST:event_blockUserButtonActionPerformed

    private void unblockUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unblockUserButtonActionPerformed
        // TODO add your handling code here:
        this.originUser.unblockUser(this.targetUser.getUuid());
        showInfo();
    }//GEN-LAST:event_unblockUserButtonActionPerformed

    private void postsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postsListMouseClicked
        // TODO add your handling code here:
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() != 0) {
            int index = list.locationToIndex(evt.getPoint());
            Post selectedPost = (Post) list.getModel().getElementAt(index);
            if (selectedPost != null) {
                PostView pd = new PostView(null, true, selectedPost, this.targetUser, this.originUser);
                setUsersPosts();
            }
        }
    }//GEN-LAST:event_postsListMouseClicked

    private void setUsersPosts() {
        DefaultListModel<Post> postsModel = new DefaultListModel<Post>();

        for (String key : this.targetUser.getPosts().keySet()) {
            Post p = this.targetUser.getPostById(key);
            // is friend. show everything
            if (targetUser.isFriendWith(originUser.getUuid())) {
                postsModel.addElement(p);
            } else {
                if (p.isPublic()) {
                    postsModel.addElement(p);
                }
            }
        }

        postsList.setModel(postsModel);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFriendButton;
    private javax.swing.JTextArea bioArea;
    private javax.swing.JButton blockUserButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JList<Post> postsList;
    private javax.swing.JLabel profilePic;
    private javax.swing.JButton unblockUserButton;
    // End of variables declaration//GEN-END:variables
}
