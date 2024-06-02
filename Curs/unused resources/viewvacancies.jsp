
<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head></head>
<body>
<h1>Вакансии</h1>

<table border="1" cellspacing="10">
    <tr><th>Название вакансии</th><th>Необходимый опыт</th><th>Описание</th><th>Необходимый возраст</th><th>Зарплата</th></tr>
    <c:forEach var="st" items="${vacancy}">
            <tr><td><c:out value="${st.getName()}"/></td>
            <td><c:out value="${st.getRequiredExpirience()}"/> </td>
              <td><c:out value="${st.getDescription()}"/> </td>
               <td><c:out value="${st.getRequiredAge()}"/> </td>
                <td><c:out value="${st.getSalary()}"/> </td></tr>
            </c:forEach>


</table>
<form method="post" action="/Curs/Home">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>
