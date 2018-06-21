package social;

/**
 * Text Based Post
 * @author bmvin
 */
public class TextPost extends Post {

    private String content;

    /**
     * Create a Text Based comment.
     * @param owner
     * @param inGroup
     * @param isPublic
     * @param content
     */
    public TextPost(User owner, Group inGroup, boolean isPublic, String content) {
        super(owner, inGroup, isPublic);
        this.content = content;
    }

    /**
     * Get Text representation
     * @return String representation
     */
    @Override
    public String toString() {
        return super.getOwner().getName() + " - " + this.content + " - Likes: " + super.numLikes() + " - Comments: " + super.numComments();
    }

    /**
     * Get Post's Content
     * @return post's content
     */
    public String getContent() {
        return this.content;
    }
}
