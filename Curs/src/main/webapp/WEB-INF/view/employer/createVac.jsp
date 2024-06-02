<%@page contentType="text/html;charsetUTF-8" pageEncoding="UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Создание/изменение вакансии</h1>

<sf:form method="post" action="/Curs/CreateVac" modelAttribute="vac">
    <p> Name<sf:input path="Name"/></p>
    <p>requiredExpirience<sf:input path="requiredExpirience"/></p>
    <p>Description<sf:input path="Description"/></p>
    <p>requiredAge<sf:input path="requiredAge"/></p>
    <p>salary<sf:input path="salary"/></p>
    <input type="submit" value="Создать" class="btn btn-primary" />
    </div>
</sf:form>
</div>
</div>


<form method="post" action="/Curs/viewCont" modelAttribute="cand">
    <p><button type="submit">Назад</button></p>

</form>
</body>
</html>