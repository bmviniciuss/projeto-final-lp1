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
public class FriendshipManager {
    public static void sendRequest(User origin, User target) {
        target.sendRequest(origin.getUuid());
        origin.addRequestToPending(target.getUuid());
    }
    
    public static void acceptRequest(User origin, User target) {
        target.acceptRequest(origin.getUuid());
        origin.removeFromPending(target.getUuid());
        origin.addFriend(target.getUuid());
    }
}
