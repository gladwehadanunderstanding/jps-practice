<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Employees</title>
</head>
<body>
 <center>
  <h1>EMPLOYEE Management</h1>
   <b>
         <a href="new">Add New employee</a>
         <a href="list">List All employee</a>
         </b>
 </center>
    <div align="center">
        <table border="1" cellpadding="1">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                    <td><c:out value="${employee.surname}" /></td>
                    <td>
                     <a href="delete?id=<c:out value='${employee.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>