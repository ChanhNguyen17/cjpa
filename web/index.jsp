<%@ page import="com.airline.models.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.airline.controllers.StudentController" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="resources/css/jpaStyles.css" />
  <title>Students List</title>
</head>
<body>
  <h1>List of Students</h1>
  <table>
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Age</th>
    </tr>
    <%
      StudentController stuC = new StudentController();
      List<Student> stuList = stuC.getStudents();
      if(stuList == null){ stuList = new ArrayList<>(); }
      for (Student aStuList : stuList) {
    %>
      <tr>
        <td><%=aStuList.getId() %></td >
        <td><%=aStuList.getName() %></td>
        <td><%=aStuList.getAge() %></td>
      </tr>
    <% } %>
  </table>
  <form action="students" method="POST">
    Name:<br>
    <label>
      <input type="text" name="name" value="Mickey">
    </label><br>
    Age:<br>
    <label>
      <input type="text" name="age" value="99.0">
    </label><br><br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>