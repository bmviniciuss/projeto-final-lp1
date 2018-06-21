package social;

/**
 *
 * @author bmvin
 */
public class TextPost extends Post {

    private String content;

    /**
     *
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
     *
     * @return
     */
    @Override
    public String toString() {
        return super.getOwner().getName() + " - " + this.content + " - Likes: " + super.numLikes() + " - Comments: " + super.numComments();
    }

    /**
     *
     * @return
     */
    public String getContent() {
        return this.content;
    }
}
