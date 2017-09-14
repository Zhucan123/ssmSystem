<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="GameServlet?choice=1" method="post">
		<table border="1">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>出生日期:</td>
				<td><input type="text" name="borndate"></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><input type="radio" value="男" name="sex">男 <input
					type="radio" value="女" name="sex">女</td>
			</tr>
			<tr>
				<td>角色类型:</td>
				<td><select name="roleid"> 
						<c:forEach items="${role_infos}" var="role">
							<option value="${role.id}">${role.rolename }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="提交"> <input type="submit" value="提交"></td>
			</tr>

		</table>


	</form>

</body>
</html>