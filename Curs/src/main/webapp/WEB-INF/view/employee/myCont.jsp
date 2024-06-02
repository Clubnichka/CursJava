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
<c:forEach var="cont" items="${conts}">
   <div style="border: 2px solid black;">
   <p>Имя - <c:out value="${cont.getName()}"/></p>
   <p>Телефон - <c:out value="${cont.getPhone()}"/></p>
   <p>Почта - <c:out value="${cont.getEmail()}"/></p>
    <p>
      <form method="post" action="alterCont">
         <input name="id" type="hidden" value="${cont.getId()}"/>
         <input type="submit" value="Изменить контакт"/>
      </form>
      </p>
      <p>
      <form method="post" action="delCont">
         <input name="id" type="hidden" value="${cont.getId()}"/>
         <input type="submit" value="Удалить контакт"/>
         </form>
      </p>
   </div>
</c:forEach>
<p>
   <div>
   <form method="post" action="addCont">
      <input type="submit" value="Добавить контакт"/>
   </form>
</div>
</p>
<form method="post" action="HC">
<button type="submit">Назад</button>
</form>
</body>
</html>