
package social;

import java.util.ArrayList;
import java.util.HashSet;

public class Post extends Uid {

    private User owner;
    private boolean isPublic;
    private String content;
    private ArrayList<Comment> comments;
    private HashSet<String> likes;

    public Post(User owner, String content, boolean isPublic) {
        this.owner = owner;
        this.content = content;
        this.isPublic = isPublic;
        this.likes = new HashSet<String>();
        this.comments = new ArrayList<Comment>();

    }

    public int numLikes() {
        return this.likes.size();
    }

    public int numComments() {
        return this.comments.size();
    }

    public void likePost(String userKey) {
        if (!this.likes.contains(userKey)) {
            this.likes.add(userKey);
        }
    }

    public void removeLike(String userKey) {
        if (this.likes.contains(userKey)) {
            this.likes.remove(userKey);
        }
    }

    @Override
    public String toString() {
        return this.owner.getName() + " - " + this.content + " - Likes: " + numLikes() + " - Comments: " + numComments();
    }

    public String getContent() {
        return this.content;
    }

    public boolean hasLiked(String key) {
        return this.likes.contains(key);
    }

    public User getOwner() {
        return this.owner;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    public boolean isInComments(Comment query) {
        for (Comment comment : this.comments) {
            if (comment.getUuid().equals(query.getUuid())) {
                return true;
            }
        }

        return false;
    }

    public void addComment(Comment comment) {
        if (!isInComments(comment)) {
            this.comments.add(0, comment);
        }
    }

    public void debugComments() {
        int i = 0;
        for (Comment c : this.comments) {
            System.out.println(i + " - " + c);
            i++;
        }
    }

    public void removeComment(Comment comment) {
        if (isInComments(comment)) {
            this.comments.remove(comment);
        }
    }

    public Comment getCommentById(String id) {
        for (Comment c : this.comments) {
            if (c.getUuid().equals(id)) {
                return c;
            }
        }

        return null;
    }

    public int getCommentIndex(Comment comment) {
        if (isInComments(comment)) {
            return this.comments.indexOf(comment);
        }

        return -1;
    }

}
