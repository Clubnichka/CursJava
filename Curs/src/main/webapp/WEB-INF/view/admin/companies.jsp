<%@page contentType="text/html;charsetUTF-8" pageEncoding="UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:forEach var="company" items="${comps}"><div class="form-group">
    <p>Название - <c:out value="${company.getName()}"/></p>
    <p>Описание - <c:out value="${company.getAbout()}"/></p>
</div>
    <form method="post" action="/Curs/delComp">
        <input name="id" type="hidden" value="${company.getId()}">
        <input type="submit" value="Удалить">
    </form>
</c:forEach>

<form method="post" action="HA">
<button type="submit">Назад</button>
</form>
</body>
</html>