package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.EmployeeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.EmployeeModel;

public class TestEmployeeModel {

	public static void main(String[] args) throws DatabaseException, ParseException {

		// testAdd();
		testDelete();
		// testUpdate();
		// testFindByPk();
		// testFindByEmail();
		// testSearch();
		// testList();
	}

	/* ================= ADD ================= */
	public static void testAdd() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		EmployeeBean bean = new EmployeeBean();

		bean.setName("Mehreen");
		bean.setEmail("mehreen@gmail.com");
		bean.setPhone("9876543210");
		bean.setSalary("45000");
		bean.setGender("Female");
		bean.setDepartment("HR");

		try {
			bean.setJoinDate(sdf.parse("2024-01-10"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		EmployeeModel model = new EmployeeModel();

		try {
			model.add(bean);
			System.out.println("Employee added successfully");
		} catch (ApplicationException | DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/* ================= DELETE ================= */
	public static void testDelete() {

		EmployeeBean bean = new EmployeeBean();
		bean.setId(16);

		EmployeeModel model = new EmployeeModel();

		try {
			model.delete(bean);
			System.out.println("Employee deleted successfully");
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/* ================= UPDATE ================= */
	public static void testUpdate() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		EmployeeBean bean = new EmployeeBean();
		bean.setId(2);
		bean.setName("Inaya");
		bean.setEmail("inaya@gmail.com");
		bean.setPhone("9999999999");
		bean.setSalary("60000");
		bean.setGender("Female");
		bean.setDepartment("IT");

		try {
			bean.setJoinDate(sdf.parse("2023-06-15"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		EmployeeModel model = new EmployeeModel();

		try {
			model.update(bean);
			System.out.println("Employee updated successfully");
		} catch (ApplicationException | DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/* ================= FIND BY PK ================= */
	public static void testFindByPk() {

		EmployeeModel model = new EmployeeModel();

		try {
			EmployeeBean bean = model.findByPk(2);

			if (bean == null) {
				System.out.println("Test find by PK fail");
			} else {
				System.out.println(bean.getName());
				System.out.println(bean.getEmail());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/* ================= FIND BY EMAIL ================= */
	public static void testFindByEmail() {

		EmployeeModel model = new EmployeeModel();

		try {
			EmployeeBean bean = model.findByEmail("mehreen@gmail.com");

			if (bean == null) {
				System.out.println("Test find by email fail");
			} else {
				System.out.println(bean.getId());
				System.out.println(bean.getName());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/* ================= SEARCH ================= */
	public static void testSearch() {

		try {
			EmployeeModel model = new EmployeeModel();
			EmployeeBean bean = new EmployeeBean();
			List list = new ArrayList();

			bean.setDepartment("IT");

			list = model.search(bean, 0, 0);

			if (list.size() < 0) {
				System.out.println("Test search fail");
			}

			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (EmployeeBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getEmail());
				System.out.println(bean.getDepartment());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

//	/* ================= LIST ================= */
//	public static void testList() {
//
//		try {
//			EmployeeModel model = new EmployeeModel();
//			List list = model.list();
//
//			Iterator it = list.iterator();
//			while (it.hasNext()) {
//				EmployeeBean bean = (EmployeeBean) it.next();
//				System.out.println(bean.getId());
//				System.out.println(bean.getName());
//				System.out.println(bean.getEmail());
//			}
//
//		} catch (ApplicationException e) {
//			e.printStackTrace();
//		}
//	}
}
