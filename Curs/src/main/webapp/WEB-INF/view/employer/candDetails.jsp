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
<h1>Резюме</h1>
<c:forEach var="cand" items="${cands}">
    <div style="border: 2px solid black;">
        <p>Профессия - <c:out value="${cand.getName()}"/></p>
        <p>Стаж - <c:out value="${cand.getExpirience()}"/></p>
        <p>Обо мне - <c:out value="${cand.getAboutMe()}"/></p>
        <p>Возраст - <c:out value="${cand.getAge()}"/></p>
        <p>Желаемая зароботная плата - <c:out value="${cand.getRequiredSalary()}"/></p>
    </div>
</c:forEach>
<h1>Контакты</h1>
<c:forEach var="cont" items="${conts}">
   <div style="border: 2px solid black;">
   <p>Имя - <c:out value="${cont.getName()}"/></p>
   <p>Телефон - <c:out value="${cont.getPhone()}"/></p>
   <p>Почта - <c:out value="${cont.getEmail()}"/></p>
   </div>
</c:forEach>
<p>
   <div>

</div>
</p>
<form method="post" action="viewcandidates">
<button type="submit">Назад</button>
</form>
</body>
</html>