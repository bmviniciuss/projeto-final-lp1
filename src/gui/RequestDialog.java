package gui;

import java.io.File;
import social.User;
import utils.Messages;
import social.UserInteraction;
import utils.Images;
import utils.WindowTitles;
import utils.Wrapers;

/**
 * Friends request Dialog.
 *
 * @author bmvin
 */
public class RequestDialog extends javax.swing.JDialog {

    private final User sender; // sender
    private final User receiver; // receiver

    /**
     * Creates new form RequestDialog
     *
     * @param parent
     * @param modal
     * @param origin
     * @param target
     */
    public RequestDialog(java.awt.Frame parent, boolean modal, User origin, User target) {
        super(parent, modal);
        initComponents();
        this.sender = origin;
        this.receiver = target;

        setTitle(WindowTitles.requestTitle(origin.getName()));
        nameLabel.setText(this.sender.getName());
        messageLabel.setText(Messages.SENT_FRIEND_REQUEST);

        showProfilePicture();

        setLocationRelativeTo(parent);
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
        messageLabel = new javax.swing.JLabel();
        ignoreButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        profilePic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nameLabel.setText("NAME");

        messageLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        ignoreButton.setText("Delete");
        ignoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignoreButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("Accept");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        profilePic.setMaximumSize(new java.awt.Dimension(150, 200));
        profilePic.setMinimumSize(new java.awt.Dimension(150, 200));
        profilePic.setPreferredSize(new java.awt.Dimension(150, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addGap(434, 434, 434))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(acceptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ignoreButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(acceptButton)
                            .addComponent(ignoreButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
        UserInteraction.acceptRequest(this.sender, this.receiver);
        this.dispose();
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void ignoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ignoreButtonActionPerformed

        sender.removeFromPending(receiver.getUuid());
        receiver.removeFromRequests(sender.getUuid());

        this.dispose();
    }//GEN-LAST:event_ignoreButtonActionPerformed

    /**
     * Show originUser's profile picture
     */
    private void showProfilePicture() {
        File pic = sender.getProfilePic();
        if (pic == null || !pic.exists()) {
            profilePic.setText(Wrapers.htmlWraper("No Profile Picture Found."));
        } else {
            profilePic.setIcon(Images.profilePic(pic));
            profilePic.setText(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton ignoreButton;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel profilePic;
    // End of variables declaration//GEN-END:variables

}
