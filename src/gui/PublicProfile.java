package gui;

import Listeners.DeletePostListener;
import java.awt.Frame;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import social.Database;
import social.PhotoPost;
import social.User;
import social.Post;
import social.TextPost;
import social.UserInteraction;
import utils.Images;
import utils.Validators;
import utils.WindowTitles;
import utils.Wrapers;

/**
 * Creates a Public Profile View
 *
 * @author bmvin
 */
public class PublicProfile extends javax.swing.JDialog {

    private Frame parent;
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
        this.parent = parent;

        setLocationRelativeTo(parent);
        setTitle(WindowTitles.usersNameWindowTitle(targetUser.getName()));

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        mainPane = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        addFriendButton = new javax.swing.JButton();
        blockUserButton = new javax.swing.JButton();
        unblockUserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        postsList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        bioArea = new javax.swing.JTextArea();
        profilePic = new javax.swing.JLabel();
        postButton = new javax.swing.JButton();
        postPhotoButton = new javax.swing.JButton();
        photos = new javax.swing.JPanel();
        photosPane = new javax.swing.JScrollPane();
        photosPanel = new javax.swing.JPanel();

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

        postButton.setText("Post");
        postButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });

        postPhotoButton.setText("Post a Photo");
        postPhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postPhotoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 691, Short.MAX_VALUE)
            .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(mainPaneLayout.createSequentialGroup()
                            .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2)
                                .addGroup(mainPaneLayout.createSequentialGroup()
                                    .addComponent(addFriendButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(postButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(postPhotoButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(blockUserButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(unblockUserButton)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap()))
        );
        mainPaneLayout.setVerticalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
            .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPaneLayout.createSequentialGroup()
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addFriendButton)
                                .addComponent(blockUserButton)
                                .addComponent(unblockUserButton)
                                .addComponent(postButton)
                                .addComponent(postPhotoButton))))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Main", mainPane);

        photosPanel.setLayout(new javax.swing.BoxLayout(photosPanel, javax.swing.BoxLayout.Y_AXIS));
        photosPane.setViewportView(photosPanel);

        javax.swing.GroupLayout photosLayout = new javax.swing.GroupLayout(photos);
        photos.setLayout(photosLayout);
        photosLayout.setHorizontalGroup(
            photosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 691, Short.MAX_VALUE)
            .addGroup(photosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(photosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(photosPane, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        photosLayout.setVerticalGroup(
            photosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
            .addGroup(photosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(photosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(photosPane, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Photos", photos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showInfo() {
        nameLabel.setText(this.targetUser.getName());

        showProfilePicture();

        // set bio if exists.
        setBioArea();

        // addFriend, Block and Unblock buttons logic.
        setAddFriendBlockFriendButtons();

        // users posts.
        setUsersPosts();
    }

    /**
     *
     */
    public void setBioArea() {
        bioArea.setEditable(false);
        String bio = targetUser.getBio();
        if (Validators.checkNotEmptyStringNotNull(bio)) {
            bioArea.setText(bio);
        }
    }

    /**
     *
     */
    public void setAddFriendBlockFriendButtons() {
        // addFriend, blockUser buttons logic
        // user is blocked
        if (this.originUser.userIsBlocked(this.targetUser.getUuid())) {
            blockUserButton.setVisible(false);
            addFriendButton.setVisible(false);
            postButton.setVisible(false);
            postPhotoButton.setVisible(false);

        } else {
            if (this.targetUser.getRequests().contains(this.originUser.getUuid())) {
                addFriendButton.setVisible(false);
                postButton.setVisible(false);
                postPhotoButton.setVisible(false);
            } else {
                addFriendButton.setVisible(true);
                postButton.setVisible(false);
                postPhotoButton.setVisible(false);
            }
            blockUserButton.setVisible(true);
            unblockUserButton.setVisible(false);
            postButton.setVisible(false);
            postPhotoButton.setVisible(false);
        }
        // blocked by person
        if (this.targetUser.userIsBlocked(this.originUser.getUuid())) {
            addFriendButton.setVisible(false);
            blockUserButton.setVisible(false);
            unblockUserButton.setVisible(false);
            postButton.setVisible(false);
            postPhotoButton.setVisible(false);
        }
        if (this.originUser.getFriends().contains(this.targetUser.getUuid())) {
            addFriendButton.setVisible(false);
            postButton.setVisible(true);
            postPhotoButton.setVisible(true);
        }

        if (this.originUser.getBlockedUsers().contains(targetUser.getUuid())) {
            unblockUserButton.setVisible(true);
        } else {
            unblockUserButton.setVisible(false);

        }
    }

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendButtonActionPerformed
        // TODO add your handling code here:
        UserInteraction.sendRequest(this.originUser, this.targetUser);

        showInfo();
    }//GEN-LAST:event_addFriendButtonActionPerformed

    private void blockUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockUserButtonActionPerformed
        this.originUser.blockUser(this.targetUser.getUuid());
        this.targetUser.blockUser(this.originUser.getUuid());
        this.originUser.addBlockedUser(this.targetUser.getUuid());
        showInfo();
        setAddFriendBlockFriendButtons();
    }//GEN-LAST:event_blockUserButtonActionPerformed

    private void unblockUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unblockUserButtonActionPerformed
        this.originUser.unblockUser(this.targetUser.getUuid());
        this.targetUser.unblockUser(this.originUser.getUuid());
        this.originUser.removeBlockedUser(this.targetUser.getUuid());
        showInfo();
        setAddFriendBlockFriendButtons();
    }//GEN-LAST:event_unblockUserButtonActionPerformed

    private void postsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postsListMouseClicked
        // TODO add your handling code here:
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() != 0) {
            int index = list.locationToIndex(evt.getPoint());
            TextPost selectedPost = (TextPost) list.getModel().getElementAt(index);
            if (selectedPost != null) {
                PostView pd = new PostView(parent, true, selectedPost, this.targetUser, this.originUser);
                setUsersPosts();
            }
        }
    }//GEN-LAST:event_postsListMouseClicked

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButtonActionPerformed
        // TODO add your handling code here:
        AddPostDialog postDialog = new AddPostDialog(parent, true, originUser, targetUser);
        setUsersPosts();
    }//GEN-LAST:event_postButtonActionPerformed

    private void postPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postPhotoButtonActionPerformed
        File photo = new social.ImagePicker(null).pickImage();
        if (photo != null) {
            Images.uploadImage(photo, targetUser);

            File uploadedPhoto;
            uploadedPhoto = new File(Images.getPath(targetUser) + photo.getName());

            Post pp = new PhotoPost(originUser, null, false, uploadedPhoto);
            targetUser.addPost(pp);
        }
        setUsersPosts();
    }//GEN-LAST:event_postPhotoButtonActionPerformed

    /**
     * Show targetUser's posts.
     */
    private void setUsersPosts() {
        // ceck if user is not blocked
        if (!targetUser.userIsBlocked(originUser.getUuid()) && !originUser.userIsBlocked(targetUser.getUuid())) {
            DefaultListModel<Post> postsModel = new DefaultListModel<Post>();

            photosPanel.removeAll();

            for (Post p : this.targetUser.getPosts()) {
                if (p instanceof TextPost) {
                    TextPost tp = (TextPost) p;
                    if (targetUser.isFriendWith(originUser.getUuid())) {
                        postsModel.addElement(tp);
                    } else {
                        if (tp.isPublic()) {
                            postsModel.addElement(tp);
                        }
                    }

                } else if (p instanceof PhotoPost) {
                    PhotoPost pp = (PhotoPost) p;

                    if (targetUser.isFriendWith(originUser.getUuid()) || pp.isPublic()) {
                        PhotoPostView ppv = new PhotoPostView(pp, targetUser, originUser, null);
                        ppv.setListener(new DeletePostListener() {
                            @Override
                            public void deletePost(Post p, User currentUser) {
                                targetUser.removePost(pp);
                                photosPanel.remove(ppv);
                                setUsersPosts();
                            }
                        });
                        photosPanel.add(ppv);
                    }

                }

            }

            postsList.setModel(postsModel);

            photosPanel.repaint();
            photosPanel.revalidate();

        }

    }

    /**
     * Display tagertUser's profile picture.
     */
    private void showProfilePicture() {
        File pic = targetUser.getProfilePic();
        if (pic == null || !pic.exists()) {
            profilePic.setText(Wrapers.htmlWraper("No Profile Picture Found."));
        } else {
            profilePic.setIcon(Images.profilePic(pic));
            profilePic.setText(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFriendButton;
    private javax.swing.JTextArea bioArea;
    private javax.swing.JButton blockUserButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel mainPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel photos;
    private javax.swing.JScrollPane photosPane;
    private javax.swing.JPanel photosPanel;
    private javax.swing.JButton postButton;
    private javax.swing.JButton postPhotoButton;
    private javax.swing.JList<Post> postsList;
    private javax.swing.JLabel profilePic;
    private javax.swing.JButton unblockUserButton;
    // End of variables declaration//GEN-END:variables

}
