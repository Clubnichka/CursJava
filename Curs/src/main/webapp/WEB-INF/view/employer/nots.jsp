<%@page contentType="text/html;charsetUTF-8" pageEncoding="UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<c:forEach var="notif" items="${nots}">
    <h1>Резюме</h1>
    <div style="border: 10px solid black;"><p>Желаемая должность - <c:out value="${notif.getCandidate().getName()}"/></p>
        <p>Стаж - <c:out value="${notif.getCandidate().getExpirience()}"/></p>
        <p>Обо мне - <c:out value="${notif.getCandidate().getAboutMe()}"/></p>
        <p>Возраст - <c:out value="${notif.getCandidate().getAge()}"/></p>
        <p>Желаемая зарплата - <c:out value="${notif.getCandidate().getRequiredSalary()}"/></p>
        <h6> Контакты</h6>
        <div style="border: 2px solid black;">
            <c:forEach var="contact" items="${notif.getCandidate().getUser().getContacts()}">
                <p>Имя - <c:out value="${contact.getName()}"/></p>
                <p>Почта - <c:out value="${contact.getEmail()}"/></p>
                <p>Телефон - <c:out value="${contact.getPhone()}"/></p>
                </tr>
            </c:forEach>
        </div>
    </div>
    <form method="post" action="conf">
        <input type="hidden" name="notId" value="${notif.getId()}">
        <input type="submit" class="btn btn-primary" value="Предложить связаться"/>
    </form>
    <form method="post" action="decl">
        <input type="hidden" name="notId" value="${notif.getId()}">
        <input type="submit" class="btn btn-warning" value="Удалить"/>
    </form>

</c:forEach>

<form method="post" action="/Curs/myVacList">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>

