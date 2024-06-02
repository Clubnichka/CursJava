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


       <c:forEach var="company" items="${comps}">
           <div>
               <p>Имя - <c:out value="${company.getName()}"/></p>
               <p>Описание - <c:out value="${company.getAbout()}"/></p>
               <div>
                   <form method="post" action="McompCont">
                       <input type="hidden" name="id" value="${company.getId()}">
                       <input type="submit" value="Контакты">
                   </form>
               </div>
           </div>
       </c:forEach>

<form method="post" action="MaddComp">
    <input type="submit" class="btn btn-primary" value="Добавить компанию"/>
</form>
<form method="post" action="HM">
<button type="submit">Назад</button>
</form>
</body>
</html>