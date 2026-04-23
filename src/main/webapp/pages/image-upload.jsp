<%--
  Created by IntelliJ IDEA.
  User: Manil
  Date: 23/04/2026
  Time: 10:49 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <form method="post" action="image" enctype="multipart/form-data">
    Name:
    <input type="text" name="name" required>
    <br>
    <input type="file" name="image" required>
    <br>
    <button>Add</button>

  </form>
</body>
</html>