package social;

import java.io.Serializable;
import java.util.HashMap;
import utils.DataSerializer;
import utils.Validators;

/**
 * Datbase Class.
 *
 * @author bmviniciuss
 */
public class Database implements Serializable {

    /**
     * database's filename.
     */
    public static final String APPLICATION_DATA = "application_data.ser";

    private HashMap<String, User> users;
    private HashMap<String, String> authentication;
    private HashMap<String, Group> groups;

    /**
     * Create a database instance.
     */
    public Database() {
        this.users = new HashMap<String, User>();
        this.authentication = new HashMap<String, String>();
        this.groups = new HashMap<String, Group>();
    }

    /**
     * Serialize the database.
     */
    public void serializeData() {
        DataSerializer.serializeDatabase(Database.APPLICATION_DATA, this);
    }

    /**
     * @return the users
     */
    public HashMap<String, User> getUsers() {
        return users;
    }

    /**
     * Check if there is a user with given id
     * @param key
     * @return true is key is in users.
     */
    public User getUserById(String key) {
        if (this.users.containsKey(key)) {
            return this.users.get(key);
        }
        return null;
    }

    /**
     * @return the authentication
     */
    private HashMap<String, String> getAuthentication() {
        return authentication;
    }

    /**
     * Check if there is a user with given email.
     * @param email
     * @return true if has a user with email.
     */
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

    /**
     * Get a userId, if exists, with given email.
     * @param email
     * @return userId with given email.
     */
    public String getUserIdByEmail(String email) {
        for (String key : this.users.keySet()) {
            User u = this.users.get(key);
            if (u.getEmail().trim().equals(email.trim())) {
                return key;
            }
        }
        return null;
    }

    /**
     * Validate a login.
     *
     * @param email
     * @param password
     * @return a user if login is valid.
     */
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

    /**
     * Search users with given name.
     * @param queryName
     * @return Users with given name.
     */
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

    /**
     * @return the groups
     */
    public HashMap<String, Group> getGroups() {
        return groups;
    }

    /**
     * Add a Group to groups' HashMap
     * @param group
     */
    public void addGroup(Group group) {
        if (!this.groups.containsKey(group.getUuid())) {
            this.groups.put(group.getUuid(), group);
        }
    }

    /**
     * Check if there is a group with given id.
     * @param id
     * @return Group with given id, if exists.
     */
    public Group getGroupById(String id) {
        if (this.groups.containsKey(id)) {
            return this.groups.get(id);
        }

        return null;
    }

    /**
     * Search groups with given name.
     * @param name
     * @return
     */
    public HashMap<String, Group> searchGroupByName(String name) {
        HashMap<String, Group> searchResults = new HashMap<String, Group>();

        for (String key : this.groups.keySet()) {
            Group gp = getGroupById(key);
            if (gp.getGroupName().toLowerCase().trim().startsWith(name.trim().toLowerCase())) {
                searchResults.put(gp.getUuid(), gp);
            }
        }

        if (!searchResults.isEmpty()) {
            return searchResults;
        } else {
            return null;
        }
    }
}
