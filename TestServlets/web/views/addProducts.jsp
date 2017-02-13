<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить ваши товары</title>
</head>
<body>
<h1>Добро пожаловать, ${authUser}</h1>
<h3>Добавьте ваши товары на сайт.</h3>
<div>
    <c:if test="${products.isEmpty()}">
        <p>Пока у вас нет товаров :( </p>
    </c:if>
</div>
<div>
    <form action = "addProduct" method="post">
        <p>Название :    <input type="text" name="title"></p>
        <p>Количество :  <input type="text" name="quantity"></p>
        <p>Цена :        <input type="text" name="price"></p>
        <p>Комментарий : <input type="text" name="specification" size="20"></p>
        <input type="submit" value="Добавить">
        <input type="reset" value="Очистить">
    </form>
</div>
<div>
    <c:forEach items="${products}" var="product">
        <p>Добавлен товар</p>
        <p>Название : ${product.title}</p>
        <a href="/deleteProduct?id=${product.id}">Удалить товар</a>
        <a href="/editProduct?id=${product.id}">Редактировать товар</a>
    </c:forEach>
</div>


</body>
</html>
