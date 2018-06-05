package social;

import java.io.Serializable;
import java.util.HashMap;
import utils.DataSerializer;
import utils.Validators;


/**
 *
 * @author bmviniciuss
 */
public class Database implements Serializable {
    
    public static final String APPLICATION_DATA = "application_data.ser";

    private HashMap<String, User> users;
    private HashMap<String, String> authentication;

    public Database() {
        this.users = new HashMap<String, User>();
        this.authentication = new HashMap<String, String>();
    }
    
    public void serializeData() {
        DataSerializer.serializeDatabase(Database.APPLICATION_DATA, this);
    }
    
    /**
     * @return the users
     */
    public HashMap<String, User> getUsers() {
        return users;
    }

    public User getUserById(String key) {
        if (this.users.containsKey(key)) {
            return this.users.get(key);
        }
        return null;
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
        for (String key : this.users.keySet()) {
            User user = this.users.get(key);
            if (user.getEmail().trim().equals(email.trim())) {
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

    /*
     * FOR DEBUG ONLYYYYYYYYYYYYY
    */
    public void listAllUsers() {
        int i = 1;
        System.out.println("USERS");
        for (String key : this.users.keySet()) {
            User user = this.users.get(key);
            System.out.println(i + " - " + key + " " + user);
            i++;
        }
        i = 0;
        System.out.println("PASS");
        for (String key : this.authentication.keySet()) {
            String pass = this.authentication.get(key);
            System.out.println(i + " - " + key + " " + pass);
            i++;
        }

    }

    public String getUserIdByEmail(String email) {
        for (String key : this.users.keySet()) {
            User u = this.users.get(key);
            if (u.getEmail().trim().equals(email.trim())) {
                return key;
            }
        }
        return null;
    }

    public User validateLogin(String email, String password) {
        String key = getUserIdByEmail(email);
        if (key != null) {
            String pass = this.authentication.get(key);
            if (Validators.passwordsMatches(pass, password)) {
                User user = this.users.get(key);
                return user;
            }
        }

        return null;
    }

    public HashMap<String, User> searchUsersByName(String queryName) {
        HashMap<String, User> result = new HashMap<String, User>();

        for (String key : this.users.keySet()) {
            User u = this.users.get(key);

            if (u.getName().toLowerCase().trim().startsWith(queryName.toLowerCase().trim())) {
                result.put(u.getUuid(), u);
            }

        }

        if (!result.isEmpty()) {
            return result;

        } else {
            return null;
        }

    }
}
