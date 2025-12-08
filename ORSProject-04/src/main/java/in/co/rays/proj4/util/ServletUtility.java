package in.co.rays.proj4.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.controller.BaseCtl;
import in.co.rays.proj4.controller.ORSView;

/**
 * Utility class for common servlet operations such as forwarding, redirecting,
 * setting and getting messages, beans, lists, and pagination attributes.
 * 
 * <p>
 * This class is used across controllers to simplify repetitive servlet tasks.
 * </p>
 * @author mehre
 *
 */
public class ServletUtility {

    /**
     * Forwards request and response to the specified page.
     * 
     * @param page     Target JSP or servlet page
     * @param request  HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws IOException
     * @throws ServletException
     */
    public static void forward(String page, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    /**
     * Redirects to the specified page.
     * 
     * @param page     Target page URL
     * @param request  HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws IOException
     * @throws ServletException
     */
    public static void redirect(String page, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.sendRedirect(page);
    }

    /**
     * Returns an error message from the request attribute.
     * 
     * @param property Attribute name
     * @param request  HttpServletRequest object
     * @return Error message if found, else empty string
     */
    public static String getErrorMessage(String property, HttpServletRequest request) {
        String val = (String) request.getAttribute(property);
        return val == null ? "" : val;
    }

    /**
     * Returns a message from the request attribute.
     * 
     * @param property Attribute name
     * @param request  HttpServletRequest object
     * @return Message if found, else empty string
     */
    public static String getMessage(String property, HttpServletRequest request) {
        String val = (String) request.getAttribute(property);
        return val == null ? "" : val;
    }

    /**
     * Sets an error message in the request.
     * 
     * @param msg     Error message
     * @param request HttpServletRequest object
     */
    public static void setErrorMessage(String msg, HttpServletRequest request) {
        request.setAttribute(BaseCtl.MSG_ERROR, msg);
    }

    /**
     * Retrieves the error message from the request.
     * 
     * @param request HttpServletRequest object
     * @return Error message if found, else empty string
     */
    public static String getErrorMessage(HttpServletRequest request) {
        String val = (String) request.getAttribute(BaseCtl.MSG_ERROR);
        return val == null ? "" : val;
    }

    /**
     * Sets a success message in the request.
     * 
     * @param msg     Success message
     * @param request HttpServletRequest object
     */
    public static void setSuccessMessage(String msg, HttpServletRequest request) {
        request.setAttribute(BaseCtl.MSG_SUCCESS, msg);
    }

    /**
     * Retrieves the success message from the request.
     * 
     * @param request HttpServletRequest object
     * @return Success message if found, else empty string
     */
    public static String getSuccessMessage(HttpServletRequest request) {
        String val = (String) request.getAttribute(BaseCtl.MSG_SUCCESS);
        return val == null ? "" : val;
    }

    /**
     * Sets a bean in the request.
     * 
     * @param bean    BaseBean object
     * @param request HttpServletRequest object
     */
    public static void setBean(BaseBean bean, HttpServletRequest request) {
        request.setAttribute("bean", bean);
    }

    /**
     * Retrieves a bean from the request.
     * 
     * @param request HttpServletRequest object
     * @return BaseBean object
     */
    public static BaseBean getBean(HttpServletRequest request) {
        return (BaseBean) request.getAttribute("bean");
    }

    /**
     * Retrieves a request parameter value. Returns empty string if null.
     * 
     * @param property Parameter name
     * @param request  HttpServletRequest object
     * @return Parameter value or empty string
     */
    public static String getParameter(String property, HttpServletRequest request) {
        String val = (String) request.getParameter(property);
        return val == null ? "" : val;
    }

    /**
     * Sets a list in the request.
     * 
     * @param list    List object
     * @param request HttpServletRequest object
     */
    public static void setList(List list, HttpServletRequest request) {
        request.setAttribute("list", list);
    }

    /**
     * Retrieves a list from the request.
     * 
     * @param request HttpServletRequest object
     * @return List object
     */
    public static List getList(HttpServletRequest request) {
        return (List) request.getAttribute("list");
    }

    /**
     * Sets the page number in the request.
     * 
     * @param pageNo  Current page number
     * @param request HttpServletRequest object
     */
    public static void setPageNo(int pageNo, HttpServletRequest request) {
        request.setAttribute("pageNo", pageNo);
    }

    /**
     * Retrieves the page number from the request.
     * 
     * @param request HttpServletRequest object
     * @return Current page number
     */
    public static int getPageNo(HttpServletRequest request) {
        return (Integer) request.getAttribute("pageNo");
    }

    /**
     * Sets the page size in the request.
     * 
     * @param pageSize Number of records per page
     * @param request  HttpServletRequest object
     */
    public static void setPageSize(int pageSize, HttpServletRequest request) {
        request.setAttribute("pageSize", pageSize);
    }

    /**
     * Retrieves the page size from the request.
     * 
     * @param request HttpServletRequest object
     * @return Number of records per page
     */
    public static int getPageSize(HttpServletRequest request) {
        return (Integer) request.getAttribute("pageSize");
    }

    /**
     * Handles exceptions by setting them in the request and redirecting to
     * error page.
     * 
     * @param e        Exception object
     * @param request  HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws IOException
     * @throws ServletException
     */
    public static void handleException(Exception e, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("exception", e);
        response.sendRedirect(ORSView.ERROR_CTL);
    }
}
