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
<div>
<sf:form method="post" action="/Curs/CreateComp" modelAttribute="comp">
    <p> Название компании - <sf:input path="name"/></p>
    <p>Описание - <sf:input path="about"/></p>
    <p>Пароль - <sf:input path="password"/></p>
    <input type="submit" value="Create" class="btn btn-primary" />
</sf:form>
</div>

<form method="post" action="/Curs/viewCont" modelAttribute="cand">
    <p><button type="submit">Назад</button></p>

</form>
</body>
</html>