<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Регистрация</h1>
<form action="regist" method="post">
    <p>Имя    <input type="text" name="name"></p>
    <p>Email  <input type="text" name="email"></p>
    <p>Логин  <input type="text" name="login"></p>
    <p>Пароль <input type="password" name="password"></p>
    <input type="submit" value="Отправить">
    <input type="reset" value="Сбросить">
</form>

<c:forEach items="${listUsers}" var="user">
    <h3>Спасибо за регистрацию, ${user.name}</h3>
    <p>Ваш логин : ${user.login}</p>
    <p>Ваш emal : ${user.email}</p>
    <p><a href="authoriz">Авторизация</a></p>
</c:forEach>

</body>
</html>
