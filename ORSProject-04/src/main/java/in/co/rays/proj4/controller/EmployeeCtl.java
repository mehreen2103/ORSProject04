package in.co.rays.proj4.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.EmployeeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.EmployeeModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.PropertyReader;
import in.co.rays.proj4.util.ServletUtility;

/**
 * Employee Controller.
 * Handles Add, Update, Validate, Populate and Load Employee Data.
 * 
 * @author mehreen
 */
@WebServlet(name = "EmployeeCtl", urlPatterns = { "/ctl/EmployeeCtl" })
public class EmployeeCtl extends BaseCtl {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(EmployeeCtl.class);

	public static final String OP_SAVE = "Save";
	public static final String OP_UPDATE = "Update";
	public static final String OP_CANCEL = "Cancel";
	public static final String OP_RESET = "Reset";

	/**
	 * Validates Employee Form Input.
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {

		log.debug("EmployeeCtl Method validate Started");

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
		}

		if (DataValidator.isNull(request.getParameter("salary"))) {
			request.setAttribute("salary", PropertyReader.getValue("error.require", "Salary"));
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

		log.debug("EmployeeCtl Method validate Ended");
		return pass;
	}

	/**
	 * Populates EmployeeBean from request parameters.
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("EmployeeCtl Method populateBean Started");

		EmployeeBean bean = new EmployeeBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setPhone(DataUtility.getString(request.getParameter("phone")));
		bean.setSalary(DataUtility.getString(request.getParameter("salary")));
		bean.setDepartment(DataUtility.getString(request.getParameter("department")));
		bean.setJoinDate(DataUtility.getDate(request.getParameter("joinDate")));

		populateDTO(bean, request);

		log.debug("EmployeeCtl Method populateBean Ended");

		return bean;
	}

	/**
	 * Handles GET request for loading employee data for edit.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.debug("EmployeeCtl Method doGet Started");

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

		log.debug("EmployeeCtl Method doGet Ended");
	}

	/**
	 * Handles POST request for Save, Update, Cancel and Reset operations.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.debug("EmployeeCtl Method doPost Started");

		String op = DataUtility.getString(request.getParameter("operation"));
		EmployeeModel model = new EmployeeModel();
		long id = DataUtility.getLong(request.getParameter("id"));

		if (OP_SAVE.equalsIgnoreCase(op)) {
			EmployeeBean bean = (EmployeeBean) populateBean(request);
			try {
				long pk = model.add(bean);
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("Employee added successfully", request);
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
		log.debug("EmployeeCtl Method doPost Ended");
	}

	/**
	 * Returns Employee View Page.
	 */
	@Override
	protected String getView() {
		return ORSView.EMPLOYEE_VIEW;
	}
}
