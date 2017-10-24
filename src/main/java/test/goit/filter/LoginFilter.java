package test.goit.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpSession session = req.getSession();
        if ("yes".equals(session.getAttribute("can_see"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect("/goit/login");
        }
    }

    @Override
    public void destroy() {

    }
}
