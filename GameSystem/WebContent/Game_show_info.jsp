<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
	function gopage(index) {
		$("#pageIndex").val(index);
		$("#showPage").submit();
	}
</script>
<body>
	<form action="GameServlet?choice=0" method="post" id="showPage">
		<div>
			名称:<input type="text" name=username value="${ username}"> 角色:<select
				name="roleid">
				<option value="0">全部</option>
				<c:forEach items="${roles}" var="roles">
					<option value="${roles.id }"
						<c:if test="${roles.id==roleid }">selected="selected"</c:if>>${roles.rolename }</option>
				</c:forEach>
			</select> <input type="hidden" id="pageIndex" name="pageIndex">
			<input type="submit" value="查询">
		</div>
		<div>
			<a href="GameServlet?choice=4">添加</a>
		</div>
		<table border="1">
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>性别</td>
				<td>出生日期</td>
				<td>角色</td>
				<td>删除</td>
				<td>详情</td>
				<td>修改</td>
			</tr>
			<c:forEach items="${pageBean.list}" var="list">
				<tr>
					<td>${list.id }</td>
					<td>${list.username }</td>
					<td>${list.sex }</td>
					<td>${list.borndate }</td>
					<td>${list.rolename }</td>
					<td><a href="GameServlet?choice=3&id=${list.id }">删除</a></td>
					<td><a href="GameServlet?choice=5&id=${list.id }">详情</a></td>
					<td><a href="GameServlet?choice=6&id=${list.id }">修改</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8" style="text-align: center;"><a href="javascript:gopage(0);">首页</a> <a
					href="javascript:gopage(${pageBean.pageIndex-1 });">上一页</a> <a
					href="javascript:gopage(${pageBean.pageIndex+1 });">下一页</a> <a
					href="javascript:gopage(${pageBean.totalPage });">末页</a> <c:if
						test="${pageBean.totalPage==0}">
						<span>${pageBean.pageIndex}/${pageBean.totalPage }页</span>
					</c:if> <c:if test="${pageBean.totalPage!=0}">
						<span>${pageBean.pageIndex+1}/${pageBean.totalPage }页</span>
					</c:if></td>
			</tr>
		</table>




	</form>

</body>
</html>