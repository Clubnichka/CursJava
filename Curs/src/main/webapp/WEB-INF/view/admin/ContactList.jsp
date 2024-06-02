<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Соискатели</h1>
<table>
    <tr><th>Имя</th><th>Роль</th><th>почта</th><th>телефон</th></tr>
    <c:forEach var="contact" items="${List}">
        <tr><th><c:out value="${contact.getName()}"/></th>
            <th><c:out value="${contact.getEmail()}"/></th>
            <th><c:out value="${contact.getPhone()}"/></th>
            </tr>
    </c:forEach>
</table>


<form method="post" action="/Curs/Clients">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>