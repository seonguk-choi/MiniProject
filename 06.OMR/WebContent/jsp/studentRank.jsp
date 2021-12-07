
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentRank</title>
</head>
<body>
<div align="center">
<h3>[등수 보기]</h3>
<table border="1" style="width: 80%">
	<tr>
		<th>수험번호 : <c:out value="${std_code}"></c:out></th>
		<th>점수 : <c:out value="${score}"></c:out></th>
		<th>등수 : <c:out value="${rank}"></c:out> </th>
	</tr>

	<tr align="center">
		<td colspan="5">
			<input type="button" value="로그인화면" onclick="location.href='Login.do'"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>
