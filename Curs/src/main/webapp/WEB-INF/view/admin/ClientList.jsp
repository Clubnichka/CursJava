<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Клиенты</h1>
<table>
    <tr><th>Имя</th><th>Роль</th><th>Оставшееся время</th><th>Пароль</th><th>Контакты</th><th>Резюме</th></tr>
    <c:forEach var="user" items="${List}">
        <tr><th><c:out value="${user.getName()}"/></th><th><c:out value="${user.getRole()}"/></th>
            <th><c:out value="${user.getTimer()}"/></th><th><c:out value="${user.getPassword()}"/></th>
            <th><form method="post" action="/Curs/Contacts">
                <input name="userId" type="hidden" value="${user.getId()}"/>
                <input type="submit" value="Посмотреть контакты"/>
            </form> </th>
            <th><form method="post" action="/Curs/delClient">
                <input name="userId" type="hidden" value="${user.getId()}"/>
                <input type="submit" value="Удалить"/>
            </form> </th>
            </tr>
    </c:forEach>
</table>


<form method="post" action="/Curs/HA">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>