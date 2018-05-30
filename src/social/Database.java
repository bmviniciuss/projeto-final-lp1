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

    private static final String DBNAME = "database.ser";

    private HashMap<String, User> users;

    public Database() {
        this.users = new HashMap<String, User>();
        this.retriveData();
    }

    
    /**
     * Serialize the database info
     */
    public void serializeData() {
        try {
            FileOutputStream fos = new FileOutputStream(DBNAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.users);
            oos.close();
            fos.close();

//            System.out.println("Database was serialize");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Read Database File and set to Users field
     */
    private void retriveData() {
        HashMap<String, User> map = null;
        File f = new File(DBNAME);
        if (f.exists() && !f.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(DBNAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                map = (HashMap) ois.readObject();
                ois.close();
                fis.close();

                setUsers(map);
            } catch (IOException e) {
                e.printStackTrace();

            } catch (ClassNotFoundException c) {
//                System.out.println("Class not found");
                c.printStackTrace();

            }
        } else {
            setUsers(new HashMap<String, User>());
        }
    }

    /**
     *  Add user to the collection
     * @param User to add to the collection
     */
    public void addUser(User user) {
        this.users.put(user.getUuid(), user);
    }

    /**
     * @return the users
     */
    public HashMap<String, User> getUsers() {
        return users;
    }

    /*
     * Iterate over all users and print then to the screen
     */
    public void listAllUsers() {
        this.users.keySet().forEach((key) -> {
        	User u = getUserByKey(key);
        	System.out.println(u);
        });
    }

    /*
     * @return number of users
     */
    public int numberOfUsers() {
        return users.size();
    }

    /**
     * Searches for a specific user's by a given email.
     * @param email
     * @return user's email key if exists. or null
     */
    public String getUserKeyByEmail(String email) {
        for (String key : this.users.keySet()) {
            User user = this.users.get(key);
            if (user.getEmail().equalsIgnoreCase(email.trim())) {
                return key;
            }
        }

        return null;
    }


    /**
     * Validate login with given email and password.
     * @param email
     * @param password
     * @return User if sign in is valid. or null
     */
    public User validateSignIn(String email, String password) {
        String key = getUserKeyByEmail(email);
        if ((key != null)) {
        	User user = getUserByKey(key);
            if (passwordMatch(key, password.trim())) {
                return user;
            }
        }

        return null;
    }

    
    /**
     * Set users.
     * @param users
     */
    private void setUsers(HashMap<String, User> users) {
        if (users != null) {
            this.users = users;
        }
    }

    /**
     * Get user with specific key
     * @param key
     * @return User with given key
     */
    public User getUserByKey(String key) {
        if (this.users.containsKey(key)) {
            return this.users.get(key);
        }
        return null;
    }

    /**
     * Check if given password match user's password
     * @param basePassword
     * @param toCheckPassword
     * @return True if passwords match.
     */
    private boolean passwordMatch(String basePassword, String toCheckPassword) {
        return basePassword.equals(toCheckPassword.trim());
    }

    /**
     * Search in the database for users with given name.
     * @param firstName
     * @return A list of Users with given name
     */
    public ArrayList<User> getUsersByName(String firstName) {
    	ArrayList<User> users = new ArrayList<User>();
        for (String key : this.users.keySet()) {
            User user = this.users.get(key);
            if (user.getFirstName().toLowerCase().startsWith(firstName.toLowerCase().trim())) {
                users.add(user);
            }
        }
        
        if(users.size() > 0) {
        	return users;
        } else {
        	return null;
        }
    }
}