/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author bmvin
 */
public class Post extends Uid {

    private User owner;
    private boolean isPublic;
    private String content;
    private HashMap<String, Comment> comments;
    private ArrayList<String> sortedComments;
    private HashSet<String> likes;

    public Post(User owner, String content, boolean isPublic) {
        this.owner = owner;
        this.content = content;
        this.isPublic = isPublic;
        this.likes = new HashSet<String>();
        this.comments = new HashMap<String, Comment>();
        this.sortedComments = new ArrayList<String>();
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

    public void addComment(Comment comment) {
        if (!this.comments.containsKey(comment.getUuid()) && !isInSortedComments(comment.getUuid())) {
            this.comments.put(comment.getUuid(), comment);
            this.sortedComments.add(comment.getUuid());
        }
    }

    public boolean isInSortedComments(String key) {
        for (String id : this.sortedComments) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return the sortedComments
     */
    public ArrayList<String> getSortedComments() {
        return sortedComments;
    }

    public Comment getCommentById(String id) {
        if (this.comments.containsKey(id)) {
            return this.comments.get(id);
        }
        
        return null;
    }
}
