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
    <div >
        <h1>Резюме</h1>
            <div ><p>Желаемая должность - <c:out value="${notif.getCandidate().getName()}"/></p>
                <p>Стаж - <c:out value="${notif.getCandidate().getExpirience()}"/></p>
                <p>Обо мне - <c:out value="${notif.getCandidate().getAboutMe()}"/></p>
                <p>Возраст - <c:out value="${notif.getCandidate().getAge()}"/></p>
                <p>Желаемая зарплата - <c:out value="${notif.getCandidate().getRequiredSalary()}"/></p>

                <div style="border: 2px solid black;">
                    <h6> Вакансия</h6>
                    <table border="1" cellspacing="10">
                        <tr><th>Название вакансии</th><th>Необходимый опыт</th><th>Описание</th><th>Необходимый возраст</th><th>Зарплата</th></tr>
                        <tr><td><c:out value="${notif.getVacancy().getName()}"/></td>
                            <td><c:out value="${notif.getVacancy().getRequiredExpirience()}"/> </td>
                            <td><c:out value="${notif.getVacancy().getDescription()}"/> </td>
                            <td><c:out value="${notif.getVacancy().getRequiredAge()}"/> </td>
                            <td><c:out value="${notif.getVacancy().getSalary()}"/> </td>
                        </tr>



                    </table>
                    <h1> Компания</h1>
                    <div>
                        <p><c:out value="${notif.getVacancy().getCompany().getName()}"/></p>
                        <p><c:out value="${notif.getVacancy().getCompany().getAbout()}"/></p>

                    </div>

                    <h1> Контакты</h1>
                    <div>
                        <c:forEach var="contact" items="${notif.getVacancy().getCompany().getContacts()}">
                            <tr><th><c:out value="${contact.getName()}"/></th>
                                <th><c:out value="${contact.getEmail()}"/></th>
                                <th><c:out value="${contact.getPhone()}"/></th>
                            </tr>
                        </c:forEach>
                    </div>
                </div>
            </div>


        </c:forEach>
    </div>


<form method="post" action="/Curs/HC">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>

