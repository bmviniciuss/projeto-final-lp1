package social;

/**
 * Comment Class.
 *
 * @author bmvin
 */
public class Comment extends Uid {

    private final User owner;
    private final String content;

    /**
     *
     * @param owner
     * @param content
     */
    public Comment(User owner, String content) {
        super();
        this.owner = owner;
        this.content = content;
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
     *
     * @return String representation for the object
     */
    @Override
    public String toString() {
        return this.owner.getName() + " - " + this.content;
    }

}
