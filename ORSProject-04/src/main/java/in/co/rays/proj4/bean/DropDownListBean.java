package in.co.rays.proj4.bean;

/**
 * DropDownListBean is a common interface used for providing
 * key–value pairs for dropdown components in the application.
 * 
 * Classes implementing this interface must return:
 * - getKey(): a unique identifier (usually ID)
 * - getValue(): a displayable value (usually Name)
 */
/**
 * @author mehre
 *
 */
public interface DropDownListBean {

    /**
     * Returns the unique key used in dropdown lists.
     * 
     * @return key as a String
     */
    public String getKey();

    /**
     * Returns the value to be displayed in dropdown lists.
     * 
     * @return value as a String
     */
    public String getValue();

}
