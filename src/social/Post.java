package social;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Post Abstract class
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
     * Super class constructor
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
     * Get, if exists, post's group.
     *
     * @return post's group or null
     */
    public Group getGroup() {
        return this.inGroup;
    }

    /**
     * Get number os likes.
     *
     * @return number of likes
     */
    public int numLikes() {
        return this.likes.size();
    }

    /**
     * Get the number of comments
     *
     * @return number of comments
     */
    public int numComments() {
        return this.comments.size();
    }

    /**
     * User liked a Post
     *
     * @param userKey
     */
    public void likePost(String userKey) {
        if (!this.likes.contains(userKey)) {
            this.likes.add(userKey);
        }
    }

    /**
     * User disliked a Post.
     *
     * @param userKey
     */
    public void removeLike(String userKey) {
        if (this.likes.contains(userKey)) {
            this.likes.remove(userKey);
        }
    }

    /**
     * Check if User has liked a Post.
     *
     * @param key
     * @return true if has Liked.
     */
    public boolean hasLiked(String key) {
        return this.likes.contains(key);
    }

    /**
     * Get Post's owner
     *
     * @return post's owner
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     * Get Post visibility.
     *
     * @return True if is public.
     */
    public boolean isPublic() {
        return this.isPublic;
    }

    /**
     * Get Post's Comments
     *
     * @return post's comments
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    /**
     * Check if given comment is in Comments
     *
     * @param query
     * @return true if given input is in comments.
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
     * Add a comment to post.
     *
     * @param comment
     */
    public void addComment(Comment comment) {
        if (!isInComments(comment)) {
            this.comments.add(0, comment);
        }
    }

    /**
     * Remove a particular comment from post.
     *
     * @param comment
     */
    public void removeComment(Comment comment) {
        if (isInComments(comment)) {
            this.comments.remove(comment);
        }
    }

    /**
     * Get Comment by given commentId
     *
     * @param id
     * @return comment by id
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
     * Get comment index;
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
