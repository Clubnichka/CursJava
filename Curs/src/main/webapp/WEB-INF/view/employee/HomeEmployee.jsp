<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle h-30 w-30" style="background-color:white">
    <form method="post" action="/Curs/resume"><p><button type="submit" class="btn btn-primary">Добавить резюме</button></p>
    </form>
    <form method="post" action="/Curs/viewvacancies"><p><button type="submit" class="btn btn-primary">Посмотреть вакансии</button></p>
    </form>
    <form method="post" action="/Curs/viewRes"><p><button type="submit" class="btn btn-primary">Посмотреть мои резюме</button></p>
    </form>
    <form method="post" action="/Curs/viewContact"><p><button type="submit" class="btn btn-primary">Мои контакты</button></p>
    </form>
    <c:if test="${nots.size()>0}">
        <form method="post" action="/Curs/EviewNots">
            <p><button type="submit" class="btn btn-primary">Ответы на заявки</button>(<c:out value="${nots.size()}"/> )</p>
        </form>
    </c:if>
<form method="post" action="/Curs/">
    <p><button type="submit" class="btn btn-primary">Назад</button></p>
</form>

</div>
</body>
</html>

