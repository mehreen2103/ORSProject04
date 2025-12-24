package in.co.rays.proj4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.model.MarksheetModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.PropertyReader;
import in.co.rays.proj4.util.ServletUtility;

/**
 * GetMarksheetCtl is a controller to fetch a student's marksheet
 * based on the Roll Number provided by the user.
 *
 * <p>This controller validates the input, searches the marksheet
 * using the model, and then forwards the data to the appropriate
 * view for display.</p>
 * 
 * @author mehre
 */
@WebServlet(name = "GetMarksheetCtl", urlPatterns = { "/ctl/GetMarksheetCtl" })
public class GetMarksheetCtl extends BaseCtl {
	
private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(GetMarksheetCtl.class);

    /**
     * Validates the user input for Roll Number.
     *
     * @param request HttpServletRequest object containing form data
     * @return boolean true if validation passes, false otherwise
     */
    @Override
    protected boolean validate(HttpServletRequest request) {
    	
    	log.debug("GetMarksheetCTL Method validate Started");

        boolean pass = true;

        if (DataValidator.isNull(request.getParameter("rollNo"))) {
            request.setAttribute("rollNo", PropertyReader.getValue("error.require", "Roll Number"));
            pass = false;
        }
        
        log.debug("GetMarksheetCTL Method validate Ended");

        return pass;
    }

    /**
     * Populates the MarksheetBean with form input values.
     *
     * @param request HttpServletRequest containing roll number
     * @return BaseBean MarksheetBean with populated data
     */
    @Override
    protected BaseBean populateBean(HttpServletRequest request) {

    	log.debug("GetMarksheetCTL Method populateBean Started");
        MarksheetBean bean = new MarksheetBean();

        bean.setRollNo(DataUtility.getString(request.getParameter("rollNo")));

        log.debug("GetMarksheetCTL Method populateBean Ended");
        return bean;
    }

    /**
     * Displays the initial view for Get Marksheet page.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletUtility.forward(getView(), request, response);
    }

    /**
     * Handles form submission when user requests marksheet data.
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	log.debug("GetMarksheetCTL Method doPost Started");

        String op = DataUtility.getString(request.getParameter("operation"));

        MarksheetModel model = new MarksheetModel();

        MarksheetBean bean = (MarksheetBean) populateBean(request);

        if (OP_GO.equalsIgnoreCase(op)) {
            try {
                bean = model.findByRollNo(bean.getRollNo());
                if (bean != null) {
                    ServletUtility.setBean(bean, request);
                } else {
                    ServletUtility.setErrorMessage("RollNo Does Not exists", request);
                }
            } catch (ApplicationException e) {
                e.printStackTrace();
                return;
            }
        }
        ServletUtility.forward(getView(), request, response);
    	log.debug("GetMarksheetCTL Method doPost Ended");
    }

    /**
     * Returns the view for Get Marksheet page.
     *
     * @return String view constant
     */
    @Override
    protected String getView() {
        return ORSView.GET_MARKSHEET_VIEW;
    }
}
