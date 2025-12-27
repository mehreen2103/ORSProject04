package in.co.rays.proj4.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.DepartmentBean;
import in.co.rays.proj4.bean.EmployeeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.DepartmentModel;
import in.co.rays.proj4.model.EmployeeModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.PropertyReader;
import in.co.rays.proj4.util.ServletUtility;

/**
 * Employee Controller.
 * Handles Add, Update, Validate, Populate and Load Employee Data.
 * 
 * @author
 * @version 1.0
 */
@WebServlet(name = "EmployeeCtl", urlPatterns = { "/ctl/EmployeeCtl" })
public class EmployeeCtl extends BaseCtl {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(EmployeeCtl.class);
	
	
	@Override
	protected void preload(HttpServletRequest request) {

		Logger log = Logger.getLogger(EmployeeCtl.class);
		log.debug("EmployeeCtl preload started");

		// ===== Static Preload =====
		HashMap<String, String> genderMap = new HashMap<>();
		genderMap.put("Male", "Male");
		genderMap.put("Female", "Female");
		request.setAttribute("genderList", genderMap);

		// ===== Dynamic Preload =====
		DepartmentModel deptModel = new DepartmentModel();
		try {
			List<DepartmentBean> deptList = deptModel.list();
			request.setAttribute("departmentList", deptList);
		} catch (ApplicationException e) {
			log.error("Error in Employee preload", e);
		}

		log.debug("EmployeeCtl preload ended");
	}



	/**
	 * Validation logic for Employee
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {

		log.debug("EmployeeCtl validate started");

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getValue("error.require", "Email"));
			pass = false;
		} else if (!DataValidator.isEmail(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getValue("error.email", "Email"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("phone"))) {
			request.setAttribute("phone", PropertyReader.getValue("error.require", "Phone"));
			pass = false;
		} else if (!DataValidator.isPhoneLength(request.getParameter("phone"))) {
			request.setAttribute("phone", "Phone number must be 10 digits");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("salary"))) {
			request.setAttribute("salary", PropertyReader.getValue("error.require", "Salary"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("gender"))) {
			request.setAttribute("gender", PropertyReader.getValue("error.require", "Gender"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("department"))) {
			request.setAttribute("department", PropertyReader.getValue("error.require", "Department"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("joinDate"))) {
			request.setAttribute("joinDate", PropertyReader.getValue("error.require", "Join Date"));
			pass = false;
		} else if (!DataValidator.isDate(request.getParameter("joinDate"))) {
			request.setAttribute("joinDate", PropertyReader.getValue("error.date", "Join Date"));
			pass = false;
		}

		log.debug("EmployeeCtl validate ended");

		return pass;
	}

	/**
	 * Populate EmployeeBean
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("EmployeeCtl populateBean started");

		EmployeeBean bean = new EmployeeBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setPhone(DataUtility.getString(request.getParameter("phone")));
		bean.setSalary(DataUtility.getString(request.getParameter("salary")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setDepartment(DataUtility.getString(request.getParameter("department")));
		bean.setJoinDate(DataUtility.getDate(request.getParameter("joinDate")));

		populateDTO(bean, request);

		log.debug("EmployeeCtl populateBean ended");

		return bean;
	}

	/**
	 * GET: Load employee for edit
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.debug("EmployeeCtl doGet started");

		long id = DataUtility.getLong(request.getParameter("id"));
		EmployeeModel model = new EmployeeModel();

		if (id > 0) {
			try {
				EmployeeBean bean = model.findByPk(id);
				ServletUtility.setBean(bean, request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				return;
			}
		}

		ServletUtility.forward(getView(), request, response);
		log.debug("EmployeeCtl doGet ended");
	}

	/**
	 * POST: Save, Update, Reset, Cancel
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.debug("EmployeeCtl doPost started");

		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));

		EmployeeModel model = new EmployeeModel();

		if (OP_SAVE.equalsIgnoreCase(op)) {

			EmployeeBean bean = (EmployeeBean) populateBean(request);

			try {
				model.add(bean);
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("Employee added successfully", request);

			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Employee email already exists", request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				return;
			}

		} else if (OP_UPDATE.equalsIgnoreCase(op)) {

			EmployeeBean bean = (EmployeeBean) populateBean(request);

			try {
				if (id > 0) {
					model.update(bean);
				}
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("Employee updated successfully", request);

			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Employee email already exists", request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.EMPLOYEE_LIST_CTL, request, response);
			return;

		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.EMPLOYEE_CTL, request, response);
			return;
		}

		ServletUtility.forward(getView(), request, response);
		log.debug("EmployeeCtl doPost ended");
	}

	/**
	 * View Page
	 */
	@Override
	protected String getView() {
		return ORSView.EMPLOYEE_VIEW;
	}
}
