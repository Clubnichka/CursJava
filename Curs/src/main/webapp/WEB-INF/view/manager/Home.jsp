<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="position-absolute top-50 start-50 translate-middle h-30 w-30" style="background-color:white">
<div >
    <form method="post" action="/Curs/Mviewcandidates">
        <p><button type="submit" class="btn btn-primary">Посмотреть кандидатов</button></p>
    </form>
    <form method="post" action="/Curs/Mviewvacancies">
        <p><button type="submit" class="btn btn-primary">Посмотреть вакансии</button></p>
    </form>
    <form method="post" action="/Curs/Mviewcompanies">
        <p><button type="submit" class="btn btn-primary">Посмотреть компании</button></p>
    </form>
</div>
<form method="post" action="/Curs/">
    <p><button type="submit" class="btn btn-primary">Назад</button></p>
</form>
</body>
</html>
