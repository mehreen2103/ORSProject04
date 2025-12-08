package in.co.rays.proj4.bean;

import java.sql.Timestamp;

/**
 * BaseBean is an abstract class that represents common attributes 
 * shared by all beans such as id, createdBy, modifiedBy, 
 * createdDatetime, and modifiedDatetime.
 * 
 * It implements DropDownListBean for dropdown-related functionality.
 */
/**
 * @author mehre
 *
 */
public abstract class BaseBean implements DropDownListBean {

    /**
     * Primary key of the record.
     */
    protected long id;

    /**
     * Username who created the record.
     */
    protected String createdBy;

    /**
     * Username who last modified the record.
     */
    protected String modifiedBy;

    /**
     * Timestamp when the record was created.
     */
    protected Timestamp createdDatetime;

    /**
     * Timestamp when the record was last modified.
     */
    protected Timestamp modifiedDatetime;

    /**
     * Gets the primary key ID.
     * 
     * @return id of the record
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the primary key ID.
     * 
     * @param id unique identifier
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the creator's username.
     * 
     * @return createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the creator's username.
     * 
     * @param createdBy created by user
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the username who last modified the record.
     * 
     * @return modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Sets the username who modified the record.
     * 
     * @param modifiedBy modified by user
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Gets the creation timestamp.
     * 
     * @return createdDatetime
     */
    public Timestamp getCreatedDatetime() {
        return createdDatetime;
    }

    /**
     * Sets the creation timestamp.
     * 
     * @param createdDatetime timestamp of creation
     */
    public void setCreatedDatetime(Timestamp createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    /**
     * Gets the last modification timestamp.
     * 
     * @return modifiedDatetime
     */
    public Timestamp getModifiedDatetime() {
        return modifiedDatetime;
    }

    /**
     * Sets the last modification timestamp.
     * 
     * @param modifiedDatetime timestamp of last modification
     */
    public void setModifiedDatetime(Timestamp modifiedDatetime) {
        this.modifiedDatetime = modifiedDatetime;
    }

}
