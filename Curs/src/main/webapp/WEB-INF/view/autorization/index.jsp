<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!--<link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
</head>
<body>

<div class="container">
    <main role="main" class="pb-3">
        <div class="position-absolute top-50 start-50 translate-middle h-25 w-25" style="background-color:white; border: 3px solid black">
            <form class="position-absolute top-50 start-50 translate-middle" method="post" action="/Curs/registration">
                <p><button type="submit" class="btn btn-primary btn-lg">Зарегестрироваться</button></p>
            </form>
            <form class="position-absolute bottom-0 start-50 translate-middle" method="post" action="/Curs/autorization">
                <p><button type="submit" class="btn btn-primary btn-lg">Войти</button></p>
            </form>

        </div>
    </main>

</div>


</body>
</html>

