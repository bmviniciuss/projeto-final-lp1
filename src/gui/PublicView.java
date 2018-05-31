/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Listeners.CreateAccountListener;
import Listeners.LoginListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import social.Database;
import social.User;

/*
 *
 * @author bmvin
 */
public class PublicView extends javax.swing.JFrame {

    private Database db;

    /**
     * Creates new form PublicVIew
     */
    public PublicView(Database db) {
        initComponents();
        this.db = db;
        this.db.listAllUsers();
        LoginPanel loginPanel = new LoginPanel();
        contentPanel.add(Constans.LOGIN, loginPanel);

        loginPanel.setListener(new LoginListener() {
            @Override
            public void sendLoginCredentials(String email, String password) {
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }
        });

        CreateAccountPanel createAccountPanel = new CreateAccountPanel();
        contentPanel.add(Constans.CREATE_ACCOUNT, createAccountPanel);

        createAccountPanel.setListener(new CreateAccountListener() {
            @Override
            public void sendUser(User user, String password) {
                // CHECK IF EMAIL IS FREE
                if (!db.hasUserWithEmail(user.getEmail())) {
                    db.addUserToDatabase(user, password);
                    db.serializeAllData();
                    AuthView auth = new AuthView(user, db);
                    auth.setVisible(true);
                    dispose();
                    db.listAllUsers();
                } else {
                    JOptionPane.showMessageDialog(createAccountPanel, "Already exists a user with that email. try another one", "Email", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // LOGIN BUTTON LISTENER
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout layout = (CardLayout) contentPanel.getLayout();
                layout.show(contentPanel, Constans.LOGIN);
            }
        });

        // CREATE ACCOUNT BUTTON LISTENER
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout layout = (CardLayout) contentPanel.getLayout();
                layout.show(contentPanel, Constans.CREATE_ACCOUNT);
            }

        });

        // EXIT LISTENER
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                db.serializeAllData();
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

        jSplitPane1 = new javax.swing.JSplitPane();
        menuPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        createAccountButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginButton.setText("Login");

        createAccountButton.setText("New Account");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(loginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createAccountButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(menuPanel);

        contentPanel.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(contentPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.db.serializeAllData();
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}
