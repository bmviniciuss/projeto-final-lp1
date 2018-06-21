package Listeners;

import social.User;


public interface CreateAccountListener {

    /**
     * Send a User to a parent Component.
     * @param user
     * @param password
     */
    public void sendUser(User user, String password);
}
