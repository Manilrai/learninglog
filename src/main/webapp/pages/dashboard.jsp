<jsp:include page="/components/header.jsp"/>
<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/2/2026
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
%>
Id:
<% if (user != null) {%>
<%=
    user.getName()
%>

Name: <%=
    user.getId()
    %>
<%} else {%>
User is not here<%}%>
</body>
</html>
<jsp:include page="/components/footer.jsp"/>