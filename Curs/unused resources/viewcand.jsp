<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head></head>
<body>
<h1>Список кандидатов</h1>
<table border="1" cellspacing="10">
    <tr><th>Имя</th><th>Опыт</th><th>Описание</th><th>Возраст</th><th> Требуемая Зарплата</th></tr>
    <c:forEach var="st" items="${cand}">
            <tr><td><c:out value="${st.getName()}"/></td>
            <td><c:out value="${st.getExpirience()}"/> </td>
              <td><c:out value="${st.getAboutMe()}"/> </td>
               <td><c:out value="${st.getAge()}"/> </td>
                <td><c:out value="${st.getRequiredSalary()}"/> </td></tr>
            </c:forEach>



<form method="post" action="/Curs/Home">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>
