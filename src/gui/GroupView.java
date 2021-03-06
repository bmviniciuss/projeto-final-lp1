package gui;

import Listeners.DeletePostListener;
import java.awt.Frame;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import social.Database;
import social.Group;
import social.ImagePicker;
import social.PhotoPost;
import social.Post;
import social.TextPost;
import social.User;
import utils.Images;

/**
 *
 * @author bmvin
 */
public class GroupView extends javax.swing.JDialog {

    private Frame parentFrame;
    private Group group;
    private User currentUser;
    private Database db;

    /**
     * Creates new form GroupView
     *
     * @param parent
     * @param modal
     * @param group
     * @param currentUser
     * @param db
     */
    public GroupView(java.awt.Frame parent, boolean modal, Group group, User currentUser, Database db) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

        this.parentFrame = parent;
        this.group = group;
        this.currentUser = currentUser;
        this.db = db;

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
        gpName = new javax.swing.JLabel();
        requestsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gpDesc = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        postArea = new javax.swing.JTextArea();
        postButton = new javax.swing.JButton();
        postPhotoButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        membersList = new javax.swing.JList<>();
        blockedUsersButton = new javax.swing.JButton();
        feed = new javax.swing.JPanel();
        feedScroll = new javax.swing.JScrollPane();
        gpFeedPanel = new javax.swing.JPanel();
        photoPane = new javax.swing.JPanel();
        photoScroll = new javax.swing.JScrollPane();
        photosPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        requestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestsButtonActionPerformed(evt);
            }
        });

        gpDesc.setColumns(20);
        gpDesc.setRows(5);
        jScrollPane1.setViewportView(gpDesc);

        jLabel1.setText("Make a Post:");

        jLabel2.setText("Members:");

        postArea.setColumns(20);
        postArea.setLineWrap(true);
        postArea.setRows(5);
        jScrollPane2.setViewportView(postArea);

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

        membersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        membersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                membersListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(membersList);

        blockedUsersButton.setText("Blocked Users");
        blockedUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockedUsersButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPaneLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(mainPaneLayout.createSequentialGroup()
                        .addComponent(gpName, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(requestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPaneLayout.createSequentialGroup()
                        .addComponent(postButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(postPhotoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(blockedUsersButton))
                    .addGroup(mainPaneLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPaneLayout.setVerticalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(requestsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(gpName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postPhotoButton)
                    .addComponent(blockedUsersButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Main", mainPane);

        gpFeedPanel.setLayout(new javax.swing.BoxLayout(gpFeedPanel, javax.swing.BoxLayout.Y_AXIS));
        feedScroll.setViewportView(gpFeedPanel);

        javax.swing.GroupLayout feedLayout = new javax.swing.GroupLayout(feed);
        feed.setLayout(feedLayout);
        feedLayout.setHorizontalGroup(
            feedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
            .addGroup(feedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(feedScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        feedLayout.setVerticalGroup(
            feedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
            .addGroup(feedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(feedScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Feed", feed);

        photosPanel.setLayout(new javax.swing.BoxLayout(photosPanel, javax.swing.BoxLayout.Y_AXIS));
        photoScroll.setViewportView(photosPanel);

        javax.swing.GroupLayout photoPaneLayout = new javax.swing.GroupLayout(photoPane);
        photoPane.setLayout(photoPaneLayout);
        photoPaneLayout.setHorizontalGroup(
            photoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
            .addGroup(photoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(photoPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(photoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        photoPaneLayout.setVerticalGroup(
            photoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
            .addGroup(photoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(photoPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(photoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Photos", photoPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButtonActionPerformed

        String content = "";
        content = postArea.getText().trim();

        if (!content.equals("")) {
            TextPost p = new TextPost(currentUser, group, true, content);
            group.addPost(p);
            postArea.setText("");
        }

        populateFeed();
    }//GEN-LAST:event_postButtonActionPerformed

    private void membersListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_membersListMouseClicked
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() != 0) {
            int index = list.locationToIndex(evt.getPoint());
            User selectedUser = (User) list.getModel().getElementAt(index);
            if (selectedUser != null) {
                if (!selectedUser.getUuid().equals(currentUser.getUuid())) {
                    GroupMember gm = new GroupMember(parentFrame, true, currentUser, selectedUser, group, db);
                }
            }
        }
        showInfo();
    }//GEN-LAST:event_membersListMouseClicked

    private void requestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestsButtonActionPerformed
        GroupRequestsList grl = new GroupRequestsList(parentFrame, true, currentUser, group);
        showRequestCounter();
        showMembers();

    }//GEN-LAST:event_requestsButtonActionPerformed

    private void blockedUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockedUsersButtonActionPerformed
        GroupBlockedUsersDialog gbud = new GroupBlockedUsersDialog(parentFrame, true, currentUser, group, db);

    }//GEN-LAST:event_blockedUsersButtonActionPerformed

    private void postPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postPhotoButtonActionPerformed
        File file = new ImagePicker(null).pickImage();

        if (file != null) {
            Images.uploadImage(file, group);

            File uploadedPhoto;
            uploadedPhoto = new File(Images.getPath(group) + file.getName());

            PhotoPost pp = new PhotoPost(currentUser, group, false, uploadedPhoto);
            group.addPost(pp);

        }

        populateFeed();
        db.serializeData();

    }//GEN-LAST:event_postPhotoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blockedUsersButton;
    private javax.swing.JPanel feed;
    private javax.swing.JScrollPane feedScroll;
    private javax.swing.JTextArea gpDesc;
    private javax.swing.JPanel gpFeedPanel;
    private javax.swing.JLabel gpName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel mainPane;
    private javax.swing.JList<User> membersList;
    private javax.swing.JPanel photoPane;
    private javax.swing.JScrollPane photoScroll;
    private javax.swing.JPanel photosPanel;
    private javax.swing.JTextArea postArea;
    private javax.swing.JButton postButton;
    private javax.swing.JButton postPhotoButton;
    private javax.swing.JButton requestsButton;
    // End of variables declaration//GEN-END:variables

    private void showInfo() {
        setTitle(group.getGroupName() + " - " + group.getGroupDescription());
        gpName.setText(group.getGroupName());
        gpDesc.setText(group.getGroupDescription());
        gpDesc.setEditable(false);
        requestsButton.setVisible(false);
        blockedUsersButton.setVisible(false);

        if (group.isAdmin(currentUser.getUuid())) {
            if (group.numberRequests() > 0) {

                requestsButton.setVisible(true);
                showRequestCounter();
            }
            if (group.getBlocked().size() > 0) {
                blockedUsersButton.setVisible(true);
            }
        }

        // Populate Feed
        populateFeed();

        // update members
        showMembers();

    }

    private void showMembers() {
        DefaultListModel<User> members = new DefaultListModel<>();

        for (String key : this.group.getGroupMembers().keySet()) {
            User u = this.group.getMemberById(key);
            members.addElement(u);
        }

        membersList.setModel(members);
    }

    private void showRequestCounter() {
        int counter = 0;
        counter = group.numberRequests();

        requestsButton.setText("Requests (" + counter + ")");
    }

    private void populateFeed() {
        gpFeedPanel.removeAll();
        photosPanel.removeAll();

        for (Post p : this.group.getGroupPosts()) {
            if (p instanceof TextPost) {
                TextPost tx = (TextPost) p;
                GroupPostView spv = new GroupPostView(tx, currentUser, group);
                spv.setListener(new DeletePostListener() {
                    @Override
                    public void deletePost(Post p, User currentUser) {
                        group.removePost(p, currentUser);
                        populateFeed();
                    }
                });
                gpFeedPanel.add(spv);
            } else if (p instanceof PhotoPost) {
                PhotoPost pp = (PhotoPost) p;
                PhotoPostView ppv = new PhotoPostView(pp, currentUser, currentUser, group);
                ppv.setListener(new DeletePostListener() {
                    @Override
                    public void deletePost(Post p, User currentUser) {
                        group.removePost(pp, currentUser);
                        populateFeed();
                    }
                });
                photosPanel.add(ppv);
            }
        }

        gpFeedPanel.repaint();
        gpFeedPanel.revalidate();
        
        photosPanel.repaint();
        photosPanel.revalidate();
    }

}
