package in.co.rays.proj4.bean;

/**
 * MarksheetBean represents the marksheet details of a student including
 * roll number, student ID, name, and marks in subjects like Physics, 
 * Chemistry, and Maths.
 * 
 * It extends BaseBean to inherit common audit fields such as id, createdBy,
 * modifiedBy, createdDatetime, and modifiedDatetime.
 */
/**
 * @author mehre
 *
 */
public class MarksheetBean extends BaseBean {

    /**
     * Roll number of the student.
     */
    private String rollNo;

    /**
     * Unique ID of the student.
     */
    private long studentId;

    /**
     * Name of the student.
     */
    private String name;

    /**
     * Marks obtained in Physics.
     */
    private Integer physics;

    /**
     * Marks obtained in Chemistry.
     */
    private Integer chemistry;

    /**
     * Marks obtained in Maths.
     */
    private Integer maths;

    /**
     * Gets the roll number of the student.
     * 
     * @return rollNo
     */
    public String getRollNo() {
        return rollNo;
    }

    /**
     * Sets the roll number of the student.
     * 
     * @param rollNo student's roll number
     */
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    /**
     * Gets the student ID.
     * 
     * @return studentId
     */
    public long getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID.
     * 
     * @param studentId unique student ID
     */
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the name of the student.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     * 
     * @param name student name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the marks obtained in Physics.
     * 
     * @return physics marks
     */
    public Integer getPhysics() {
        return physics;
    }

    /**
     * Sets the marks obtained in Physics.
     * 
     * @param physics marks in Physics
     */
    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

    /**
     * Gets the marks obtained in Chemistry.
     * 
     * @return chemistry marks
     */
    public Integer getChemistry() {
        return chemistry;
    }

    /**
     * Sets the marks obtained in Chemistry.
     * 
     * @param chemistry marks in Chemistry
     */
    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }

    /**
     * Gets the marks obtained in Maths.
     * 
     * @return maths marks
     */
    public Integer getMaths() {
        return maths;
    }

    /**
     * Sets the marks obtained in Maths.
     * 
     * @param maths marks in Maths
     */
    public void setMaths(Integer maths) {
        this.maths = maths;
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
