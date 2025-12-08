
package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.bean.TimetableBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.FacultyModel;


public class TestFacultyModel {

	public static void main(String[] args) throws DatabaseException {

//		FacultyModel model = new FacultyModel();
//		System.out.println(model.nextPk());
//		testAdd();
//		testUpdate();
//		testFindByPk();
//		testFindByEmail();
//		testSearch();
//  	testDelete();

	}

	public static void testAdd() {

		FacultyBean bean = new FacultyBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(1);
		bean.setFirstName("Alifa");
		bean.setLastName("Khanum");
		try {
			bean.setDob(sdf.parse("2000-10-02"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		bean.setGender("female");
		bean.setMobileNo("7804852241");
		bean.setEmail("alifa@gmail.com");
		bean.setCollegeId(1);
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		FacultyModel model = new FacultyModel();

		try {
			model.add(bean);
			System.out.println("Faculty Added Successfully");
		} catch (ApplicationException | DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	public static void testUpdate() {

		FacultyBean bean = new FacultyBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(1);
		bean.setFirstName("Munira");
		bean.setLastName("sadaf");
		try {
			bean.setDob(sdf.parse("2004-11-03"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		bean.setGender("female");
		bean.setMobileNo("7804852241");
		bean.setEmail("meh@gmail.com");
		bean.setCollegeId(1);
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		FacultyModel model = new FacultyModel();

		try {
			model.update(bean);
			System.out.println("Faculty Update Successfully");
		} catch (ApplicationException | DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	public static void testFindByPk() {

		FacultyModel model = new FacultyModel();
		try {
			FacultyBean bean = model.findByPk(1);

			if (bean == null) {
				System.out.println("Test Find by pk fail");

			}
			System.out.println(bean.getFirstName() + " " + bean.getLastName());

		} catch (ApplicationException e) {

			e.printStackTrace();
		}
	}

	public static void testFindByEmail() {

		FacultyModel model = new FacultyModel();
		try {
			FacultyBean bean = model.findByEmail("meh@gmail.com");

			if (bean == null) {
				System.out.println("Test Find by pk fail");

			}
			System.out.println(bean.getFirstName() + " " + bean.getLastName());

		} catch (ApplicationException e) {

			e.printStackTrace();
		}
	}

	public static void testSearch() {
		try {
			FacultyModel model = new FacultyModel();
			FacultyBean bean = new FacultyBean();
			List list = new ArrayList();
			bean.setGender("female");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (FacultyBean) it.next();
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getEmail());
				System.out.println(bean.getMobileNo());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void testDelete() {

		FacultyBean bean = new FacultyBean();
		bean.setId(2);

		FacultyModel model = new FacultyModel();

		try {
			model.delete(bean);
			System.out.println("Faculty deleted Successfully");
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
