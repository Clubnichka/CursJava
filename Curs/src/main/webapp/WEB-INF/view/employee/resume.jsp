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

<div class="position-absolute top-50 start-50 translate-middle h-30 w-30" style="background-color:white">
    <h1>Создание/изменение резюме</h1>
    <sf:form method="post" action="/Curs/CreateResume" modelAttribute="cand">
    <p>Желаемая должность - <sf:input path="Name"/></p>
    <p>Обо мне - <sf:input path="AboutMe"/></p>
    <p>Стаж - <sf:input path="Expirience"/></p>
    <p>Возраст - <sf:input path="Age"/></p>
    <p>Требуемая зарплата - <sf:input path="RequiredSalary"/></p>
        <input type="submit" value="Создать" class="btn btn-primary" />
    </sf:form>

    <form method="post" action="/Curs/HC" modelAttribute="cand">
        <p><button type="submit" class="btn btn-primary">Назад</button></p>

    </form>
</div>
</body>
</html>


