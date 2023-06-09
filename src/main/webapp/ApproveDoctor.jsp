<%@page import="java.util.List"%>
<%@page import="Dto.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Doctor> list=(List<Doctor>)request.getAttribute("list"); %>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Mobile</th>
<th>Age</th>
<th>Status</th>
<th>ChangeStatus</th>
</tr>
<%for(Doctor doctor:list){%>
<tr>
<th><%=doctor.getId()%></th>
<th><%=doctor.getName()%></th>
<th><%=doctor.getMobile()%></th>
<th><%=doctor.getAge()%></th>
<th><%=doctor.isStatus()%></th>

<th><a href="changeDoctorstatus?id=<%=doctor.getId()%>"><button>Change Status</button></a></th>



</tr>
<%} %>
</body>
</html>