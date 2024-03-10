<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增商品</title>
</head>
<body>

<h2>新增商品</h2>

<form action="MallInsert" method="post">
    <label for="productName">商品名稱:</label><br>
    <input type="text" id="productName" name="productName"><br>
    <label for="productPrice">商品價格:</label><br>
    <input type="text" id="productPrice" name="productPrice"><br>
    <label for="productStock">商品庫存:</label><br>
    <input type="number" id="productStock" name="productStock" min="0"><br>
    <label for="productDescription">商品描述:</label><br>
    <textarea id="productDescription" name="productDescription"></textarea><br><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
