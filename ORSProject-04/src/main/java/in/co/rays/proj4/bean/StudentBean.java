package in.co.rays.proj4.bean;

import java.util.Date;

/**
 * StudentBean represents the student details including personal information,
 * contact details, and associated college information.
 * 
 * It extends BaseBean to inherit common fields like id, createdBy, 
 * modifiedBy, createdDatetime, and modifiedDatetime.
 */
/**
 * @author mehre
 *
 */
public class StudentBean extends BaseBean {

    /**
     * First name of the student.
     */
    private String firstName;

    /**
     * Last name of the student.
     */
    private String lastName;

    /**
     * Date of birth of the student.
     */
    private Date dob;

    /**
     * Gender of the student.
     */
    private String gender;

    /**
     * Mobile number of the student.
     */
    private String mobileNo;

    /**
     * Email address of the student.
     */
    private String email;

    /**
     * College ID associated with the student.
     */
    private long collegeId;

    /**
     * Name of the college associated with the student.
     */
    private String collegeName;

    /**
     * Gets the first name of the student.
     * 
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     * 
     * @param firstName student first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student.
     * 
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     * 
     * @param lastName student last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the date of birth of the student.
     * 
     * @return dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the student.
     * 
     * @param dob date of birth
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets the gender of the student.
     * 
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the student.
     * 
     * @param gender gender value
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the mobile number of the student.
     * 
     * @return mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the mobile number of the student.
     * 
     * @param mobileNo mobile number
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * Gets the email address of the student.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student.
     * 
     * @param email student email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the college ID associated with the student.
     * 
     * @return collegeId
     */
    public long getCollegeId() {
        return collegeId;
    }

    /**
     * Sets the college ID.
     * 
     * @param collegeId ID of the college
     */
    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * Gets the name of the college associated with the student.
     * 
     * @return collegeName
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * Sets the college name.
     * 
     * @param collegeName college name
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * Returns the unique key for dropdown lists.
     * 
     * @return id as string
     */
    @Override
    public String getKey() {
        return id + "";
    }

    /**
     * Returns the display value for dropdown lists.
     * 
     * @return student's full name
     */
    @Override
    public String getValue() {
        return firstName + "" + lastName;
    }

}
