package in.co.rays.proj4.bean;

import java.util.Date;

/**
 * FacultyBean represents the faculty information including personal details,
 * contact information, and associated college, course, and subject details.
 * 
 * It extends BaseBean to inherit common audit fields such as id, createdBy,
 * modifiedBy, createdDatetime, and modifiedDatetime.
 */
/**
 * @author mehre
 *
 */
public class FacultyBean extends BaseBean {

    /**
     * First name of the faculty member.
     */
    private String firstName;

    /**
     * Last name of the faculty member.
     */
    private String lastName;

    /**
     * Date of birth of the faculty member.
     */
    private Date dob;

    /**
     * Gender of the faculty member.
     */
    private String gender;

    /**
     * Mobile number of the faculty member.
     */
    private String mobileNo;

    /**
     * Email address of the faculty member.
     */
    private String email;

    /**
     * ID of the college to which the faculty belongs.
     */
    private long collegeId;

    /**
     * Name of the college to which the faculty belongs.
     */
    private String collegeName;

    /**
     * ID of the course taught by the faculty.
     */
    private long courseId;

    /**
     * Name of the course taught by the faculty.
     */
    private String courseName;

    /**
     * ID of the subject taught by the faculty.
     */
    private long subjectId;

    /**
     * Name of the subject taught by the faculty.
     */
    private String subjectName;

    /**
     * Gets the first name of the faculty.
     * 
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the faculty.
     * 
     * @param firstName faculty first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the faculty.
     * 
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the faculty.
     * 
     * @param lastName faculty last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the date of birth of the faculty.
     * 
     * @return dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the faculty.
     * 
     * @param dob date of birth
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets the gender of the faculty.
     * 
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the faculty.
     * 
     * @param gender gender value
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the mobile number of the faculty.
     * 
     * @return mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the mobile number of the faculty.
     * 
     * @param mobileNo mobile number
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * Gets the email of the faculty.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the faculty.
     * 
     * @param email email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the college ID associated with the faculty.
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
     * Gets the college name associated with the faculty.
     * 
     * @return collegeName
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * Sets the college name.
     * 
     * @param collegeName name of the college
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * Gets the course ID associated with the faculty.
     * 
     * @return courseId
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * Sets the course ID.
     * 
     * @param courseId ID of the course
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the course name associated with the faculty.
     * 
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name.
     * 
     * @param courseName name of the course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the subject ID associated with the faculty.
     * 
     * @return subjectId
     */
    public long getSubjectId() {
        return subjectId;
    }

    /**
     * Sets the subject ID.
     * 
     * @param subjectId ID of the subject
     */
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Gets the subject name associated with the faculty.
     * 
     * @return subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the subject name.
     * 
     * @param subjectName name of the subject
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Returns the key for dropdown usage.
     * 
     * @return null (not implemented)
     */
    @Override
    public String getKey() {
        return null;
    }

    /**
     * Returns the value for dropdown usage.
     * 
     * @return null (not implemented)
     */
    @Override
    public String getValue() {
        return null;
    }

}
