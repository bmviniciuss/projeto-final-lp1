package gui;

import java.awt.Frame;
import social.Comment;
import social.TextPost;
import social.User;
import utils.WindowTitles;

/**
 * Post View.
 * @author bmvin
 */
public class PostView extends javax.swing.JDialog {

    private TextPost post;
    private User owner;
    private User currentUser;
    private Frame parent;

    /**
     * Creates new form PostDialog
     *
     * @param parent
     * @param modal
     * @param post
     * @param currentUser
     * @param owner
     */
    public PostView(java.awt.Frame parent, boolean modal, TextPost post, User owner, User currentUser) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

        deletePostButton.setVisible(false);

        this.post = post;
        this.owner = owner;
        this.currentUser = currentUser;
        this.parent = parent;

        if (isOwner()) {
            deletePostButton.setVisible(true);
        }

        updateLikeButtonVisibility();

        showInfo();

        updatePostLikes();
        updateCommentsSection();

        setVisible(true);
    }

    private void updatePostLikes() {
        likesLabel.setText("Likes: " + this.post.numLikes());
        setTitle(WindowTitles.postWindowTitle(post));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        authorLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentArea = new javax.swing.JTextArea();
        likesLabel = new javax.swing.JLabel();
        deletePostButton = new javax.swing.JButton();
        likeButton = new javax.swing.JButton();
        dislikeButton = new javax.swing.JButton();
        makeCommentButton = new javax.swing.JButton();
        commentsScroll = new javax.swing.JScrollPane();
        commentsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        authorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        contentArea.setColumns(20);
        contentArea.setRows(5);
        jScrollPane1.setViewportView(contentArea);

        deletePostButton.setText("Delete Post");
        deletePostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePostButtonActionPerformed(evt);
            }
        });

        likeButton.setText("Like");
        likeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeButtonActionPerformed(evt);
            }
        });

        dislikeButton.setText("Dislike");
        dislikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dislikeButtonActionPerformed(evt);
            }
        });

        makeCommentButton.setText("Make Comment");
        makeCommentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeCommentButtonActionPerformed(evt);
            }
        });

        commentsPanel.setLayout(new javax.swing.BoxLayout(commentsPanel, javax.swing.BoxLayout.Y_AXIS));
        commentsScroll.setViewportView(commentsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(likeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dislikeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletePostButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeCommentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(likesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addComponent(commentsScroll)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(likeButton)
                        .addComponent(deletePostButton)
                        .addComponent(makeCommentButton)
                        .addComponent(dislikeButton))
                    .addComponent(likesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentsScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePostButtonActionPerformed
        if (isOwner()) {
            owner.removePost(post);

        }
        dispose();
    }//GEN-LAST:event_deletePostButtonActionPerformed

    private String getId() {
        String id = "";
        if (isOwner()) {
            id = this.owner.getUuid();
        } else {
            id = this.currentUser.getUuid();
        }

        return id;
    }

    private boolean isOwner() {

        if (owner.getUuid().equals(currentUser.getUuid()) || currentUser.getUuid().equals(post.getOwner().getUuid())) {
            return true;
        }
        return false;

    }

    private void updateLikeButtonVisibility() {
        String id = getId();

        likeButton.setVisible(true);
        dislikeButton.setVisible(false);

        if (!id.equals("")) {
            if (post.hasLiked(id)) {
                likeButton.setVisible(false);
                dislikeButton.setVisible(true);
            }
        }

    }

    private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeButtonActionPerformed
        String id = getId();

        if (!id.equals("")) {
            this.post.likePost(id);
        }
        updateLikeButtonVisibility();
        updatePostLikes();
    }//GEN-LAST:event_likeButtonActionPerformed

    private void makeCommentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeCommentButtonActionPerformed
        AddComment ac = new AddComment(parent, true, currentUser, post);
        updateCommentsSection();
    }//GEN-LAST:event_makeCommentButtonActionPerformed

    private void dislikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dislikeButtonActionPerformed

        String id = getId();

        if (!id.equals("")) {
            this.post.removeLike(id);
        }
        updateLikeButtonVisibility();
        updatePostLikes();
    }//GEN-LAST:event_dislikeButtonActionPerformed

    /**
     * Update post's comment section.
     */
    private void updateCommentsSection() {
        commentsPanel.removeAll();

        for (Comment comment : this.post.getComments()) {
            CommentView cv = new CommentView(comment, currentUser, post, commentsPanel);
            commentsPanel.add(cv);
        }

        commentsPanel.repaint();
        commentsPanel.revalidate();

    }
    
    /**
     * Display View's information.
     */
    private void showInfo() {
        authorLabel.setText(this.post.getOwner().getName());
        contentArea.setEditable(false);
        contentArea.setText(this.post.getContent());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JPanel commentsPanel;
    private javax.swing.JScrollPane commentsScroll;
    private javax.swing.JTextArea contentArea;
    private javax.swing.JButton deletePostButton;
    private javax.swing.JButton dislikeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton likeButton;
    private javax.swing.JLabel likesLabel;
    private javax.swing.JButton makeCommentButton;
    // End of variables declaration//GEN-END:variables

    

}
