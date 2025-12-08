package in.co.rays.proj4.exception;

/**
 * ApplicationException is a custom checked exception 
 * used to indicate application-level errors.
 *
 * This exception is thrown when a generic or unknown 
 * problem occurs in the application logic.
 *
 * Examples:
 * - Database connectivity issues
 * - Internal processing errors
 * - Unhandled application-level failures
 *
 * @author mehre
 * @version 1.0
 * @since 1.0
 */
public class ApplicationException extends Exception {

    /**
     * Creates an ApplicationException with the given message.
     *
     * @param msg the detail message describing the exception
     */
    public ApplicationException(String msg) {
        super(msg);
    }
}
