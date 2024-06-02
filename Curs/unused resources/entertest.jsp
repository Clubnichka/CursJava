<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head></head>
<body>
<h1>Войти</h1>

<div class="row">
    <div class="col-md-4">
       <form method="post" action="/Curs/EnterTest">
                       <div>
                       <input name="name"/>
                   </div>
                   <div>
                       <input name="password"/>
                   </div>
                <input type="submit" value="Enter" class="btn btn-primary" />
               </form>
    </div>
</div>
<form method="post" action="/Curs/">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>