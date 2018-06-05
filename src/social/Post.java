/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import java.util.HashMap;
import java.util.HashSet;
import social.Comment;

/**
 *
 * @author bmvin
 */
public class Post extends Uid {

    private User owner;
    private boolean isPublic;
    private String content;
    private HashMap<String, Comment> comments;
    private HashSet<String> likes;

    public Post(User owner, String content, boolean isPublic) {
        this.owner = owner;
        this.content = content;
        this.isPublic = isPublic;
        this.likes = new HashSet<String>();
        this.comments = new HashMap<String, Comment>();
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
}
