package in.co.rays.proj4.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.DepartmentBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.model.DepartmentModel;

public class TestDepartmentModel {

	public static DepartmentModel model = new DepartmentModel();

	public static void main(String[] args) throws ApplicationException, SQLException {

//		testAdd();
//		testUpdate();
		testDelete();
//		testFindByPk();
//		testFindByName();
//		testSearch();

	}

	// ------------------- testAdd --------------------//
	public static void testAdd() throws ApplicationException {

		DepartmentBean bean = new DepartmentBean();

		bean.setName("Marketing");
		bean.setDescription("Marketing");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		try {
			model.add(bean);
			System.out.println("Department added successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------- testUpdate --------------------//
	public static void testUpdate() throws ApplicationException {

		DepartmentBean bean = new DepartmentBean();

		bean.setId(6);
		bean.setName("IT");
		bean.setDescription("IT");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		try {
			model.update(bean);
			System.out.println("Department updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------- testDelete --------------------//
	public static void testDelete() {

		DepartmentBean bean = new DepartmentBean();
		bean.setId(6);

		try {
			model.delete(bean);
			System.out.println("Department deleted successfully");
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	// ------------------- testFindByPk --------------------//
	public static void testFindByPk() {

		try {
			DepartmentBean bean = model.findByPk(1);

			if (bean != null) {
				System.out.println("ID exists");
				System.out.println(bean.getName());
			} else {
				System.out.println("No record found");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	// ------------------- testFindByName --------------------//
	public static void testFindByName() throws SQLException, ApplicationException {

		DepartmentBean bean = model.findByName("Sales");

		if (bean != null) {
			System.out.println("Department name exists");
		} else {
			System.out.println("No record found");
		}
	}

	// ------------------- testSearch --------------------//
	public static void testSearch() {

		try {
			DepartmentBean bean = new DepartmentBean();
			bean.setName("S");

			List list = new ArrayList();
			list = model.search(bean, 0, 0);

			if (list.size() < 0) {
				System.out.println("Test search failed");
			}

			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (DepartmentBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getDescription());
				System.out.println(bean.getCreatedBy());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
}
