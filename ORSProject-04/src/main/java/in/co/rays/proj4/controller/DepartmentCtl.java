package in.co.rays.proj4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.DepartmentBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.model.DepartmentModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.PropertyReader;
import in.co.rays.proj4.util.ServletUtility;

/**
 * DepartmentCtl Controller.
 * 
 * Handles Add, Update, Reset, Cancel operations for Department entity.
 * 
 * @author mehre
 * @version 1.0
 */
@WebServlet(name = "DepartmentCtl", urlPatterns = { "/ctl/DepartmentCtl" })
public class DepartmentCtl extends BaseCtl {

	/**
	 * Validate Department form fields
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name",
					PropertyReader.getValue("error.require", "Department Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", "Invalid Department Name");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description",
					PropertyReader.getValue("error.require", "Description"));
			pass = false;
		}

		return pass;
	}

	/**
	 * Populate DepartmentBean
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		DepartmentBean bean = new DepartmentBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));

		populateDTO(bean, request);

		return bean;
	}

	/**
	 * GET request – load data for update
	 */
	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = DataUtility.getLong(request.getParameter("id"));

		DepartmentModel model = new DepartmentModel();

		if (id > 0) {
			try {
				DepartmentBean bean = model.findByPk(id);
				ServletUtility.setBean(bean, request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * POST request – Save, Update, Reset, Cancel
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));

		DepartmentModel model = new DepartmentModel();

		long id = DataUtility.getLong(request.getParameter("id"));

		if (OP_SAVE.equalsIgnoreCase(op)) {

			DepartmentBean bean = (DepartmentBean) populateBean(request);

			try {
				model.add(bean);
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("Department is successfully saved", request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				return;
			}

		} else if (OP_UPDATE.equalsIgnoreCase(op)) {

			DepartmentBean bean = (DepartmentBean) populateBean(request);

			try {
				if (id > 0) {
					model.update(bean);
				}
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("Department is successfully updated", request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.DEPARTMENT_LIST_CTL, request, response);
			return;

		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.DEPARTMENT_CTL, request, response);
			return;
		}

		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * Return Department view
	 */
	@Override
	protected String getView() {
		return ORSView.DEPARTMENT_VIEW;
	}
}
