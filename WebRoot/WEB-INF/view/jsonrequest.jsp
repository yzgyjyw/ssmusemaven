<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	function jsonrequest(){
		alert(1)
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/queryitemsUsejson.action",
			contentType:"application/json",
			/* 注意data的写法，不能是"{'id':1}" 
			throws java.lang.Exception]: org.springframework.http.converter.HttpMessageNotReadableException: 
			Could not read JSON: Unexpected character (''' (code 39)): was expecting double-quote to start field name*/
			data:'{"id":1}',
			dataType:"json",
			success:function(data){
				alert(data.name+"\t"+data.id+"\t"+data.detail)
			},
			error:function(){
				alert("未知错误")
			}
		})
	}
</script>
</head>
<body>
	<input type="button" value="以json的形式传递参数" onclick="jsonrequest()"/>
</body>
</html>