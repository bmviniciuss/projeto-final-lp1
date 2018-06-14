package utils;

import social.Post;

/**
 *
 * @author bmvin
 */
public class WindowTitles {
    
    public static String requestTitle(String name) {
        return "Social App - Request - " + name.trim();
    }

    public static String usersNameWindowTitle(String name) {
        if (Validators.checkNotEmptyStringNotNull(name)) {
            return "Social App - " + name;
        }
        return "Social App";
    }
    
    public static String postWindowTitle(Post post) {
        String title = "";
        String ownerName = post.getOwner().getName();
        if(Validators.checkNotEmptyStringNotNull(ownerName)) {
            title += ownerName;
        }
        
        int numLikes = post.numLikes();
        if(numLikes > 0) {
            title += " - Likes: " + numLikes;
        }
        
        String content = post.getContent();
        if(Validators.checkNotEmptyStringNotNull(content)) {
            title += " - " + content;
        }
        return title;
    }
}
