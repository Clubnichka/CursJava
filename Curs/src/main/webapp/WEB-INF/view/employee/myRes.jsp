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
<c:forEach var="cand" items="${cands}">
   <div style="border: 2px solid black;">
   <p>Профессия - <c:out value="${cand.getName()}"/></p>
   <p>Стаж - <c:out value="${cand.getExpirience()}"/></p>
   <p>Обо мне - <c:out value="${cand.getAboutMe()}"/></p>
   <p>Возраст - <c:out value="${cand.getAge()}"/></p>
   <p>Желаемая зароботная плата - <c:out value="${cand.getRequiredSalary()}"/></p>
      <p>
      <form method="post" action="alterRes">
         <input name="id" type="hidden" value="${cand.getId()}"/>
         <input type="submit" class="btn btn-primary" value="Изменить резюме"/>
      </form>
      </p>
      <p>
      <form method="post" action="delRes">
         <input name="id" type="hidden" value="${cand.getId()}"/>
         <input type="submit" class="btn btn-primary" value="Удалить резюме"/>
         </form>
      </p>
   </div>
</c:forEach>

<form method="post" action="HC">
<button type="submit" class="btn btn-primary">Назад</button>
</form>
</body>
</html>