<%@page contentType="text/html;charsetUTF-8" language="java"%>
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
    <c:forEach var="st" items="${vacancy}">
            <tr><td><c:out value="${st.getName()}"/></td>
            <td><c:out value="${st.getRequiredExpirience()}"/> </td>
              <td><c:out value="${st.getDescription()}"/> </td>
               <td><c:out value="${st.getRequiredAge()}"/> </td>
                <td><c:out value="${st.getSalary()}"/> </td>
                <td>
                                <form method="post" action="MfilterC">
                                    <input name="vacancyID" type="hidden" value="${st.getId()}">
                                <input type="submit" value="Выбрать"/>

                                </form>
                            </td>
                </tr>
            </c:forEach>


</table>
<form method="post" action="/Curs/HM">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>

