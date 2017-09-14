<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>编号:</td>
			<td>${infos.id }</td>
		</tr>
		<tr>
			<td>用户名:</td>
			<td>${infos.username }</td>
		</tr>
		<tr>
			<td>出生日期:</td>
			<td>${infos.borndate }</td>
		</tr>
		<tr>
			<td>性别:</td>
			<td>${infos.sex}</td>
		</tr>
		<tr>
			<td>角色类型:</td>
			<td>${infos.rolename}</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"><a href="GameServlet?choice=0">首页</a></td>
		</tr>




	</table>

</body>
</html>