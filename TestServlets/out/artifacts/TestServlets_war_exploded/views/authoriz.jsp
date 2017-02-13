<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<h1>Авторизация</h1>
<h3>${message}</h3>
<div>
    <form action="authoriz" method="post">
        <p>Логин :  <input type="text" name="login"></p>
        <p>Пароль : <input type="password" name="password"></p>
        <input type="submit" value="Авторизоваться">
        <input type="reset" value="Очистить">
    </form>
</div>
<a href="addProduct">Добавить товар</a>




</body>
</html>
