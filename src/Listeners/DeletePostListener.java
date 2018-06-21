
package Listeners;

import social.Post;
import social.User;

public interface DeletePostListener {

    /**
     * Send the post to the parent component. to delete.
     * @param p
     * @param currentUser
     */
    public void deletePost(Post p, User currentUser);
}
