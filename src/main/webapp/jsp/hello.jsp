<%@ page contentType="text/html; charset=UTF-8" %>

<h2>JSP</h2>

<%
    request.getRequestDispatcher("/date").forward(request, response);
%>
