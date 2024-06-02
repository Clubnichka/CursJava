<%@page contentType="text/html;charsetUTF-8" pageEncoding="UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="position-absolute top-50 start-50 translate-middle h-30 w-30" style="background-color:white">
<div>
    <form method="post" action="selRes">
        <input type="submit" value="Фильтр"/>
    </form>
</div>
<table border="1" cellspacing="10">
    <tr><th>Название вакансии</th><th>Необходимый опыт</th><th>Описание</th><th>Необходимый возраст</th><th>Зарплата</th></tr>
    <c:forEach var="st" items="${vacancies}">
        <tr><td><c:out value="${st.getName()}"/></td>
            <td><c:out value="${st.getRequiredExpirience()}"/> </td>
            <td><c:out value="${st.getDescription()}"/> </td>
            <td><c:out value="${st.getRequiredAge()}"/> </td>
            <td><c:out value="${st.getSalary()}"/> </td>
            <td><form method="post" action="/Curs/vacDetails">
                <input name="id" type="hidden" value="${st.getId()}"/>
                <input type="submit" value="Детали"/>
            </form> </td>
            </tr>
    </c:forEach>
    <!--tr><td>Imposible call</td>
    <td>0_0</td><td>0_0</td><td>0_0</td><td>0_0</td><td>0_0</td>
    <td><form method="post" action="/Curs/vacDetails">
        <input name="id" type="hidden" value="9999"/>
        <input type="submit" value="Детали"/>
    </form> </td></tr-->

</table>
<form method="post" action="/Curs/HC">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>

