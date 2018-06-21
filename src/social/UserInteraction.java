package social;

/**
 *
 * @author bmvin
 */
public class UserInteraction {

    /**
     *
     * @param origin
     * @param target
     */
    public static void sendRequest(User origin, User target) {
        if (!target.isPending(origin.getUuid()) && !origin.isPending(target.getUuid())) {
            target.sendRequest(origin.getUuid());
            origin.addRequestToPending(target.getUuid());
        }
    }

    /**
     *
     * @param origin
     * @param target
     */
    public static void acceptRequest(User origin, User target) {
        target.acceptRequest(origin.getUuid());
        target.removeFromPending(origin.getUuid());
        origin.removeFromPending(target.getUuid());
        origin.addFriend(target.getUuid());
    }
}
