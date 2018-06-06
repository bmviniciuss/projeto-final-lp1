/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

/**
 *
 * @author bmvin
 */
public class UserInteraction {
    public static void deletePost(User user, Post post) {
        if(post.getOwner().getUuid().equals(user.getUuid())) {
            user.removePost(post);
        }
    }
}
