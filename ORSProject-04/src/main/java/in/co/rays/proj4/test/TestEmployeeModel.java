package in.co.rays.proj4.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.EmployeeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.model.EmployeeModel;

public class TestEmployeeModel {

    public static void main(String[] args) throws DatabaseException, ParseException {

        // testAdd();
         //testDelete();
         //testUpdate();
        // testFindByPk();
         testSearch();
    }

    /* ===================== ADD ===================== */
    public static void testAdd() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        EmployeeBean bean = new EmployeeBean();

        bean.setName("Inaya");
        bean.setEmail("inaya@gmail.com");
        bean.setPhone("9876543210");
        bean.setSalary("45000");
        bean.setDepartment("HR");

        try {
            bean.setJoinDate(sdf.parse("2023-01-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        EmployeeModel model = new EmployeeModel();
        try {
            model.add(bean);
            System.out.println("Employee Added Successfully");
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /* ===================== DELETE ===================== */
    public static void testDelete() {

        EmployeeBean bean = new EmployeeBean();
        bean.setId(21);

        EmployeeModel model = new EmployeeModel();
        try {
            model.delete(bean);
            System.out.println("Employee Deleted Successfully");
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /* ===================== UPDATE ===================== */
    public static void testUpdate() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        EmployeeBean bean = new EmployeeBean();
        bean.setId(1);
        bean.setName("Mehreen");
        bean.setEmail("mehreen@gmail.com");
        bean.setPhone("9999999999");
        bean.setSalary("60000");
        bean.setDepartment("IT");

        try {
            bean.setJoinDate(sdf.parse("2022-11-03"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        EmployeeModel model = new EmployeeModel();
        try {
            model.update(bean);
            System.out.println("Employee Updated Successfully");
        } catch (ApplicationException e ) {
            e.printStackTrace();
        }
    }

    /* ===================== FIND BY PK ===================== */
    public static void testFindByPk() {

        EmployeeModel model = new EmployeeModel();
        try {
            EmployeeBean bean = model.findByPk(1);

            if (bean == null) {
                System.out.println("Test Find By PK Failed");
            } else {
                System.out.println(bean.getName());
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

   
    /* ===================== SEARCH ===================== */
    public static void testSearch() {

        try {
            EmployeeModel model = new EmployeeModel();
            EmployeeBean bean = new EmployeeBean();

            List list = new ArrayList();
            bean.setDepartment("IT");

            list = model.search(bean, 0, 0);

            if (list.size() < 0) {
                System.out.println("Test Search Failed");
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
}
