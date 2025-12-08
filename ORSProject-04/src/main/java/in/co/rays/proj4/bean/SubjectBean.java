package in.co.rays.proj4.bean;

/**
 * SubjectBean is a JavaBean that represents Subject information.
 * It contains subject details such as name, courseId, courseName, and description.
 * 
 * @author 
 */
/**
 * @author mehre
 *
 */
public class SubjectBean extends BaseBean{

    /**
     * Name of the subject.
     */
    private String name;

    /**
     * ID of the course to which this subject belongs.
     */
    private long courseId;

    /**
     * Name of the course.
     */
    private String courseName;

    /**
     * Description of the subject.
     */
    private String description;

    /**
     * Gets the subject name.
     * @return name of the subject
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the subject name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the course ID.
     * @param courseId the course ID to set
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the course ID.
     * @return courseId
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * Gets the course name.
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name.
     * @param courseName the course name to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the subject description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the subject description.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the key for dropdown lists.
     * @return id as String
     */
    @Override
    public String getKey() {
        return id + "";
    }

    /**
     * Returns the value for dropdown lists.
     * @return subject name
     */
    @Override
    public String getValue() {
        return name;
    }
    
}
