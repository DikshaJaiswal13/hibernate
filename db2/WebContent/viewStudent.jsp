<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
student id:<c:out value="${stud.id}"/><br>
student name:<c:out value="${stud.name}"/><br>
gender:<c:out value="${stud.gender}"/><br>
course:<c:out value="${stud.course}"/><br>
address:<c:out value="${stud.address}"/><br>
<a href="/db2/StudentController">go back</a>
</body>
</html>