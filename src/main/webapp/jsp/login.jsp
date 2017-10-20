<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Авторизація</title>
    </head>

    <body>
        <h2>Авторизація</h2>

        <form action="authorize" method="POST">

            <p>Логін</p>
            <input type="text" name="name"/>

            <p>Пароль</p>
            <input type="text" name="password"/>

            <br>
            <input type="submit" value="Ввійти в систему"/>
        </form>

    </body>

</html>