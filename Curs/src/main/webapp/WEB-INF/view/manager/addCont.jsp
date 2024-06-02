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
<h1>Создание/изменение контакта</h1>

<sf:form method="post" action="/Curs/McreateCont" modelAttribute="cont">
    <p> Name<sf:input path="name"/></p>
    <p>Phone<sf:input path="phone"/></p>
    <p>Email<sf:input path="email"/></p>
    <input type="submit" value="Create" class="btn btn-primary" />
    </div>
</sf:form>
</div>
</div>


<form method="post" action="/Curs/Mviewcompanies" modelAttribute="cand">
    <p><button type="submit">Назад</button></p>

</form>
</body>
</html>