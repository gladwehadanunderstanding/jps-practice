<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Employee Management Application</title>
</head>
<body>
 <center>
  <h1>User Management</h1>
        <b>
         <a href="new">Add New User</a>
         <a href="list">List All Users</a>
         </b>
 </center>
    <div align="center">
  <c:if test="${employee != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${employee == null}">
   <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="1">
            <caption>
             <h2>
`
              <c:if test="${employee == null}">
               Add New Employee
              </c:if>
             </h2>
            </caption>
          <c:if test="${employee != null}">
           <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
          </c:if>            
            <tr>
                <th>Employee Name: </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${employee.name}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Surname: </th>
                <td>
                 <input type="text" name="surname" size="45"
                   value="<c:out value='${employee.surname}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>