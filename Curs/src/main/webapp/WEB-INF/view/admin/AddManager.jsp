<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="row">
    <div class="col-md-4">
        <form method="post" action="/Curs/CreateManager">
                <div class="form-group">
                <input name="name"/>
            </div>
            <div class="form-group">
                <input name="password"/>
            </div>
             <input type="hidden" value="3" name="role"/>
                <input type="submit" value="Добавить" class="btn btn-primary" />
            </div>
        </form>
    </div>
</div>
<form method="post" action="/Curs/">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>
