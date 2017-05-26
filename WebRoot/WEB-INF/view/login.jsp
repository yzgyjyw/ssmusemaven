<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

	function login(){
		alert(1);
		var username = document.getElementsByName("username")[0].value
		var password = document.getElementsByName("password")[0].value
		
		//注意使用这种方式重新设置form的action的时候，"loginForm"必须为表单的名称而不是id
		document.loginForm.action = "${pageContext.request.contextPath }/login/"+username+"/"+password
		document.loginForm.submit()
	}

</script>
</head>
<body>
	<form name="loginForm" action="">
		用户账号：<input type="text" name="username" /><br /> 用户密码 ：<input
			type="password" name="password" /><br /> <input type="button"
			value="登陆" onclick="login()" />
	</form>

	${loginname }
</body>
</html>