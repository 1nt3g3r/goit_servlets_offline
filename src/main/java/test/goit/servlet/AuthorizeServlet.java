package test.goit.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthorizeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        if (session.getAttribute("bad_login_count") != null &&
                Integer.parseInt(session.getAttribute("bad_login_count").toString()) > 3) {
            //blah-blah
            return;
        }

        if ("admin".equals(name) && "password".equals(password)) {
//            Cookie canSeeCookie = new Cookie("can_see", "yes");
//            resp.addCookie(canSeeCookie);

            session.setAttribute("can_see", "yes");

            resp.sendRedirect("/goit/quotes");
        } else {

            if (session.getAttribute("bad_login_count") == null) {
                session.setAttribute("bad_login_count", 1);
            } else {
                int badLoginCount = Integer.parseInt(session.getAttribute("bad_login_count").toString());
                badLoginCount++;
                session.setAttribute("bad_login_count", badLoginCount);
            }



            resp.sendRedirect("/goit/login");
        }
    }
}
