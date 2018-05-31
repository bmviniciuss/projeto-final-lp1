package social;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    }

    // USERS DATA
    public void serializeUsersData() {
        DataSerializer.serializeData(Database.USERS_DATA, this.users);
    }

    public void deserializeUsersData() {
        HashMap<String, User> data = null;
        data = DataSerializer.desirializeUsersData(Database.USERS_DATA);
        if (data != null) {
            setUsers(data);
        }
    }

    // AUTHENTICATION DATA
    public void serializeAuthentication() {
        DataSerializer.serializeData(Database.AUTHENTICATION_DATA, this.authentication);
    }
    
    public void desirializeAuthentication() {
        HashMap<String, String> data = null;
        data = DataSerializer.desirializeAuthenticationData(Database.AUTHENTICATION_DATA);
        if(data != null) {
            setAuthentication(data);
        }
    }
    
    public void serializeAllData() {
        serializeUsersData();
        serializeAuthentication();
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
    
    public void addUserToDatabase(User user, String password) {
        String key = user.getUuid();
        if(!this.users.containsKey(key) && !this.authentication.containsKey(key)) {
            this.users.put(key, user);
            this.authentication.put(key, password);
        }
    }

    

}
