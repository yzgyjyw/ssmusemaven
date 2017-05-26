<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${user != null }">
	登录名：${ user.username }<br/>
</c:if>
<table border="1" >

	<thead>
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品描述</td>
			<td>商品上线时间</td>
		</tr>
	</thead>

	<c:forEach items="${ items }" var="item">
		<tr>
			<td>${item.name}</td>
			<td>${item.price}</td>
			<td>${item.detail}</td>
			<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td><a href="${pageContext.request.contextPath}/editItem.action?id=${item.id}">查询详情</a></td>
		</tr>
	</c:forEach>

</table>

</body>
</html>