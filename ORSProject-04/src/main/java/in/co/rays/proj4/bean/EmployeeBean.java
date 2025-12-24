package in.co.rays.proj4.bean;

import java.util.Date;

public class EmployeeBean extends BaseBean {

    private long id;
    private String name;
    private String email;
    private String phone;
    private String salary;
    private String department;
    private Date joinDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

	@Override
	public String getKey() {
		
		 return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return name + "";
	}
}
