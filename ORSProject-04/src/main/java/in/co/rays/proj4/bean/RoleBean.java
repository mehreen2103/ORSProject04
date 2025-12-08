package in.co.rays.proj4.bean;

/**
 * RoleBean represents different roles in the system such as Admin, Student,
 * Faculty, and Kiosk. 
 * 
 * It extends BaseBean to inherit common fields like id, createdBy, 
 * modifiedBy, createdDatetime, and modifiedDatetime.
 */
/**
 * @author mehre
 *
 */
public class RoleBean extends BaseBean {

    /**
     * Constant value representing Admin role.
     */
    public static final int ADMIN = 1;

    /**
     * Constant value representing Student role.
     */
    public static final int STUDENT = 2;

    /**
     * Constant value representing Faculty role.
     */
    public static final int FACULTY = 3;

    /**
     * Constant value representing Kiosk role.
     */
    public static final int KIOSK = 4;

    /**
     * Name of the role.
     */
    private String name;

    /**
     * Description of the role.
     */
    private String description;

    /**
     * Gets the name of the role.
     * 
     * @return role name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the role.
     * 
     * @param name role name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the role.
     * 
     * @return role description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the role.
     * 
     * @param description role description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the unique key used in dropdown lists.
     * 
     * @return id as a string
     */
    @Override
    public String getKey() {
        return id + "";
    }

    /**
     * Returns the value to be displayed in dropdown lists.
     * 
     * @return role name
     */
    @Override
    public String getValue() {
        return name;
    }
}
