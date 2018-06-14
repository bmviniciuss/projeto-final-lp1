package social;

import java.util.ArrayList;

public class Comment extends Uid {

    private final User owner;
    private String content;
    private ArrayList<Comment> reponses;

    public Comment(User owner, String content) {
        super();
        this.owner = owner;
        this.content = content;
        this.reponses = new ArrayList<Comment>();
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
     * @return the reponses
     */
    public ArrayList<Comment> getReponses() {
        return reponses;
    }

    public boolean hasResponseId(String key) {
        for (Comment c : this.reponses) {
            if (c.getUuid().equals(key)) {
                return true;
            }
        }

        return false;
    }

    public Comment getCommentById(String id) {
        if (hasResponseId(id)) {
            for (Comment c : this.reponses) {
                if (c.getUuid().equals(id)) {
                    return c;
                }
            }
        }

        return null;

    }

    public void addResponse(Comment comment) {
        this.reponses.add(comment);
    }

    @Override
    public String toString() {
        return this.owner.getName() + " - " + this.content;
    }

}
