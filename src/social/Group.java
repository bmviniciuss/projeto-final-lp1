package social;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Group extends Uid {

    private String groupName;
    private String groupDescription;
    private HashMap<String, User> groupMembers;
    private HashMap<String, User> groupAdmins;
    private ArrayList<Post> groupPosts;
    private HashSet<User> groupRequests;

    public Group(String name, String desc, User firstAdmin) {
        super();
        this.groupMembers = new HashMap<String, User>();
        this.groupAdmins = new HashMap<String, User>();
        this.groupPosts = new ArrayList<Post>();
        this.groupRequests = new HashSet<User>();

        this.groupAdmins.put(firstAdmin.getUuid(), firstAdmin);
        this.groupMembers.put(firstAdmin.getUuid(), firstAdmin);
        this.groupName = name;
        this.groupDescription = desc;
    }

    public boolean isMember(String id) {
        return this.groupMembers.containsKey(id);
    }

    public boolean isAdmin(String id) {
        return this.groupAdmins.containsKey(id);
    }

    public boolean isInRequests(User user) {
        return this.groupRequests.contains(user);
    }

    private void addUserAsMember(User user) {
        if (!isMember(user.getUuid())) {
            this.groupMembers.put(user.getUuid(), user);
        }
    }

    private void removeFromRequests(User user) {
        if (isInRequests(user)) {
            this.groupRequests.remove(user);
        }
    }

    public boolean isInPost(Post p) {
        for (Post post : this.groupPosts) {
            if (post.getUuid().equals(p.getUuid())) {
                return true;
            }
        }

        return false;
    }

    public void removePost(Post p, User doingAction) {
        if (isInPost(p)) {
            User postOwner = p.getOwner();
            if (postOwner.getUuid().equals(doingAction.getUuid()) || isAdmin(doingAction.getUuid())) {
                this.groupPosts.remove(p);
            }

        }
    }

    public void addPost(Post post) {
        if (isMember(post.getOwner().getUuid())) {
            this.groupPosts.add(0, post);
        }
    }

    public void acceptRequest(User admin, User user) {
        if (isAdmin(admin.getUuid()) && isInRequests(user)) {
            addUserAsMember(user);
            removeFromRequests(user);
        }
    }

    private void deleteUser(String id) {
        if (isMember(id)) {
            this.groupMembers.remove(id);
        }
    }

    public void removeUser(User admin, User user) {
        if (isAdmin(admin.getUuid()) && isMember(user.getUuid())) {
            deleteUser(user.getUuid());
        }
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @return the groupMembers
     */
    public HashMap<String, User> getGroupMembers() {
        return groupMembers;
    }

    /**
     * @return the groupAdmins
     */
    public HashMap<String, User> getGroupAdmins() {
        return groupAdmins;
    }

    /**
     * @return the groupPosts
     */
    public ArrayList<Post> getGroupPosts() {
        return groupPosts;
    }

    @Override
    public String toString() {
        return this.groupName + " - " + this.groupDescription;
    }

    /**
     * @return the groupDescription
     */
    public String getGroupDescription() {
        return groupDescription;
    }

    public User getMemberById(String id) {
        if (this.groupMembers.containsKey(id)) {
            return this.groupMembers.get(id);
        }

        return null;
    }
}