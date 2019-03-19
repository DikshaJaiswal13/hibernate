<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  .round{
  border-radius:25px;
  }
  .view{
  color:grey;
  background-color:#eee;
  width:120px;
  }
  </style>
</head>
<body>
<form action="/db2/AddStudent.jsp">
<input type="submit" value="Add student">
</form>
<table border="1" cellpadding="1">
<%-- <caption>list of students</caption> --%>
<tr><th>Student id</th>
<th>Student name</th>
<th>gender</th>
<th>course</th>
<th>address</th>
</tr>
<c:forEach var="stu" items="${listStudent}">
<tr>
<td><c:out value="${stu.id}"/></td>
<td><c:out value="${stu.name}"/></td>
<td><c:out value="${stu.gender}"/></td>
<td><c:out value="${stu.course}"/></td>
<td><c:out value="${stu.address}"/></td>
<td><a href="/db2/viewStudentController?name=${stu.id}" class="btn btn-light round view">view</a>
<button type="button" class="btn btn-light round view">block</button>
<a href="/db2/removeStudentController?name=${stu.id}" class="btn btn-light round view">remove</a>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>