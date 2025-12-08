package in.co.rays.proj4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.model.MarksheetModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.PropertyReader;
import in.co.rays.proj4.util.ServletUtility;

/**
 * Marksheet Merit List Controller
 * <p>
 * Shows the list of top merit students based on marks.
 * It loads merit list on GET request and handles BACK operation on POST.
 * </p>
 * 
 * @author mehre 
 */
@WebServlet(name = "MarksheetMeritListCtl", urlPatterns = { "/ctl/MarksheetMeritListCtl" })
public class MarksheetMeritListCtl extends BaseCtl {

    /**
     * Handles GET request.
     * Loads the top merit list records using MarksheetModel.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int pageNo = 1;
        int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

        MarksheetModel model = new MarksheetModel();

        try {
            List<MarksheetBean> list = model.getMeritList(pageNo, pageSize);

            if (list == null || list.isEmpty()) {
                ServletUtility.setErrorMessage("No record found", request);
            }

            ServletUtility.setList(list, request);
            ServletUtility.setPageNo(pageNo, request);
            ServletUtility.setPageSize(pageSize, request);

            ServletUtility.forward(getView(), request, response);

        } catch (ApplicationException e) {
            e.printStackTrace();
            ServletUtility.handleException(e, request, response);
            return;
        }
    }

    /**
     * Handles POST request (mainly BACK operation).
     * Redirects to Welcome Controller.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = DataUtility.getString(request.getParameter("operation"));

        if (OP_BACK.equalsIgnoreCase(op)) {
            ServletUtility.redirect(ORSView.WELCOME_CTL, request, response);
            return;
        }
    }

    /**
     * Returns the view page for merit list.
     *
     * @return String view constant
     */
    @Override
    protected String getView() {
        return ORSView.MARKSHEET_MERIT_LIST_VIEW;
    }
}
