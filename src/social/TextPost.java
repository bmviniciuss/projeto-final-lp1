package social;

public class TextPost extends Post {

    private String content;

    public TextPost(User owner, Group inGroup, boolean isPublic, String content) {
        super(owner, inGroup, isPublic);
        this.content = content;
    }

    @Override
    public String toString() {
        return super.getOwner().getName() + " - " + this.content + " - Likes: " + super.numLikes() + " - Comments: " + super.numComments();
    }

    public String getContent() {
        return this.content;
    }
}
