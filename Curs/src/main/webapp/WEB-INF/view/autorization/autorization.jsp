<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="row">
    <div class="col-md-4">
        <div class="position-absolute top-50 start-50 translate-middle h-25 w-25" style="background-color:white; border: 3px solid black">
            <h1>Войти</h1>
            <form method="post" action="/Curs/Enter">
           <div class="form-group">
               Введите имя пользователя
               <input name="name"/>
           </div>
           <div class="form-group">
               Введите пароль
               <input name="password"/>
           </div>
                <input type="submit" value="Войти" class="btn btn-primary btn-lg" />
               </form>
            <form method="post" action="/Curs/">
            <p><button type="submit" class="btn btn-primary">Назад</button></p>
        </form>
    </div>
    </div>
</div>

</body>
</html>
