package in.co.rays.proj4.test;

import java.sql.SQLException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.model.CollegeModel;

public class TestCollegeModel {

	public static void main(String[] args) throws SQLException, ApplicationException {
		
//		testAdd();
//		testUpdate();
		testDelete();
//		testFindByPk();
//		testFindByName();
//		testSearch();
		
	}
	
	//testadd
	public static void testAdd() {
		
		CollegeBean bean = new CollegeBean();
		bean.setName("Parul University");
		bean.setAddress("Vadodra");
		bean.setState("Gujarat");
		bean.setCity("Vadodra");
		bean.setPhoneNo("7804852241");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		CollegeModel model = new  CollegeModel();
		try {
			model.add(bean);
			System.out.println("College added successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	//testupdate
	public static void testUpdate() {

		CollegeBean bean = new CollegeBean();
		bean.setId(2);
		bean.setName("Amity university");
		bean.setAddress("noida");
		bean.setState("Uttar Pradesh");
		bean.setCity("noida");
		bean.setPhoneNo("7804852241");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		try {
			model.add(bean);
			System.out.println("College updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//testdelete
	public static void testDelete() {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		bean.setId(4);
		try {
			model.delete(bean);
			System.out.println("college  deleted successfully");
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	//testfindbypk
	
	public static void testFindByPk() {
		
        CollegeModel model = new CollegeModel();
        	
		CollegeBean existsbean;
		
		try {
			existsbean = model.findByPk(1);
			if(existsbean != null) {
				System.out.println("ID exists");
			} else {
				System.out.println("no record found");
			}
		} catch (ApplicationException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	//testfindbyName
	
	public static void testFindByName() throws SQLException, ApplicationException {

		CollegeModel model = new CollegeModel();
		
		CollegeBean existsbean = model.findByName("Parul University");
		
		if(existsbean != null) {
			System.out.println("name exists");
		} else {
			System.out.println("no record found");
		}

	}
	
	//search Method
	public static void testSearch() {
		try {
			CollegeModel model = new CollegeModel();
			CollegeBean bean = new CollegeBean();
			
			List list = new ArrayList();
			bean.setCity("Vadodra");
			list = model.search(bean, 0, 0);
			
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (CollegeBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getPhoneNo());
				System.out.println(bean.getState());
			}
			
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
}
