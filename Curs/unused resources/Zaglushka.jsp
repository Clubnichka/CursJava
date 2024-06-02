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
</head>
<body>

<div>
    <form method="post" action="/Curs/HA"><p><button type="submit">Войти как Админ</button></p></form>

    <form method="post" action="/Curs/HC">

    <p><button type="submit">Войти как клиент</button></p></form>

    <form method="post" action="/Curs/HC1">

        <p><button type="submit">Войти как клиент (работодатель)</button></p></form>
</div>
<div>


    <form method="post" action="/Curs/HM">

    <p><button type="submit">Войти как менеджер</button></p></form>
</div>
</body>
</html>
