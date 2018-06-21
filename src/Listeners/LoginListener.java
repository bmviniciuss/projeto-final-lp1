
package Listeners;



public interface LoginListener {

    /**
     * Send login credentials to a parent component.
     * @param email
     * @param password
     */
    public void sendLoginCredentials(String email, String password);
    
}
