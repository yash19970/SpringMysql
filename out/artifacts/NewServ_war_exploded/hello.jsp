<%--
  Created by IntelliJ IDEA.
  User: yashjain
  Date: 1/11/18
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>COntactBook</title>
</head>
<body>
<h1> Contact Book</h1>
<h2>Insert name into the contact book:</h2>
<form method="POST" action="/myapp/Hello">
    Name; <input type="text" name="name"/>
    Number:<input type="text" name="number"/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
