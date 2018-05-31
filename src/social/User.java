package social;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bmviniciuss
 */
public class User extends Unique implements Serializable {

    private String name;
    private String email;
    private ImageIcon profilePicture;
    private HashSet<String> friends;
    private HashSet<String> requests;
    private HashSet<String> blockedUsers;
    private boolean publicProfile;

    public User(String name, String email) {
        super();
        this.name = name;
        this.email = email;
        this.profilePicture = null;
        this.publicProfile = true;
        this.friends = new HashSet<String>();
        this.requests = new HashSet<String>();
        this.blockedUsers = new HashSet<String>();
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.email;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the profilePicture
     */
    public ImageIcon getProfilePicture() {
        return new ImageIcon(getClass().getResource("vinicius_profile.jpg"));
    }

    /**
     * @param profilePicture the profilePicture to set
     */
    public void setProfilePicture(ImageIcon profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * @return the friends
     */
    public HashSet<String> getFriends() {
        return friends;
    }
    
    public HashSet<String> getRequests() {
        return this.requests;
    }

    public boolean userIsBlocked(String key) {
        return this.blockedUsers.contains(key);
    }

    public void blockUser(String key) {
        if (!this.blockedUsers.contains(key)) {
            this.blockedUsers.add(key);
        }
    }
    
    public void unblockUser(String key) {
        if(this.blockedUsers.contains(key)) {
            this.blockedUsers.remove(key);
        }
    }

    public void sendRequest(String originUser) {
        if (!this.friends.contains(originUser) && !this.blockedUsers.contains(originUser) && !this.requests.contains(originUser)) {
            this.requests.add(originUser);
        }
    }

    private void addFriend(String key) {
        if (this.requests.contains(key) && !this.friends.contains(key)) {
            this.friends.add(key);
            this.requests.remove(key);
        }
    }

}
