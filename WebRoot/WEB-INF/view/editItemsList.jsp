<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/updateAllItmes.action" method="post">
		<table border="1">

			<thead>
				<tr>
					<td>商品名称</td>
					<td>商品价格</td>
					<td>商品描述</td>
					<td>商品上线时间</td>
				</tr>
			</thead>

			<c:forEach items="${ items }" var="item" varStatus="s">
				<tr>
					<td><input type="text" name="itemsList[${s.index}].name" value="${item.name}" /></td>
					<td><input type="text" name="itemsList[${s.index}].price" value="${item.price}" /></td>
					<td><input type="text" name="itemsList[${s.index}].detail" value="${item.detail}" /></td>
					<td><input type="text" name="itemsList[${s.index}].createtime"
						value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
				</tr>
			</c:forEach>
			
			<tr>
				<td><input type="submit" value="提交"/></td>
			</tr>
			
		</table>
	</form>

</body>
</html>