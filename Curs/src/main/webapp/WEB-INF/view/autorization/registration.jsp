<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Зарегестрироваться</h1>
<div class="row">
    <div class="col-md-4">
        <form method="post" action="/Curs/Create">
                <div class="form-group">
                    Введите имя пользователя
                <input name="name"/>
            </div>
            <div class="form-group">
                Введите пароль
                <input name="password"/>
            </div>
             <div class="form-group">
                            <p>Зарегестрироваться как соискатель</p><input type="radio" name="role" value="1"/>
                            <p>Зарегестрироваться как работодатель</p><input type="radio" name="role" value="2"/>
             </div>
                <input type="submit" value="Зарегестрироваться" class="btn btn-primary btn-lg" />

        </form>
    </div>
</div>
<form method="post" action="/Curs/">
    <p><button type="submit">Назад</button></p>
</form>
</body>
</html>
