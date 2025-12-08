package in.co.rays.proj4.exception;

/**
 * DatabaseException is a custom checked exception that 
 * represents errors occurring during database operations.
 *
 * This exception is typically thrown in cases such as:
 * <ul>
 *   <li>SQL syntax errors</li>
 *   <li>Connection failure</li>
 *   <li>Transaction failure</li>
 *   <li>Database constraints violation</li>
 * </ul>
 *
 * It is used to wrap database-related problems in the 
 * application layer.
 *
 * @author mehre
 * @version 1.0
 * @since 1.0
 */
public class DatabaseException extends Exception {

    /**
     * Constructs a DatabaseException with the specified detail message.
     *
     * @param msg the message describing the database-related error
     */
    public DatabaseException(String msg) {
        super(msg);
    }
}
