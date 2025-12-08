package in.co.rays.proj4.bean;

import java.util.Date;

/**
 * TimetableBean represents the timetable details for exams.
 * It contains information such as semester, exam date, exam time,
 * course and subject details.
 * 
 * This bean extends BaseBean.
 */
/**
 * @author mehre
 *
 */
public class TimetableBean extends BaseBean {
    
    /**
     * Semester of the exam.
     */
    private String semester;

    /**
     * Description or details of the exam.
     */
    private String description;

    /**
     * Date of the exam.
     */
    private Date examDate;

    /**
     * Exam time (e.g., 10:00 AM - 1:00 PM).
     */
    private String examTime;

    /**
     * ID of the course.
     */
    private long courseId;

    /**
     * Name of the course.
     */
    private String courseName;

    /**
     * ID of the subject.
     */
    private long subjectId;

    /**
     * Name of the subject.
     */
    private String subjectName;

    /**
     * Gets the semester.
     * @return semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the semester.
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Gets the description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * @param description exam description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the exam date.
     * @return examDate
     */
    public Date getExamDate() {
        return examDate;
    }

    /**
     * Sets the exam date.
     * @param examDate the exam date to set
     */
    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    /**
     * Gets the exam time.
     * @return examTime
     */
    public String getExamTime() {
        return examTime;
    }

    /**
     * Sets the exam time.
     * @param examTime the time of the exam
     */
    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    /**
     * Gets the course ID.
     * @return courseId
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * Sets the course ID.
     * @param courseId the course ID to set
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
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
     * @param courseName the name of the course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the subject ID.
     * @return subjectId
     */
    public long getSubjectId() {
        return subjectId;
    }

    /**
     * Sets the subject ID.
     * @param subjectId subject ID
     */
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Gets the subject name.
     * @return subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the subject name.
     * @param subjectName the name of the subject
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Returns key for dropdown list.
     * @return null (not implemented)
     */
    @Override
    public String getKey() {
        return null;
    }

    /**
     * Returns value for dropdown list.
     * @return null (not implemented)
     */
    @Override
    public String getValue() {
        return null;
    }
}
