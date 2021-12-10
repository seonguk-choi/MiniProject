<%@ page import="com.hanul.DTO.AnswerDTO"%>
<%@ page import="com.hanul.DTO.StudentDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
request.setCharacterEncoding("utf-8");
StudentDTO dto = (StudentDTO) request.getAttribute("dto");
int rank = (int) request.getAttribute("rank");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentRank</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="middle" align="center">
<h3>[등수 보기]</h3>
<table border="1" style="width: 80%">
	<tr>
		<th>이름 : <c:out value="${dto.name}"></c:out></th>
		<th>수험번호 : <c:out value="${dto.std_code}"></c:out></th>
		<th>점수 : <c:out value="${dto.score}"></c:out></th>
		<th>등수 : <c:out value="${rank}"></c:out> </th>
	</tr>
	<tr align="center">
		<td colspan="5">
			<input type="button" value="로그인화면" onclick="location.href='login.do'"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>
