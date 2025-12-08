package in.co.rays.proj4.util;

/**
 * A simple JavaBean to represent an email message.
 * 
 * <p>
 * This class contains fields for the recipient email address, subject, message content, 
 * and message type (HTML or plain text). It provides getter and setter methods for each field.
 * </p>
 * 
 * <p>
 *@author mehre  
 * Version: 1.0
 * </p>
 */
public class EmailMessage {

    /** Recipient email address */
    private String to;

    /** Subject of the email */
    private String subject;

    /** Content of the email message */
    private String message;

    /** Type of the message: HTML_MSG or TEXT_MSG */
    private int messageType = TEXT_MSG;

    /** Constant representing HTML message type */
    public static final int HTML_MSG = 1;

    /** Constant representing plain text message type */
    public static final int TEXT_MSG = 2;

    /**
     * Default constructor.
     */
    public EmailMessage() {
    }

    /**
     * Parameterized constructor to initialize an email message.
     * 
     * @param to      Recipient email address
     * @param subject Subject of the email
     * @param message Content of the email
     */
    public EmailMessage(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    /** Sets the recipient email address. */
    public void setTo(String to) {
        this.to = to;
    }

    /** Returns the recipient email address. */
    public String getTo() {
        return to;
    }

    /** Sets the subject of the email. */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /** Returns the subject of the email. */
    public String getSubject() {
        return subject;
    }

    /** Sets the content of the email message. */
    public void setMessage(String message) {
        this.message = message;
    }

    /** Returns the content of the email message. */
    public String getMessage() {
        return message;
    }

    /** Sets the type of the message (HTML or plain text). */
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    /** Returns the type of the message (HTML or plain text). */
    public int getMessageType() {
        return messageType;
    }
}
