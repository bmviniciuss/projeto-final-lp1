package social;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;


public class User extends Uid implements Serializable {

    private String name;
    private String email;
    private String bio;
    private File profilePicture;
    private HashSet<String> friends;
    private HashSet<String> requests;
    private HashSet<String> blockedUsers;
    private HashSet<String> pendingRequests;
    private HashMap<String, Post> posts;
    private boolean publicProfile;

    public User(String name, String email) {
        super();
        this.name = name;
        this.email = email;
        this.bio = null;
        this.profilePicture = null;
        this.publicProfile = true;
        this.friends = new HashSet<String>();
        this.requests = new HashSet<String>();
        this.blockedUsers = new HashSet<String>();
        this.pendingRequests = new HashSet<String>();
        this.posts = new HashMap<String, Post>();
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        if (bio != null && !bio.equals("")) {
            this.bio = bio;
        }
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
     * @param profilePicture the profilePicture to set
     */
    public void setProfilePicture(File profilePicture) {
        this.profilePicture = profilePicture;
    }

    public File getProfilePic() {
        return this.profilePicture;
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
        if (this.blockedUsers.contains(key)) {
            this.blockedUsers.remove(key);
        }
    }

    public void sendRequest(String originUser) {
        if (!this.friends.contains(originUser) && !this.blockedUsers.contains(originUser) && !this.requests.contains(originUser)) {
            this.requests.add(originUser);
        }
    }

    public void acceptRequest(String originKey) {
        if (this.requests.contains(originKey) && !this.friends.contains(originKey)) {
            this.friends.add(originKey);
            this.requests.remove(originKey);
        }
    }

    public void addFriend(String targetKey) {
        if (!this.friends.contains(targetKey)) {
            this.friends.add(targetKey);
        }
    }

    public HashSet<String> getPendingRequests() {
        return this.pendingRequests;
    }

    public boolean isPending(String key) {
        return this.pendingRequests.contains(key);
    }

    public void addRequestToPending(String targetKey) {
        if (!this.pendingRequests.contains(targetKey)) {
            this.pendingRequests.add(targetKey);
        }
    }

    public void removeFromPending(String targetKey) {
        if (isPending(targetKey)) {
            this.pendingRequests.remove(targetKey);
        }
    }

    public HashMap<String, Post> getPosts() {
        return this.posts;
    }

    public void addPost(Post post) {
        if (!this.posts.containsKey(post.getUuid())) {
            this.posts.put(post.getUuid(), post);
        }
    }

    public void removePost(Post post) {
        if (this.posts.containsKey(post.getUuid())) {
            this.posts.remove(post.getUuid());
        }
    }

    public Post getPostById(String key) {
        if (this.posts.containsKey(key)) {
            return this.posts.get(key);
        }
        return null;
    }

    public boolean isFriendWith(String id) {
        return this.friends.contains(id);
    }
}
