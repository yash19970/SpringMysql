<%--
  Created by IntelliJ IDEA.
  User: yashjain
  Date: 1/11/18
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.entities.Contact" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<% Contact c = new Contact();
//creating arraylist object of type category class
  ArrayList<Contact> list;
//storing passed value from jsp
  list = (ArrayList<Contact>) request.getAttribute("contactList");
  for(int i = 0; i < list.size(); i++) {

    c = list.get(i);


    out.println(c.getName());

    out.println(c.getNumber() );
  }
%>
</body>
</html>
