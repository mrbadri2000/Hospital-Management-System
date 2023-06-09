<%@page import="java.util.List"%>
<%@page import="Dto.Staff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approve Staff</title>
</head>
<body>
<% List<Staff> list=(List<Staff>)request.getAttribute("list"); %>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Mobile</th>
<th>Age</th>
<th>Status</th>
<th>ChangeStatus</th>
</tr>
<%for(Staff staff:list){%>
<tr>
<th><%=staff.getId()%></th>
<th><%=staff.getName()%></th>
<th><%=staff.getMobile()%></th>
<th><%=staff.getAge()%></th>
<th><%=staff.isStatus()%></th>

<th><a href="changestaffstatus?id=<%=staff.getId()%>"><button>Change Status</button></a></th>



</tr>
<%} %>

</body>
</html>