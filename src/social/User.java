package social;


import java.io.Serializable;
import java.util.HashMap;

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
    private boolean publicProfile;
    private HashMap<String, User> friends;

    public User(String name, String email) {
        super();
        this.name = name;
        this.email = email;
        this.publicProfile = true;
        this.friends = new HashMap<String, User>();
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
        return this.name;
    }

    /**
     * @return User's name
     */
    public String getName() {
        return toString();
    }


    /**
     * @return User's friends
     */
    public HashMap<String, User> getFriends() {
        return this.friends;
    }

    /**
     * Get a user's friends if exists.
     * @param key
     * @return A friend from user if exists.
     */
    public User getFriend(String key) {
        if (this.friends.containsKey(key)) {
            return this.friends.get(key);
        } else {
            return null;
        }
    }
    
    /**
     * Add a friend
     * @param friend
     */
    public void addFriend(User friend) {
        this.friends.put(friend.getUuid(), friend);
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}