<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head></head>
<body>
<h1>Работодатели</h1>

<table border="1" cellspacing="10">
    <tr><th>Название вакансии</th><th>Назавание компании</th></tr>
    <c:forEach var="st" items="${vacancy}">
            <tr><td><c:out value="${st.getName()}"/></td>
            <td><c:out value="${st.getCompanyName()}"/> </td>

                <td>
                                <form method="post" action="/Curs/MEmployer">
                                <input type="submit" value="Удалить"/>

                                </form>
                            </td><td>
                                                 <form method="post" action="/Curs/MEmployer">
                                                     <p><button type="submit" >Подобрать кандидатов</button></p>

                                                 </form>
                                             </td>
                                             <td>
                                                             <form method="post" action="/Curs/MEmployer">
                                                                 <p><button type="submit">Добавить 24 часа времени</button></p>
                                                             </form>
                                                         </td></tr>
            </c:forEach>


</table>
<form method="post" action="/Curs/MEmployer">
    <p><button type="submit" >добавить работодателя</button></p>
</form>
<form method="post" action="/Curs/Home">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>




