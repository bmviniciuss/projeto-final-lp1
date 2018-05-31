package social;

import java.io.Serializable;
import java.util.HashMap;
import utils.DataSerializer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bmviniciuss
 */
public class Database implements Serializable {

    private static final String USERS_DATA = "users_data.ser";
    private static final String AUTHENTICATION_DATA = "authentication_data.ser";

    private HashMap<String, User> users;
    private HashMap<String, String> authentication;

    public Database() {
        this.users = new HashMap<String, User>();
        this.authentication = new HashMap<String, String>();
        this.deserializeAllData();
    }

    // USERS DATA
    /**
     * Serialize User's data
     */
    public void serializeUsersData() {
        DataSerializer.serializeData(Database.USERS_DATA, this.users);
    }

    /**
     * Deserialize User's data
     */
    public void deserializeUsersData() {
        HashMap<String, User> data = null;
        data = DataSerializer.desirializeUsersData(Database.USERS_DATA);
        if (data != null) {
            setUsers(data);
        }
    }

    // AUTHENTICATION DATA
    /**
     * Serialize Authentication data
     */
    public void serializeAuthentication() {
        DataSerializer.serializeData(Database.AUTHENTICATION_DATA, this.authentication);
    }

    /**
     * Desirialize Authentication Data
     */
    public void deserializeAuthentication() {
        HashMap<String, String> data = null;
        data = DataSerializer.deserializeAuthenticationData(Database.AUTHENTICATION_DATA);
        if (data != null) {
            setAuthentication(data);
        }
    }

    /**
     * Helper method to serialize both HashMaps at once
     */
    public void serializeAllData() {
        serializeUsersData();
        serializeAuthentication();
    }

    public void deserializeAllData() {
        this.deserializeUsersData();
        this.deserializeUsersData();
    }

    /**
     * @return the users
     */
    public HashMap<String, User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    private void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    /**
     * @return the authentication
     */
    private HashMap<String, String> getAuthentication() {
        return authentication;
    }

    /**
     * @param authentication the authentication to set
     */
    private void setAuthentication(HashMap<String, String> authentication) {
        this.authentication = authentication;
    }

    public boolean hasUserWithEmail(String email) {
        for(String key: this.users.keySet()) {
            User user = this.users.get(key);
            if(user.getEmail().trim().equals(email.trim())) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Add a User to database. Add to User's Hash and Authentication Hash
     *
     * @param user
     * @param password
     */
    public void addUserToDatabase(User user, String password) {
        String key = user.getUuid();
        if (!this.users.containsKey(key) && !this.authentication.containsKey(key) && !hasUserWithEmail(user.getEmail())) {
            this.users.put(key, user);
            this.authentication.put(key, password);
        }
    }

    // DEBUG
    public void listAllUsers() {
        int i = 1;
        for (String key : this.users.keySet()) {
            User user = this.users.get(key);
            System.out.println(i + " - " + key + " " + user);
            i++;
        }
    }

}
