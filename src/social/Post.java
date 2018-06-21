package social;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author bmvin
 */
public abstract class Post extends Uid {

    private User owner;
    private Group inGroup;
    private boolean isPublic;
    private ArrayList<Comment> comments;
    private HashSet<String> likes;

    /**
     *
     * @param owner
     * @param inGroup
     * @param isPublic
     */
    public Post(User owner, Group inGroup, boolean isPublic) {
        this.owner = owner;
        this.isPublic = isPublic;
        this.inGroup = inGroup;
        this.likes = new HashSet<String>();
        this.comments = new ArrayList<Comment>();

    }

    /**
     *
     * @return
     */
    public Group getGroup() {
        return this.inGroup;
    }

    /**
     *
     * @return
     */
    public int numLikes() {
        return this.likes.size();
    }

    /**
     *
     * @return
     */
    public int numComments() {
        return this.comments.size();
    }

    /**
     *
     * @param userKey
     */
    public void likePost(String userKey) {
        if (!this.likes.contains(userKey)) {
            this.likes.add(userKey);
        }
    }

    /**
     *
     * @param userKey
     */
    public void removeLike(String userKey) {
        if (this.likes.contains(userKey)) {
            this.likes.remove(userKey);
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public boolean hasLiked(String key) {
        return this.likes.contains(key);
    }

    /**
     *
     * @return
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     *
     * @return
     */
    public boolean isPublic() {
        return this.isPublic;
    }

    /**
     *
     * @return
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    /**
     *
     * @param query
     * @return
     */
    public boolean isInComments(Comment query) {
        for (Comment comment : this.comments) {
            if (comment.getUuid().equals(query.getUuid())) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param comment
     */
    public void addComment(Comment comment) {
        if (!isInComments(comment)) {
            this.comments.add(0, comment);
        }
    }

    /**
     *
     */
    public void debugComments() {
        int i = 0;
        for (Comment c : this.comments) {
            System.out.println(i + " - " + c);
            i++;
        }
    }

    /**
     *
     * @param comment
     */
    public void removeComment(Comment comment) {
        if (isInComments(comment)) {
            this.comments.remove(comment);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Comment getCommentById(String id) {
        for (Comment c : this.comments) {
            if (c.getUuid().equals(id)) {
                return c;
            }
        }

        return null;
    }

    /**
     *
     * @param comment
     * @return
     */
    public int getCommentIndex(Comment comment) {
        if (isInComments(comment)) {
            return this.comments.indexOf(comment);
        }

        return -1;
    }

}
