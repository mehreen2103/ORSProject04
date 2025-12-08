package in.co.rays.proj4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.util.ServletUtility;

/**
 * WelcomeCtl is the controller responsible for displaying 
 * the Welcome page of the application.
 *
 * It simply forwards the request to the Welcome view without 
 * performing any business logic.
 *
 * @author mehre
 * @version 1.0
 * @since 1.0
 */
@WebServlet(name = "WelcomeCtl", urlPatterns = { "/WelcomeCtl" })
public class WelcomeCtl extends BaseCtl {

    /**
     * Handles HTTP GET requests.  
     * Forwards the request to the Welcome view.
     *
     * @param request  HttpServletRequest object containing client request
     * @param response HttpServletResponse object for sending response
     * @throws ServletException if servlet-related error occurs
     * @throws IOException      if input-output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletUtility.forward(getView(), request, response);
    }

    /**
     * Returns the path of the Welcome view.
     *
     * @return String view page constant
     */
    @Override
    protected String getView() {
        return ORSView.WELCOME_VIEW;
    }
}
