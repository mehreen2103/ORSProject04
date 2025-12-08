package in.co.rays.proj4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.ServletUtility;

/**
 * BaseCtl is an abstract controller that provides common functionality
 * for all controllers in the application such as operation constants,
 * validation handling, preload, DTO population and service method control.
 * 
 * All specific controllers extend this class.
 */
/**
 * @author mehre
 *
 */
public abstract class BaseCtl extends HttpServlet {

    /** Operation constant for Save */
    public static final String OP_SAVE = "Save";
    /** Operation constant for Update */
    public static final String OP_UPDATE = "Update";
    /** Operation constant for Cancel */
    public static final String OP_CANCEL = "Cancel";
    /** Operation constant for Delete */
    public static final String OP_DELETE = "Delete";
    /** Operation constant for List */
    public static final String OP_LIST = "List";
    /** Operation constant for Search */
    public static final String OP_SEARCH = "Search";
    /** Operation constant for View */
    public static final String OP_VIEW = "View";
    /** Operation constant for Next */
    public static final String OP_NEXT = "Next";
    /** Operation constant for Previous */
    public static final String OP_PREVIOUS = "Previous";
    /** Operation constant for New */
    public static final String OP_NEW = "New";
    /** Operation constant for Go */
    public static final String OP_GO = "Go";
    /** Operation constant for Back */
    public static final String OP_BACK = "Back";
    /** Operation constant for Reset */
    public static final String OP_RESET = "Reset";
    /** Operation constant for Logout */
    public static final String OP_LOG_OUT = "Logout";

    /** Message key for success */
    public static final String MSG_SUCCESS = "success";

    /** Message key for error */
    public static final String MSG_ERROR = "error";

    /**
     * Validates input fields. 
     * Default implementation returns true; subclasses override it.
     * 
     * @param request HttpServletRequest object
     * @return true if valid, false otherwise
     */
    protected boolean validate(HttpServletRequest request) {
        return true;
    }

    /**
     * Preloads required data before rendering the view.
     * Subclasses override this to load dropdown lists or other data.
     * 
     * @param request HttpServletRequest object
     */
    protected void preload(HttpServletRequest request) {
    }

    /**
     * Populates a bean with request data.
     * Must be overridden by subclasses.
     * 
     * @param request HttpServletRequest object
     * @return populated bean
     */
    protected BaseBean populateBean(HttpServletRequest request) {
        return null;
    }

    /**
     * Populates BaseDTO (BaseBean) common fields such as createdBy,
     * modifiedBy, createdDatetime and modifiedDatetime.
     * 
     * @param dto     BaseBean object
     * @param request HttpServletRequest object
     * @return updated dto
     */
    protected BaseBean populateDTO(BaseBean dto, HttpServletRequest request) {

        String createdBy = request.getParameter("createdBy");
        String modifiedBy = null;

        UserBean userbean = (UserBean) request.getSession().getAttribute("user");

        if (userbean == null) {
            createdBy = "root";
            modifiedBy = "root";
        } else {
            modifiedBy = userbean.getLogin();
            if ("null".equalsIgnoreCase(createdBy) || DataValidator.isNull(createdBy)) {
                createdBy = modifiedBy;
            }
        }

        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);

        long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

        if (cdt > 0) {
            dto.setCreatedDatetime(DataUtility.getTimestamp(cdt));
        } else {
            dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
        }

        dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());

        return dto;
    }

    /**
     * Overrides service() to apply preload, validation and forward logic.
     *
     * @param request  HttpServletRequest object
     * @param response HttpServletResponse object
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        preload(request);

        String op = DataUtility.getString(request.getParameter("operation"));

        if (DataValidator.isNotNull(op) && !OP_CANCEL.equalsIgnoreCase(op) && !OP_VIEW.equalsIgnoreCase(op)
                && !OP_DELETE.equalsIgnoreCase(op) && !OP_RESET.equalsIgnoreCase(op)) {

            if (!validate(request)) {
                BaseBean bean = (BaseBean) populateBean(request);
                ServletUtility.setBean(bean, request);
                ServletUtility.forward(getView(), request, response);
                return;
            }
        }
        super.service(request, response);
    }

    /**
     * Returns the view page for the controller.
     * Must be implemented by subclasses.
     * 
     * @return view page path
     */
    protected abstract String getView();
}
