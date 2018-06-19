<%--<%@ page import="com.airline.models.Student" %>--%>
<%--<%@ page import="javax.persistence.EntityManagerFactory" %>--%>
<%--<%@ page import="javax.persistence.Persistence" %>--%>
<%--<%@ page import="javax.persistence.EntityManager" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
  <%--<link rel="stylesheet" href="resources/css/jpaStyles.css" />--%>
  <%--<title>Students List</title>--%>
<%--</head>--%>
<%--<body>--%>
  <%--<%--%>
    <%--EntityManagerFactory emf = Persistence.createEntityManagerFactory("cjpa");--%>
    <%--EntityManager em = emf.createEntityManager();--%>

    <%--Student s = new Student();--%>

    <%--s.setName("Chanh");--%>
    <%--s.setAge(19.0);--%>

    <%--em.persist(s);--%>
  <%--%>--%>
<%--</body>--%>
<%--</html>--%>




<%@ page import="com.airline.models.Student" %>
<%@ page import="java.util.List" %>
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
    List<Student> stuList = (List<Student>) request.getAttribute("students_list");
    for (Student aStuList : stuList) {
  %>
  <tr>
    <td><%=aStuList.getId()%></td>
    <td><%=aStuList.getName()%></td>
    <td><%=aStuList.getAge()%></td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>