<%@page contentType="text/html;charsetUTF-8" pageEncoding="UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<table border="1" cellspacing="10">
    <tr><th>Название вакансии</th><th>Необходимый опыт</th><th>Описание</th><th>Необходимый возраст</th><th>Зарплата</th></tr>
    <tr><td><c:out value="${vac.getName()}"/></td>
            <td><c:out value="${vac.getRequiredExpirience()}"/> </td>
            <td><c:out value="${vac.getDescription()}"/> </td>
            <td><c:out value="${vac.getRequiredAge()}"/> </td>
            <td><c:out value="${vac.getSalary()}"/> </td>
            <td><form method="post" action="/Curs/MvacDetails">
                <input name="id" type="hidden" value="${st.getId()}"/>
                <input type="submit" value="Детали"/>
            </form> </td>
            </tr>



</table>
<h1> Компания</h1>
<div>
    <p><c:out value="${vac.getCompany().getName()}"/></p>
    <p><c:out value="${vac.getCompany().getAbout()}"/></p>

</div>

<h1> Контакты</h1>
<div>
    <c:forEach var="contact" items="${vac.getCompany().getContacts()}">
        <tr><th><c:out value="${contact.getName()}"/></th>
            <th><c:out value="${contact.getEmail()}"/></th>
            <th><c:out value="${contact.getPhone()}"/></th>
        </tr>
    </c:forEach>
</div>
<form method="post" action="/Curs/HM">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>

