package in.co.rays.proj4.controller;

import in.co.rays.proj4.controller.ORSView;
import in.co.rays.proj4.util.ServletUtility;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * FrontController filter class used to check user session before accessing
 * any secured controller or JSP pages under /ctl or /doc.
 *
 * <p>This filter ensures that only logged-in users can access the protected
 * resources. If session is expired or user is not logged in, they are
 * forwarded to the login page.</p>
 * 
 * @author mehre
 */
@WebFilter(filterName = "FrontController", urlPatterns = { "/doc/*", "/ctl/*" })
public class FrontController implements Filter {

    /**
     * Initializes the filter.
     *
     * @param conf FilterConfig object
     */
    public void init(FilterConfig conf) throws ServletException {
    }

    /**
     * Performs filtering to check session validity before processing request.
     *
     * @param req  incoming ServletRequest
     * @param resp outgoing ServletResponse
     * @param chain FilterChain used to forward request to next resource
     *
     * @throws IOException      if an input/output error occurs
     * @throws ServletException if processing fails
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        
        String uri = request.getRequestURI();
		request.setAttribute("uri", uri);

        if (session.getAttribute("user") == null) {
            request.setAttribute("error", "Your session has been expired. Please Login again!");
            ServletUtility.forward(ORSView.LOGIN_VIEW, request, response);
            return;
        } else {
            System.out.println("user login hai");
            chain.doFilter(req, resp);
        }
    }

    /**
     * Destroys the filter instance.
     */
    public void destroy() {
    }
}
