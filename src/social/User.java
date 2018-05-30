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

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean publicProfile;
    private HashMap<String, User> friends;

    public User(String firstName, String lastName, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.publicProfile = true;
        this.friends = new HashMap<String, User>();
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
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

}