<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${errors}" var="error">
		${error.defaultMessage}
	</c:forEach>

	<form action="${pageContext.request.contextPath }/updateItem.action"
		method="post" enctype="multipart/form-data">
		<input type="text" name="id" value="${item.id}" /><br /> <input
			type="text" name="name" value="${item.name}" /><br /> <input
			type="text" name="price" value="${item.price}" /><br /> <input
			type="text" name="detail" value="${item.detail}" /><br /> <input
			type="text" name="createtime"
			value='<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>' /><br />
		<c:if test="${item.pic != null }">
			<img src="/pic/${item.pic}" width="100px" height="100px"/>
		</c:if>
		<input type="file" name="pictureFile"/>
		<input type="submit" value="提交" />
	</form>
</body>
</html>