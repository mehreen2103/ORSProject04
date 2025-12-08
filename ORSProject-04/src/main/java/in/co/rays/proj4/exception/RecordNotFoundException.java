package in.co.rays.proj4.exception;

/**
 * RecordNotFoundException is a custom checked exception that indicates
 * that the requested record could not be found in the database or system.
 *
 * <p>This exception is typically thrown in situations such as:</p>
 * <ul>
 *   <li>Searching for a record by primary key that does not exist</li>
 *   <li>Attempting to update or delete a record that is missing</li>
 *   <li>Any lookup operation where the expected data is not found</li>
 * </ul>
 *
 * <p>
 * This helps in clearly handling cases where the data is unavailable.
 * </p>
 *
 * @author mehre
 * @version 1.0
 * @since 1.0
 */
public class RecordNotFoundException extends Exception {

    /**
     * Constructs a RecordNotFoundException with the specified
     * detail message.
     *
     * @param msg the detail message explaining why the record was not found
     */
    public RecordNotFoundException(String msg) {
        super(msg);
    }
}
