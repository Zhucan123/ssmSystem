<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="GameServlet?choice=2" method="post">
		<table border="1">
			<tr>
				<td>编号:</td>
				<td><input type="hidden" name="id" value="${info.id }">${info.id }</td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"
					value="${info.username }">
					
					</td>
			</tr>
			<tr>
				<td>出生日期:</td>
				<td><input type="text" name="borndate"
					value="${info.borndate }"></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><input type="radio" value="男" name="sex"
					 <c:if test="${info.sex=='男'}">checked="checked"</c:if>  > 男 <input
					type="radio" value="女" name="sex"
					 <c:if test="${info.sex!='男'}">checked="checked"</c:if>  > 女 </td>
					
			</tr>
			<tr>
				<td>角色类型:</td>
				<td><select name="roleid">
						<c:forEach items="${role_infos}" var="role">
							<option value="${role.id}"
								<c:if test="${role.id==info.roleno }"> selected="selected"</c:if>>${role.rolename }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="提交"> <input type="submit" value="取消"></td>
			</tr>




		</table>


	</form>

</body>
</html>