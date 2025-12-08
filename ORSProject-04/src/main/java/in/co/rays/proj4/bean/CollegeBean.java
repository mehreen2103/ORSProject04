package in.co.rays.proj4.bean;

/**
 * CollegeBean represents the College entity containing details such as
 * name, address, state, city, and phone number.
 * 
 * It extends BaseBean to inherit common fields like id, createdBy,
 * modifiedBy, createdDatetime, and modifiedDatetime.
 */
/**
 * @author mehre
 *
 */
public class CollegeBean extends BaseBean {

    /**
     * Name of the college.
     */
    private String name;

    /**
     * Address of the college.
     */
    private String address;

    /**
     * State where the college is located.
     */
    private String state;

    /**
     * City where the college is located.
     */
    private String city;

    /**
     * Contact phone number of the college.
     */
    private String phoneNo;

    /**
     * Gets the name of the college.
     * 
     * @return name of the college
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the college.
     * 
     * @param name name of the college
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the college.
     * 
     * @return address of the college
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the college.
     * 
     * @param address college address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the state of the college.
     * 
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state of the college.
     * 
     * @param state state of the college
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the city of the college.
     * 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the college.
     * 
     * @param city city of the college
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the phone number of the college.
     * 
     * @return phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the phone number of the college.
     * 
     * @param phoneNo contact number of the college
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Returns the unique key for dropdown lists.
     * 
     * @return id as a string
     */
    @Override
    public String getKey() {
        return id + "";
    }

    /**
     * Returns the display value for dropdown lists.
     * 
     * @return college name
     */
    @Override
    public String getValue() {
        return name;
    }

}
