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
<h1>Удалить резюме?</h1>
    <form method="post" action="delConfirmedC">
        <input type="submit" value="Подтвердить">
    </form>
<form method="post" action="delCanceledC">
    <input type="submit" value="Отмена">
</form>
</body>
</html>
