package avito.filters;

import avito.models.UserSession;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Home on 15.01.2017.
 */
public class AuthoFilterServet implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        UserSession userSession = (UserSession)session.getAttribute("userSession");
        if(userSession != null) {
            servletRequest.setAttribute("authUser",userSession.getUserLogin());
            filterChain.doFilter(servletRequest, servletResponse);

        }else {
            response.sendRedirect("/regist");
        }

    }

    public void destroy() {

    }
}
