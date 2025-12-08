package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.model.StudentModel;

public class TestStudentModel {
	public static void main(String[] args) throws ParseException  {
		
	//	testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
//		testfindByEmailID();
//		testSearch();
	}
	
	//testadd
		public static void testAdd() throws ParseException  {
			
			StudentBean bean = new StudentBean();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			bean.setFirstName("Mehreen");
			bean.setLastName("Ansari");
			bean.setDob(sdf.parse("2004/11/04"));
			bean.setGender("Female");
			bean.setMobileNo("7804852241");
			bean.setEmail("meh@gmail.com");
			bean.setCollegeId(1);
			bean.setCreatedBy("admin");
			bean.setModifiedBy("admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			
			StudentModel model = new  StudentModel();
			try {
				model.add(bean);
				System.out.println("Data added successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		//testUpdate
		
		public static void testUpdate() throws ParseException {

			StudentBean bean = new StudentBean();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			
			bean.setId(1);
			bean.setFirstName("Munira");
			bean.setLastName("Sadaf");
			bean.setDob(sdf.parse("2003/11/21"));
			bean.setGender("Female");
			bean.setMobileNo("78048522561");
			bean.setEmail("ms@gmail.com");
			bean.setCollegeId(1);
			bean.setCreatedBy("admin");
			bean.setModifiedBy("admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

			StudentModel model = new StudentModel();
			
			try {
				
				model.add(bean);
				System.out.println("Student updated successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//delete Method
		
		public static void testDelete() {

			StudentBean bean = new StudentBean();
			StudentModel model = new StudentModel();

			bean.setId(3);
			
			try {
				model.delete(bean);
				System.out.println("student  deleted successfully");
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		
		//testfindByPk
		public static void testFindByPk() {
			
	        StudentModel model = new StudentModel();
	        	
			StudentBean existsbean;
			
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
		
		//testfindByemailid
		public static void testfindByEmailID() {
			
			StudentModel model = new StudentModel();
			
			try {
				StudentBean existsBean= model.findByEmailId("ms@gmail.com");
				
				System.out.println("email exists");
				
			} catch (ApplicationException e) {
				
				e.printStackTrace();
			}
}
		
		//testSearch
		
		public static void testSearch(){
			
			try {
				StudentModel model = new StudentModel();
				StudentBean bean = new StudentBean();
				
				List list = new ArrayList();
				bean.setFirstName("Mehreen");
				list = model.search(bean, 0, 0);
				
				if (list.size() < 0) {
					System.out.println("Test Search Fail");
				}
				
				Iterator it = list.iterator();
				while (it.hasNext()) {
					bean = (StudentBean) it.next();
					System.out.println(bean.getCollegeId());
					System.out.println(bean.getCollegeName());
					System.out.println(bean.getEmail());
					System.out.println(bean.getMobileNo());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	
}