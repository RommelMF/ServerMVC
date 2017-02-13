<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование</title>
</head>
<body>
<h3>Редактирование товара</h3>
<div>
    <form action = "editProduct" method="post">
        <p>Название :    <input type="text" name="title" value="${product.title}"></p>
        <p>Количество :  <input type="text" name="quantity" value="${product.quantity}"></p>
        <p>Цена :        <input type="text" name="price" value="${product.price}"></p>
        <p>Комментарий : <input type="text" name="specification" value="${product.specification}" size="20"></p>
        <input type="submit" value="Сохранить">
    </form>
</div>

</body>
</html>
