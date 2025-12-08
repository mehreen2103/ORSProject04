
package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.bean.TimetableBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.MarksheetModel;
import in.co.rays.proj4.model.SubjectModel;
import in.co.rays.proj4.model.TimeTableModel;


public class TestTimetableModel {

	public static void main(String[] args) throws DatabaseException, ParseException {


//		testAdd();
//		testUpdate();
//		testFindByPk();
//		testcheckByCourseName();
//		testcheckBySubjectName();
//		testcheckBySemester();
 
//		testcheckByExamTime();
//		testSearch();
//  	testDelete();
	}

	
//testAdd 
	public static void testAdd() {

		TimetableBean bean = new TimetableBean();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setSemester("First");
		bean.setDescription("Java");
		try {
			bean.setExamDate(sdf.parse("2025-11-15"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		bean.setExamTime(" 1 PM");
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		TimeTableModel model = new TimeTableModel();

		try {
			model.add(bean);
			System.out.println("Timetable Added Successfully");
		} catch (ApplicationException | DuplicateRecordException e) {
			e.printStackTrace();
		}
	}
//testUpdate
	public static void testUpdate() {

		TimetableBean bean = new TimetableBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setId(1);
		bean.setSemester("First");
		bean.setDescription(" AIML ");
		try {
			bean.setExamDate(sdf.parse("2025-12-15"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		bean.setExamTime("2 PM");
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		TimeTableModel model = new TimeTableModel();
		try {
			model.update(bean);
			System.out.println("Timetable update successfully");
		} catch (ApplicationException | DuplicateRecordException e) {

			e.printStackTrace();
		}
	}
	
//testFindbyPk
	public static void testFindByPk() {

		TimeTableModel model = new TimeTableModel();
		try {
			TimetableBean bean = model.findByPk(1);

			if (bean == null) {
				System.out.println("Test Find by pk fail");

			}
			System.out.println(bean.getCourseName());

		} catch (ApplicationException e) {

			e.printStackTrace();
		}
	}
//testFindBycoursename
	public static void testcheckByCourseName() throws ParseException {

		TimeTableModel model = new TimeTableModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse("2025-12-15");
			TimetableBean bean = model.checkByCourseName(1L, date);

			if (bean == null) {
				System.out.println("Test Find by rollNo fail");

			}
			System.out.println("ID: " + bean.getId());
			System.out.println("Semester: " + bean.getSemester());
			System.out.println("Description: " + bean.getDescription());
			System.out.println("Exam Date: " + bean.getExamDate());
			System.out.println("Course Name: " + bean.getCourseName());

		} catch (ApplicationException e) {

			e.printStackTrace();
		}
	}

	
	//testcheckbySubjectName
	public static void testcheckBySubjectName() throws ParseException {

		TimeTableModel model = new TimeTableModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = sdf.parse("2025-12-15");
			TimetableBean bean = model.checkBySubjectName(1L,1L, date);

			if (bean == null) {
				System.out.println("Test Find by rollNo fail");

			}
			System.out.println("ID: " + bean.getId());
			System.out.println("Semester: " + bean.getSemester());
			System.out.println("Description: " + bean.getDescription());
			System.out.println("Exam Date: " + bean.getExamDate());
			System.out.println("Course Name: " + bean.getCourseName());

		} catch (ApplicationException e) {

			e.printStackTrace();
		}
	}
//testcheckbysemester
	public static void testcheckBySemester() throws ParseException {

		TimeTableModel model = new TimeTableModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = sdf.parse("2025-12-15");
			TimetableBean bean = model.checkBySemester(1L, 1L, "First", date);

			if (bean == null) {
				System.out.println("Test Find by rollNo fail");

			}
			System.out.println("ID: " + bean.getId());
			System.out.println("Semester: " + bean.getSemester());
			System.out.println("Description: " + bean.getDescription());
			System.out.println("Exam Date: " + bean.getExamDate());
			System.out.println("Course Name: " + bean.getCourseName());

		} catch (ApplicationException e) {

			e.printStackTrace();
		}
	}
//testcheckbyExamTime
	public static void testcheckByExamTime() throws ParseException {

		TimeTableModel model = new TimeTableModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = sdf.parse("2025-12-15");
			TimetableBean bean = model.checkByExamTime(1L, 1L, "First", date, "2 PM", " AIML ");

			if (bean == null) {
				System.out.println("Test Find by rollNo fail");

			}
			System.out.println("ID: " + bean.getId());
			System.out.println("Semester: " + bean.getSemester());
			System.out.println("Description: " + bean.getDescription());
			System.out.println("Exam Date: " + bean.getExamDate());
			System.out.println("Course Name: " + bean.getCourseName());
 
		} catch (ApplicationException e) {

			e.printStackTrace();
		}
	}

	public static void testSearch() {
		try {
			TimeTableModel model = new TimeTableModel();
			TimetableBean bean = new TimetableBean();
			List list = new ArrayList();
			bean.setSubjectId(1L);
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (TimetableBean) it.next();
				System.out.println(bean.getExamTime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
	
	public static void testDelete() {

		TimetableBean bean = new TimetableBean();
		bean.setId(2);

		TimeTableModel model = new TimeTableModel();

		try {
			model.delete(bean);
			System.out.println("Timetable deleted Successfully");
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
