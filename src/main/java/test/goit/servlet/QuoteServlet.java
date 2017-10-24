package test.goit.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;

public class QuoteServlet extends HttpServlet {
    private String[] ruQuotes = {
            "Если человек действительно чего-то захочет, то вся Вселенная будет способствовать тому, чтобы его желание сбылось.",
            "Истинная любовь взаимности не требует, а тот, кто желает получить за свою любовь награду, попусту теряет время.",
            "Я в точности такая же, как и все; принимаю желаемое за действительное и вижу мир не таким, каков он на самом деле, а таким, каким мне хочется его видеть."
    };

    private String[] enQuotes = {
            "doGet(HttpServletRequest req, HttpServletResponse resp)",
            "Random r = new Random();",
            "resp.getWriter().println(getRandomQuote(ruQuotes));"
    };


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
//
//
//        Enumeration<String> headerNames = req.getHeaderNames();
//        while(headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            String headerValue = req.getHeader(headerName);
//
//            resp.getWriter().append(headerName).append("=").append(headerValue);
//            resp.getWriter().append("<br>");
//
//        }
//
//        boolean allowed = false;
//
//        HttpSession session = req.getSession();
//        if ("yes".equals(session.getAttribute("can_see"))) {
//            allowed = true;
//        }
//
//        if (!allowed) {
//           resp.sendRedirect("/goit/login");
//           return;
//       }

//        boolean allowed = false;
//        Cookie[] cookies = req.getCookies();
//        if(cookies == null) {
//           resp.sendRedirect("/goit/login");
//           return;
//       }
//
//
//       for(Cookie cookie : cookies) {
//           String name = cookie.getName();
//           String value = cookie.getValue();
//
//           if (name.equals("can_see") && value.equals("yes")) {
//               allowed = true;
//               break;
//           }
//       }
//
//       if (!allowed) {
//           resp.sendRedirect("/goit/login");
//           return;
//       }


        String[] quotes = ruQuotes;

        if(req.getParameterMap().containsKey("lang")) {
            String langValue = req.getParameter("lang");
            if (langValue.equals("en")) {
                quotes = enQuotes;
            }
        }

        resp.getWriter().println(getRandomQuote(quotes));
    }

    private String getRandomQuote(String[] quotes) {
        Random r = new Random();
        return quotes[r.nextInt(quotes.length)];
    }
}
