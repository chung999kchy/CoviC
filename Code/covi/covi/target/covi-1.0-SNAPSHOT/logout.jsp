<%-- 
    Document   : logout
    Created on : Apr 15, 2021, 11:28:41 AM
    Author     : CHUNG
--%>

<% session.invalidate();
    String redirectURL = "index.jsp";
    response.sendRedirect(redirectURL);%>

