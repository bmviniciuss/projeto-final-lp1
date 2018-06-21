package social;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
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
    private ArrayList<Post> posts;
    private HashSet<String> groups;
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
        this.posts = new ArrayList<Post>();
        this.groups = new HashSet<String>();
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

    public boolean isFriendWith(String id) {
        return this.friends.contains(id);
    }

    /**
     * @return the groups
     */
    public HashSet<String> getGroups() {
        return groups;
    }

    public void removeGroup(String id) {
        if (this.groups.contains(id)) {
            this.groups.remove(id);
        }
    }

    public void addGroup(String id) {
        if (!this.groups.contains(id)) {
            this.groups.add(id);
        }
    }

    public ArrayList<Post> getPosts() {
        return this.posts;
    }

    public ArrayList<PhotoPost> getPhotos() {
        ArrayList<PhotoPost> photos = new ArrayList<PhotoPost>();

        for (Post p : this.posts) {
            if (p instanceof PhotoPost) {
                photos.add((PhotoPost) p);
            }
        }

        return photos;
    }

    public boolean isInPost(String id) {
        for (Post p : this.posts) {
            if (p.getUuid().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Post getPostById(String key) {
        for (Post p : this.posts) {
            if (p.getUuid().equals(key)) {
                return p;
            }
        }
        return null;
    }

    public void addPost(Post post) {
        if (!isInPost(post.getUuid())) {
            this.posts.add(post);

        }
    }

    public void removePost(Post post) {
        if (isInPost(post.getUuid())) {
            this.posts.remove(post);

        }
    }

}
