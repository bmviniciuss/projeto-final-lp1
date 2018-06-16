package social;

import java.util.HashSet;

public class Comment extends Uid {
    
    private final User owner;
    private final String parentId;
    private final String content;
    private HashSet<String> reponses;
    
    public Comment(User owner, String content, String parentId) {
        super();
        this.parentId = parentId;
        this.owner = owner;
        this.content = content;
        this.reponses = new HashSet<String>();
    }
    
    public boolean hasResponses() {
        return !this.reponses.isEmpty();
    }
    
    public void clearResponses() {
        this.reponses = new HashSet<String>();
    }
    
    public void removeResponse(String id) {
        if(this.reponses.contains(id)) {
            this.reponses.remove(id);
        }
    }
    
    public void addResponse(Comment comment) {
        if (!this.reponses.contains(comment.getUuid())) {
            this.reponses.add(comment.getUuid());
        }
    }
    
    public HashSet<String> getReponses() {
        return this.reponses;
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
    
    public String getParentId() {
        return this.parentId;
    }
    
    @Override
    public String toString() {
        return this.owner.getName() + " - " + this.content;
    }
    
}
