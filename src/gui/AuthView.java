package gui;

import Listeners.DeletePostListener;
import Listeners.EditBioListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import social.Database;
import social.Group;
import social.PhotoPost;
import social.User;
import utils.Messages;
import utils.Validators;
import social.Post;
import social.TextPost;
import utils.Images;
import utils.WindowTitles;
import utils.Wrapers;

/**
 *
 * @author bmvin
 */
public class AuthView extends javax.swing.JFrame {

    private User currentUser;
    private Database db;

    /**
     * Creates new form AuthView
     *
     * @param user current User
     * @param db application database reference
     */
    public AuthView(User user, Database db) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.currentUser = user;
        this.db = db;

        // SET APP TITLE
        setTitle(WindowTitles.usersNameWindowTitle(this.currentUser.getName()));

        // PROFILE PANE
        // ProfilePanel - Handles Name, Profile Pic and Bio
        updateProfilePanel();

        updateFeed();

        // NOTIFICATION PANE
        showNotificationPanel();

        // FRIENDS PANE
        showFriendsPanel();

        // GROUPS PANE
        showGroupPanel();

        // EXIT LISTENER
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                db.serializeData();
                dispose();
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        profilePane = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        bioLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        postsList = new javax.swing.JList<>();
        makePostLabel = new javax.swing.JLabel();
        clearPostButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        postTextArea = new javax.swing.JTextArea();
        makePostButton = new javax.swing.JButton();
        addPhotoButton = new javax.swing.JButton();
        publicPostToggle = new javax.swing.JCheckBox();
        editBioButton = new javax.swing.JToggleButton();
        profilePic = new javax.swing.JLabel();
        notificationPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        requetsList = new javax.swing.JList<>();
        friendsPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        friendsList = new javax.swing.JList<>();
        groupsPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        usersGroupList = new javax.swing.JList<>();
        createGroupButton = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        photosPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        nameSearchLabel = new javax.swing.JLabel();
        nameSearchField = new javax.swing.JTextField();
        nameSearchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchFriendsList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        searchGroupsList = new javax.swing.JList<>();
        optionsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        tabPane.setMinimumSize(new java.awt.Dimension(0, 0));
        tabPane.setPreferredSize(new java.awt.Dimension(800, 600));

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        bioLabel.setText("Bio:");

        bioTextArea.setColumns(20);
        bioTextArea.setRows(5);
        jScrollPane1.setViewportView(bioTextArea);

        postsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        postsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postsListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(postsList);

        makePostLabel.setText("Make a Post:");

