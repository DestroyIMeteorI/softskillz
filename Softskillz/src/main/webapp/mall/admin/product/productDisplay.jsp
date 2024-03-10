<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>產品列表</title>
<!-- 樣式可以根據需要引用或直接寫在這裡 -->
</head>
<body>
	<div class="container">
		<h2>產品列表</h2>
		<table>
			<tr>
				<th>產品名稱</th>
				<th>描述</th>
				<th>類別 ID</th>
				<th>價格</th>
				<th>庫存</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.productName}</td>
					<td>${product.productDescription}</td>
					<td>${product.categoryId}</td>
					<td>${product.productPrice}</td>
					<td>${product.productStock}</td>
					<td><a
						href="${pageContext.request.contextPath}/mall/admin/product/MallUpdate?id=${product.id}">更新</a>
						<a
						href="${pageContext.request.contextPath}/mall/admin/product/MallDelete?id=${product.id}">刪除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
