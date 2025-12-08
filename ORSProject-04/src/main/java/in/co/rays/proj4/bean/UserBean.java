package in.co.rays.proj4.bean;

import java.util.Date;

/**
 * UserBean represents a user of the application.
 * It stores personal information such as name, login details,
 * contact details, role, and date of birth.
 * 
 * This bean extends BaseBean.
 */
/**
 * @author mehre
 *
 */
public class UserBean extends BaseBean {
    
    /**
     * User's first name.
     */
    private String firstName;

    /**
     * User's last name.
     */
    private String lastName;

    /**
     * User's login ID (email or username).
     */
    private String login;

    /**
     * User's password.
     */
    private String password;

    /**
     * Confirm password for verification.
     */
    private String confirmPassword;

    /**
     * Date of birth of the user.
     */
    private Date dob;

    /**
     * User's mobile number.
     */
    private String mobileNo;

    /**
     * Role ID assigned to the user (e.g., Admin, Student, Faculty).
     */
    private long roleId;

    /**
     * Gender of the user.
     */
    private String gendeer;

    /**
     * Gets the first name.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     * @param firstName user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * @param lastName user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the login ID.
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login ID.
     * @param login user login ID
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the password.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * @param password to be set for user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the confirm password.
     * @return confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Sets the confirm password.
     * @param confirmPassword for validation
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Gets the date of birth.
     * @return dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets the date of birth.
     * @param dob user's date of birth
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets the mobile number.
     * @return mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the mobile number.
     * @param mobileNo user's mobile number
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * Gets the role ID of the user.
     * @return roleId
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID of the user.
     * @param roleId role identifier
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets gender.
     * @return gendeer
     */
    public String getGender() {
        return gendeer;
    }

    /**
     * Sets gender.
     * @param gendeer user gender
     */
    public void setGender(String gendeer) {
        this.gendeer = gendeer;
    }

    /**
     * Returns key for dropdown list.
     * @return id as String
     */
    @Override
    public String getKey() {
        return id + "";
    }

    /**
     * Returns value for dropdown list.
     * @return full name of user
     */
    @Override
    public String getValue() {
        return firstName + "" + lastName;
    }
}
