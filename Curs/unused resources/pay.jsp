<%@page contentType="text/html;charsetUTF-8" language="java"%>
<%@page isELIgnored="false"%>
<html>
<head></head>
<body>
<h1>Оплатить услуги</h1>

<div class="row">
    <div class="col-md-4">

            <div class="form-group">
                <label>Введите номер карты</label>
                <input/>
            </div>
            <div class="form-group">
                <label>Введите код cvv</label>
                <input/>
            </div>

        <form method="post" action="/Curs/Home">
            <div class="form-group">
                <input type="submit" value="Оплатить один день" class="btn btn-primary" />
            </div>
        </form>
        <form method="post" action="/Curs/Home">
            <div class="form-group">
                <input type="submit" value="Оплатить одну неделю" class="btn btn-primary" />
            </div>
        </form>
        <form method="post" action="/Curs/Home">
            <div class="form-group">
                <input type="submit" value="Оплатить один месяц" class="btn btn-primary" />
            </div>
        </form>
    </div>
</div>
</body>
</html>


