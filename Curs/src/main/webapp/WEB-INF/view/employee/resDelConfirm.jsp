<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 02.05.2024
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charsetUTF-8" pageEncoding="UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle h-30 w-30" style="background-color:white">
    <h1>Удалить резюме?</h1>
    <form method="post" action="delConfirmed">
        <input type="submit" value="Подтвердить">
    </form>
    <form method="post" action="delCanceled">
        <input type="submit" value="Отмена">
    </form></div>

</body>
</html>
