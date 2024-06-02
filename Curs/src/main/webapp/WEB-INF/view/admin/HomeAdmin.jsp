

<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1><b>ЗДРАВСТВУЙТЕ ПОВЕЛИТЕЛЬ</b></h1>
<div class="form-group">
    <form method="post" action="/Curs/Clients">
        <p><button type="submit">Посмотреть клиентов</button></p>
    </form>
    <form method="post" action="/Curs/Managers">
            <p><button type="submit">Посмотреть менеджеров</button></p>
        </form>
    <form method="post" action="/Curs/Companies">
        <p><button type="submit">Посмотреть компании</button></p>
    </form>
</div>
<form method="post" action="/Curs/">
    <p><button type="submit" >Назад</button></p>
</form>
</body>
</html>
