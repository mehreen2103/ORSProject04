package in.co.rays.proj4.bean;

/**
 * CourseBean represents a course entity containing details such as
 * name, duration, and description of the course.
 * 
 * It extends BaseBean to inherit common fields like id, createdBy,
 * modifiedBy, createdDatetime, and modifiedDatetime.
 */
/**
 * @author mehre
 *
 */
public class CourseBean extends BaseBean {

    /**
     * Name of the course.
     */
    private String name;

    /**
     * Duration of the course.
     */
    private String duration;

    /**
     * Description of the course.
     */
    private String description;

    /**
     * Gets the name of the course.
     * 
     * @return name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the course.
     * 
     * @param name course name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the duration of the course.
     * 
     * @return duration of the course
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the course.
     * 
     * @param duration course duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets the description of the course.
     * 
     * @return description of the course
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the course.
     * 
     * @param description course description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return course name
     */
    @Override
    public String getValue() {
        return name;
    }

}
