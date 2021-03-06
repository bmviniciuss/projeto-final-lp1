/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author bmvin
 */
public class Messages {

    // CREATE ACCOUNT LISTENER MESSAGES
    public static final String CREATE_ACCOUNT_SUCCESS = "Account created successfully.\n";
    public static final String ALREADY_EXISTS_EMAIL_ERROR = "Already exists a user with the same email. Try login or another email.\n";
    // CONSTANTS
    public static final String ACCOUNT_SUCCESS = "Create Account";
    public static final String EMAIL_ERROR = "Email Error";

    // LOGIN LISTENER MESSAGES
    public static final String INVALID_LOGIN = "Email or password is wrong.\n";
    // CONSTANTS
    public static final String INVALID_LOGIN_ERROR = "Invalid Login";

    // LOGIN PANEL AND CREATE ACCOUNT PANEL MESSAGES
    public static final String EMPTY_EMAIL_ERROR = "Email must be not empty.\n";
    public static final String INVALID_EMAIL_ERROR = "Email must be a valid one.\n";
    public static final String EMPTY_PASSWORD_ERROR = "Password must be not empty.\n";
    public static final String EMPTY_PASSWORD_CONFIRMATION_ERROR = "Password confirmation must be not empty.\n";
    public static final String PASSWORDS_DONT_MATCH_ERROR = "Passwords must match.\n";
    public static final String EMPTY_NAME_ERROR = "Name must not be empty.\n";

    // CONSTANTS
    public static final String LOGIN_ERROR = "Login Error";
    public static final String CREATE_ACCOUNT_ERROR = "createAccountError";

    // NAME SEARCH
    public static final String EMPTY_NAME_SEARCH_FIELD = "Search for a valid name.\n";
    public static final String NO_USERS_FOUND_WITH_THAT_NAME = "No users found with that name.\n";

    // REQUESTS
    public static final String SENT_FRIEND_REQUEST = "has sent a friend request.\n";
    
    // POST
    public static final String EMPTY_POST = "Empty Post";
    public static final String EMPTY_POST_ERROR = "Post must not be empty.\n";
    public static Object NO_GROUPS_FOUND_WITH_THAT_NAME = "No groups found with that name.\n";
}
