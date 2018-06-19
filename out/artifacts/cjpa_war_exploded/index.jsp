<%@ page import="javax.persistence.EntityManagerFactory" %>
<%@ page import="javax.persistence.Persistence" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="com.test.Employee" %>
  Created by IntelliJ IDEA.
  User: chanhn
  Date: 18/06/2018
  Time: 21.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("cjpa");
    EntityManager em = factory.createEntityManager();
    em.getTransaction().begin();
    Employee emp = new Employee();
    emp.setName("Chanh");
    emp.setEmail("m@gmail.com");
    em.persist(emp);
    em.getTransaction().commit();
    em.close();
  %>
  </body>
</html>