        clearPostButton.setText("Clear");
        clearPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPostButtonActionPerformed(evt);
            }
        });

        postTextArea.setColumns(20);
        postTextArea.setRows(5);
        jScrollPane6.setViewportView(postTextArea);

        makePostButton.setText("Make Post");
        makePostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePostButtonActionPerformed(evt);
            }
        });

        addPhotoButton.setText("Post a Photo");
        addPhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPhotoButtonActionPerformed(evt);
            }
        });

        publicPostToggle.setText("Public Post");

        editBioButton.setText("Edit");

        profilePic.setMaximumSize(new java.awt.Dimension(150, 200));
        profilePic.setMinimumSize(new java.awt.Dimension(150, 200));
        profilePic.setPreferredSize(new java.awt.Dimension(150, 200));
        profilePic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout profilePaneLayout = new javax.swing.GroupLayout(profilePane);
        profilePane.setLayout(profilePaneLayout);
        profilePaneLayout.setHorizontalGroup(
            profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(profilePaneLayout.createSequentialGroup()
                                .addComponent(makePostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(clearPostButton))
                            .addComponent(jScrollPane6)
                            .addGroup(profilePaneLayout.createSequentialGroup()
                                .addComponent(makePostButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addPhotoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(publicPostToggle))))
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(profilePaneLayout.createSequentialGroup()
                                .addComponent(bioLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editBioButton))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        profilePaneLayout.setVerticalGroup(
            profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bioLabel)
                            .addComponent(editBioButton))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(profilePic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makePostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearPostButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makePostButton)
                            .addComponent(addPhotoButton)
                            .addComponent(publicPostToggle))))
                .addContainerGap())
        );

        tabPane.addTab("Profile", profilePane);

        requetsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                requetsListMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(requetsList);

        javax.swing.GroupLayout notificationPanelLayout = new javax.swing.GroupLayout(notificationPanel);
        notificationPanel.setLayout(notificationPanelLayout);
        notificationPanelLayout.setHorizontalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        notificationPanelLayout.setVerticalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabPane.addTab("Notifications", notificationPanel);

        friendsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendsListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(friendsList);

        javax.swing.GroupLayout friendsPanelLayout = new javax.swing.GroupLayout(friendsPanel);
        friendsPanel.setLayout(friendsPanelLayout);
        friendsPanelLayout.setHorizontalGroup(
            friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        friendsPanelLayout.setVerticalGroup(
            friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabPane.addTab("Friends", friendsPanel);

        usersGroupList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        usersGroupList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersGroupListMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(usersGroupList);

        createGroupButton.setText("Create Group");
        createGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createGroupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout groupsPanelLayout = new javax.swing.GroupLayout(groupsPanel);
        groupsPanel.setLayout(groupsPanelLayout);
        groupsPanelLayout.setHorizontalGroup(
            groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(groupsPanelLayout.createSequentialGroup()
                        .addComponent(createGroupButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        groupsPanelLayout.setVerticalGroup(
            groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groupsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createGroupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabPane.addTab("Groups", groupsPanel);

        photosPanel.setLayout(new javax.swing.BoxLayout(photosPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane9.setViewportView(photosPanel);

        tabPane.addTab("Photos", jScrollPane9);

        nameSearchLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameSearchLabel.setText("Search:");

        nameSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameSearchFieldKeyPressed(evt);
            }
        });

        nameSearchButton.setText("Search");
        nameSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameSearchButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Find Friends:");

        searchFriendsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchFriendsList.setToolTipText("");
        searchFriendsList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchFriendsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFriendsListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(searchFriendsList);

        jLabel2.setText("Be part of a group:");

        searchGroupsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchGroupsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchGroupsListMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(searchGroupsList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nameSearchLabel)
                        .addGap(18, 18, 18)
                        .addComponent(nameSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(nameSearchField)
                    .addComponent(nameSearchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabPane.addTab("Search", searchPanel);

        optionsPanel.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logoutButton, java.awt.BorderLayout.PAGE_START);

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(exitButton, java.awt.BorderLayout.PAGE_END);

        optionsPanel.add(jPanel1, new java.awt.GridBagConstraints());

        tabPane.addTab("Options", optionsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        this.db.serializeData();
        PublicView pv = new PublicView(this.db);
        pv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        this.db.serializeData();
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void doNameSearch() {
        String nameSearch = "";

        clearSearchFriendsList();
        clearSeachGroupsList();

        //validate input
        nameSearch = nameSearchField.getText().trim();

        if (!Validators.checkNotEmptyStringNotNull(nameSearch)) {
            JOptionPane.showMessageDialog(this, Messages.EMPTY_NAME_SEARCH_FIELD, "Empty name", JOptionPane.WARNING_MESSAGE);
        } else {
            HashMap<String, User> searchResult = this.db.searchUsersByName(nameSearch);
            if (searchResult != null) {
                DefaultListModel<User> dlm = new DefaultListModel<User>();
                for (String key : searchResult.keySet()) {
                    if (!key.equals(this.currentUser.getUuid())) {
                        dlm.addElement(searchResult.get(key));

                    }
                }
                searchFriendsList.setModel(dlm);
            } else {
                JOptionPane.showMessageDialog(this, Messages.NO_USERS_FOUND_WITH_THAT_NAME, "Users Not Found", JOptionPane.WARNING_MESSAGE);
            }

            HashMap<String, Group> groupSearchResult = this.db.searchGroupByName(nameSearch);
            if (groupSearchResult != null) {
                DefaultListModel<Group> gdlm = new DefaultListModel<Group>();
                for (String groupKey : groupSearchResult.keySet()) {

                    gdlm.addElement(groupSearchResult.get(groupKey));

                }
                searchGroupsList.setModel(gdlm);
            } else {
                JOptionPane.showMessageDialog(this, Messages.NO_GROUPS_FOUND_WITH_THAT_NAME, "Groups Not Found.", JOptionPane.WARNING_MESSAGE);
            }

        }
    }


    private void nameSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameSearchButtonActionPerformed
        doNameSearch();
    }//GEN-LAST:event_nameSearchButtonActionPerformed

    private void clearSeachGroupsList() {
        DefaultListModel<Group> dlm = new DefaultListModel<>();
        searchGroupsList.setModel(dlm);
    }

    private void clearSearchFriendsList() {
        DefaultListModel<User> dlm = new DefaultListModel<User>();
        searchFriendsList.setModel(dlm);
    }

    private void searchFriendsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFriendsListMouseClicked
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() != 0) {
            int index = list.locationToIndex(evt.getPoint());
            User selectedUser = (User) list.getModel().getElementAt(index);
            if (selectedUser != null) {
                PublicProfile pp = new PublicProfile(this, true, selectedUser, this.currentUser, this.db);
            }
        }
    }//GEN-LAST:event_searchFriendsListMouseClicked

    private void nameSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameSearchFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            doNameSearch();
        }
    }//GEN-LAST:event_nameSearchFieldKeyPressed

    private void showNotificationPanel() {
        int nNotifications = this.currentUser.getRequests().size();
        tabPane.setTitleAt(1, "Notifications (" + nNotifications + ")");

        DefaultListModel<User> requests = new DefaultListModel<User>();
        for (String key : this.currentUser.getRequests()) {
            User u = this.db.getUserById(key);
            if (u != null) {
                requests.addElement(u);
            }
        }

        requetsList.setModel(requests);
    }

    private void requetsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requetsListMouseClicked
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() != 0) {
            int index = list.locationToIndex(evt.getPoint());
            User selectedUser = (User) list.getModel().getElementAt(index);
            if (selectedUser != null) {
                RequestDialog rd = new RequestDialog(this, true, selectedUser, this.currentUser);
            }
        }
        showNotificationPanel();
        showFriendsPanel();
    }//GEN-LAST:event_requetsListMouseClicked

    private void friendsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendsListMouseClicked
        // TODO add your handling code here:
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() != 0) {
            int index = list.locationToIndex(evt.getPoint());
            User selectedUser = (User) list.getModel().getElementAt(index);
            if (selectedUser != null) {
                PublicProfile pp = new PublicProfile(this, true, selectedUser, this.currentUser, this.db);
            }
        }
    }//GEN-LAST:event_friendsListMouseClicked

    private void profilePicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicMouseClicked
        // TODO add your handling code here:
        if (this.currentUser != null) {
            File file = new social.ImagePicker(this).pickImage();

            if (file != null) {
                Images.uploadImage(file, currentUser);
                File profilePhoto;
                profilePhoto = new File(Images.getPath(currentUser) + file.getName());
                this.currentUser.setProfilePicture(profilePhoto);
            }

            showProfilePic();
        }
    }//GEN-LAST:event_profilePicMouseClicked

    private void makePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePostButtonActionPerformed
        String content = "";
        boolean isPublic = false;

        if (publicPostToggle.isSelected()) {
            isPublic = true;
        }

        content = postTextArea.getText();
        if (Validators.checkNotEmptyStringNotNull(content)) {
            // add post
            Post post = new TextPost(currentUser, null, isPublic, content);
            this.currentUser.addPost(post);
            updateFeed();
            clearPostFields();
        }


    }//GEN-LAST:event_makePostButtonActionPerformed

    private void clearPostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearPostButtonActionPerformed
        clearPostFields();
    }//GEN-LAST:event_clearPostButtonActionPerformed

    private void postsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postsListMouseClicked
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() != 0) {
            int index = list.locationToIndex(evt.getPoint());
            TextPost selectedPost = (TextPost) list.getModel().getElementAt(index);
            if (selectedPost != null) {
                PostView pv = new PostView(this, true, selectedPost, currentUser, currentUser);
                updateFeed();
            }
        }
    }//GEN-LAST:event_postsListMouseClicked

    private void createGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createGroupButtonActionPerformed

        CreateGroupDialog gd = new CreateGroupDialog(this, true, currentUser, this.db);
        showGroupPanel();
    }//GEN-LAST:event_createGroupButtonActionPerformed

    private void usersGroupListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersGroupListMouseClicked

        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() != 0) {
            int index = list.locationToIndex(evt.getPoint());
            Group selectedGroup = (Group) list.getModel().getElementAt(index);
            if (selectedGroup != null) {

                GroupView gv = new GroupView(this, true, selectedGroup, currentUser, this.db);

                showGroupPanel();
            }
        }

    }//GEN-LAST:event_usersGroupListMouseClicked

    private void searchGroupsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGroupsListMouseClicked
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() != 0) {
            int index = list.locationToIndex(evt.getPoint());
            Group selectedGroup = (Group) list.getModel().getElementAt(index);
            if (selectedGroup != null) {
                if (selectedGroup.isMember(currentUser.getUuid())) {
                    GroupView gv = new GroupView(this, true, selectedGroup, currentUser, this.db);
                } else {
                    GroupRequestDialog grd = new GroupRequestDialog(this, true, selectedGroup, currentUser);

                }
            }
        }
    }//GEN-LAST:event_searchGroupsListMouseClicked

    private void addPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPhotoButtonActionPerformed
        // ADD PHOTO
        boolean publicPhoto = false;

        if (publicPostToggle.isSelected()) {
            publicPhoto = true;
        }

        File file = new social.ImagePicker(this).pickImage();

        if (file != null) {
            Images.uploadImage(file, currentUser);

            File uploadedPhoto;
            uploadedPhoto = new File(Images.getPath(currentUser) + file.getName());

            Post pp = new PhotoPost(currentUser, null, publicPhoto, uploadedPhoto);
            currentUser.addPost(pp);

        }

        updateFeed();
        db.serializeData();
    }//GEN-LAST:event_addPhotoButtonActionPerformed

    private void clearPostFields() {
        postTextArea.setText("");
        publicPostToggle.setSelected(false);
    }

    private void showFriendsPanel() {
        DefaultListModel<User> friends = new DefaultListModel<>();

        for (String key : this.currentUser.getFriends()) {
            User u = this.db.getUserById(key);
            friends.addElement(u);
        }

        friendsList.setModel(friends);
        tabPane.setTitleAt(2, "Friends (" + this.currentUser.getFriends().size() + ")");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPhotoButton;
    private javax.swing.JLabel bioLabel;
    private javax.swing.JTextArea bioTextArea;
    private javax.swing.JButton clearPostButton;
    private javax.swing.JButton createGroupButton;
    private javax.swing.JToggleButton editBioButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JList<User> friendsList;
    private javax.swing.JPanel friendsPanel;
    private javax.swing.JPanel groupsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton makePostButton;
    private javax.swing.JLabel makePostLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nameSearchButton;
    private javax.swing.JTextField nameSearchField;
    private javax.swing.JLabel nameSearchLabel;
    private javax.swing.JPanel notificationPanel;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JPanel photosPanel;
    private javax.swing.JTextArea postTextArea;
    private javax.swing.JList<Post> postsList;
    private javax.swing.JPanel profilePane;
    private javax.swing.JLabel profilePic;
    private javax.swing.JCheckBox publicPostToggle;
    private javax.swing.JList<User> requetsList;
    private javax.swing.JList<User> searchFriendsList;
    private javax.swing.JList<Group> searchGroupsList;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JList<Group> usersGroupList;
    // End of variables declaration//GEN-END:variables

    // PROFILE PANE METHODS
    private void updateProfilePanel() {
        // Name Label
        nameLabel.setText(this.currentUser.getName());

        // Bio Text Area
        bioTextArea.setEditable(false);
        EditBioListener listener = new EditBioListener(currentUser, editBioButton, bioTextArea);
        editBioButton.addActionListener(listener);

        // Profile Pic
        showProfilePic();
    }

    /**
     *
     */
    public void showProfilePic() {
        File pic = currentUser.getProfilePic();
        if (pic == null || !pic.exists()) {
            profilePic.setText(Wrapers.htmlWraper("No Profile Picture Found. <br> Click Here to add one."));
        } else {
            profilePic.setIcon(Images.profilePic(pic));
            profilePic.setText(null);
        }
    }

    private void updateFeed() {
        photosPanel.removeAll();

        DefaultListModel<Post> textPostsModel = new DefaultListModel<Post>();

        for (Post p : this.currentUser.getPosts()) {
            if (p instanceof TextPost) {
                textPostsModel.addElement(p);
            } else if (p instanceof PhotoPost) {
                PhotoPost pp = (PhotoPost) p;
                PhotoPostView ppv = new PhotoPostView(pp, currentUser);
                ppv.setListener(new DeletePostListener() {
                    @Override
                    public void deletePost(Post p, User currentUser) {
                        currentUser.removePost(pp);
                        updateFeed();
                    }
                });
                photosPanel.add(ppv);
            }

        }

        postsList.setModel(textPostsModel);

        photosPanel.repaint();
        photosPanel.revalidate();
    }

    private void showGroupPanel() {
        DefaultListModel<Group> groups = new DefaultListModel<>();

        for (String key : this.currentUser.getGroups()) {
            Group gp = this.db.getGroupById(key);
            groups.addElement(gp);
        }

        usersGroupList.setModel(groups);
    }

}
