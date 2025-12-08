package in.co.rays.proj4.util;

import java.util.HashMap;

/**
 * Utility class for building email messages in HTML format.
 * 
 * <p>
 * This class provides static methods to generate email content for different
 * scenarios such as user registration, password recovery, and password change.
 * The messages are returned as HTML strings.
 * </p>
 * 
 * <p>
 * @author mehre
 * Version: 1.0
 * </p>
 */
public class EmailBuilder {

    /**
     * Generates an email message for user registration.
     * 
     * @param map HashMap containing keys "login" and "password" for the user
     * @return HTML formatted registration message
     */
    public static String getUserRegistrationMessage(HashMap<String, String> map) {
        StringBuilder msg = new StringBuilder();
        msg.append("<HTML><BODY>");
        msg.append("<H1>Welcome to ORS, ").append(map.get("login")).append("!</H1>");
        msg.append("<P>Your registration is successful. You can now log in and manage your account.</P>");
        msg.append("<P><B>Login Id: ").append(map.get("login"))
           .append("<BR>Password: ").append(map.get("password")).append("</B></P>");
        msg.append("<P>Change your password after logging in for security reasons.</P>");
        msg.append("<P>For support, contact +91 98273 60504 or hrd@sunrays.co.in.</P>");
        msg.append("</BODY></HTML>");
        return msg.toString();
    }

    /**
     * Generates an email message for password recovery (forgot password).
     * 
     * @param map HashMap containing keys "firstName", "lastName", "login", "password"
     * @return HTML formatted password recovery message
     */
    public static String getForgetPasswordMessage(HashMap<String, String> map) {
        StringBuilder msg = new StringBuilder();
        msg.append("<HTML><BODY>");
        msg.append("<H1>Password Recovery</H1>");
        msg.append("<P>Hello, ").append(map.get("firstName")).append(" ").append(map.get("lastName")).append(".</P>");
        msg.append("<P>Your login details are:</P>");
        msg.append("<P><B>Login Id: ").append(map.get("login"))
           .append("<BR>Password: ").append(map.get("password")).append("</B></P>");
        msg.append("</BODY></HTML>");
        return msg.toString();
    }

    /**
     * Generates an email message for notifying the user that their password has been changed.
     * 
     * @param map HashMap containing keys "firstName", "lastName", "login", "password"
     * @return HTML formatted password change confirmation message
     */
    public static String getChangePasswordMessage(HashMap<String, String> map) {
        StringBuilder msg = new StringBuilder();
        msg.append("<HTML><BODY>");
        msg.append("<H1>Password Changed Successfully</H1>");
        msg.append("<P>Dear ").append(map.get("firstName")).append(" ").append(map.get("lastName"))
           .append(", your password has been updated.</P>");
        msg.append("<P>Your updated login details are:</P>");
        msg.append("<P><B>Login Id: ").append(map.get("login"))
           .append("<BR>New Password: ").append(map.get("password")).append("</B></P>");
        msg.append("</BODY></HTML>");
        return msg.toString();
    }
}
