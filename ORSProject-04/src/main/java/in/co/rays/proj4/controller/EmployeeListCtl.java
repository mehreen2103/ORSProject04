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
import in.co.rays.proj4.bean.DepartmentBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.model.DepartmentModel;
import in.co.rays.proj4.model.EmployeeModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.ServletUtility;

/**
 * EmployeeListCtl handles listing, searching, pagination and bulk actions for
 * Employee entities. It preloads department list for the view, populates a
 * {@link EmployeeBean} from request parameters, delegates search/delete
 * operations to {@link EmployeeModel}, and prepares pagination metadata for the
 * employee list view.
 */
@WebServlet(name = "EmployeeListCtl", urlPatterns = { "/ctl/EmployeeListCtl" })
public class EmployeeListCtl extends BaseCtl {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(EmployeeListCtl.class);

	@Override
	protected void preload(HttpServletRequest request) {
		DepartmentModel deptModel = new DepartmentModel();
		try {
			List<DepartmentBean> deptList = deptModel.list();
			request.setAttribute("departmentList", deptList);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("EmployeeListCtl populateBean Started");

		EmployeeBean bean = new EmployeeBean();
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
//        bean.setDepartment(DataUtility.getLong(request.getParameter("departmentId")));

		log.debug("EmployeeListCtl populateBean Ended");
		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("EmployeeListCtl doGet Started");

		int pageNo = 1;
		int pageSize = 10;

		EmployeeBean bean = (EmployeeBean) populateBean(request);
		EmployeeModel model = new EmployeeModel();

		try {
			List<EmployeeBean> list = model.search(bean, pageNo, pageSize);
			List<EmployeeBean> next = model.search(bean, pageNo + 1, pageSize);

			if (list == null || list.isEmpty()) {
				ServletUtility.setErrorMessage("No record found", request);
			}

			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.setBean(bean, request);
			request.setAttribute("nextListSize", next.size());

			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			e.printStackTrace();
			ServletUtility.handleException(e, request, response);
			return;
		}
		log.debug("EmployeeListCtl doGet Ended");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("EmployeeListCtl doPost Started");

		List<EmployeeBean> list = null;
		List<EmployeeBean> next = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? 10 : pageSize;

		EmployeeBean bean = (EmployeeBean) populateBean(request);
		EmployeeModel model = new EmployeeModel();

		String op = DataUtility.getString(request.getParameter("operation"));
		String[] ids = request.getParameterValues("ids");

		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || OP_NEXT.equalsIgnoreCase(op) || OP_PREVIOUS.equalsIgnoreCase(op)) {
				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				}

			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.EMPLOYEE_CTL, request, response);
				return;

			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					EmployeeBean deleteBean = new EmployeeBean();
					for (String id : ids) {
						deleteBean.setId(DataUtility.getLong(id));
						model.delete(deleteBean);
					}
					ServletUtility.setSuccessMessage("Employee(s) deleted successfully", request);
				} else {
					ServletUtility.setErrorMessage("Select at least one record", request);
				}

			} else if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.EMPLOYEE_LIST_CTL, request, response);
				return;

			} else if (OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.EMPLOYEE_LIST_CTL, request, response);
				return;
			}

			list = model.search(bean, pageNo, pageSize);
			next = model.search(bean, pageNo + 1, pageSize);

			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found", request);
			}

			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.setBean(bean, request);
			request.setAttribute("nextListSize", next.size());
			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			e.printStackTrace();
			ServletUtility.handleException(e, request, response);
			return;
		}
		log.debug("EmployeeListCtl doPost Ended");
	}

	@Override
	protected String getView() {
		return ORSView.EMPLOYEE_LIST_VIEW;
	}
}
