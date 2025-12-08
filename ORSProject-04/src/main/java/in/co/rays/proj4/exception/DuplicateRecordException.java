package in.co.rays.proj4.exception;

/**
 * DuplicateRecordException is a custom checked exception that indicates
 * an attempt to create or insert a record that already exists in the system.
 *
 * <p>This exception is commonly thrown in scenarios such as:</p>
 * <ul>
 *   <li>Adding a user with an existing login ID</li>
 *   <li>Adding a role with an existing name</li>
 *   <li>Any operation where unique constraint is violated</li>
 * </ul>
 *
 * <p>
 * It helps to prevent duplicate entries and maintain data integrity.
 * </p>
 *
 * @author mehre
 * @version 1.0
 * @since 1.0
 */
public class DuplicateRecordException extends Exception {

    /**
     * Constructs a DuplicateRecordException with the specified 
     * detail message.
     *
     * @param msg the detail message explaining the duplication error
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }
}
