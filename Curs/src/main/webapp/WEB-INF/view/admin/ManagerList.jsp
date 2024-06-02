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
<h1>Список менеджеров</h1>

<c:forEach var="user" items="${List}">
        <p><c:out value="${user.getName()}"/></p>
        <form method="post" action="/Curs/DelManager">
        <input type="hidden" value="${user.getId()}" name="ID"/>
        <input type="submit" value="Удалить менеджера"/>
        </form>
         </c:forEach>

<div class="form-group">
    <form method="post" action="/Curs/AddManager">
    <button type="submit">Добавить менеджера</button>
    </form>
</div>
<form method="post" action="/Curs/HA">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>