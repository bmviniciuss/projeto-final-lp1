package social;

import java.util.ArrayList;

/**
 * Comment Class.
 *
 * @author bmvin
 */
public class Comment extends Uid {

    private final User owner;
    private final String content;
    private ArrayList<Comment> replies;

    /**
     * Create a comment.
     *
     * @param owner
     * @param content
     */
    public Comment(User owner, String content) {
        super();
        this.owner = owner;
        this.content = content;
        this.replies = new ArrayList<Comment>();
    }

    /**
     * @return the owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Comment String representation.
     *
     * @return String representation for the object
     */
    @Override
    public String toString() {
        return this.owner.getName() + " - " + this.content;
    }

    public boolean inReplies(String id) {
        for (Comment c : this.replies) {
            if (c.getUuid().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public void removeReplie(Comment com) {
        if(inReplies(com.getUuid())) {
            this.replies.remove(com);
        }
    }

    public void addReplie(Comment com) {
        if (!inReplies(com.getUuid())) {
            this.replies.add(com);
        }
    }

    public ArrayList<Comment> getReplies() {
        return this.replies;
    }

}
