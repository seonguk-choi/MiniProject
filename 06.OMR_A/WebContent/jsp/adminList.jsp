<%@ page import="com.hanul.DTO.StudentDTO"%>
<%@ page import="com.hanul.DAO.OmrDAO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
request.setCharacterEncoding("utf-8");
OmrDAO dao = new OmrDAO();
List<StudentDTO> list = dao.studentSearchAll();
request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminList JSP</title>
<script type="text/javascript">
function fnDelete(std_code){

	if(confirm("정말 삭제하시겠습니까?")){
		location.href = "adminDelete.do?std_code=" + std_code;
	}
	return false;
}

</script>
</head>
<body>
<div class="middle" align="center">
<h3>[Student List]</h3>
<link rel="stylesheet" href="css/style.css" />
<table border="1">
	<tr>
		<th>이름</th>
		<th>수험번호</th>
		<th>점수</th>
		<th>합격결과</th>
		<th>응시여부</th>
		<th>매니저유무</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:if test="${empty list}">
		<tr align="center">
			<td colspan="8">등록된 수험생목록이 없습니다!</td>
		</tr>
	</c:if>
	<c:if test="${!empty list}">
		<c:forEach var="i" items="${list}">
			<tr align="center">
				<td>${i.name}</td>
				<td>${i.std_code}</td>
				<td>${i.score}</td>
				<td>${i.result}</td>
				<td>${i.apply}</td>
				<td>${i.manager}</td>			<%-- //location.href = "boardDelete.do?b_num=" + ${dto.b_num}; --%>
				<td><input type="button" value="삭제" onclick="fnDelete('${i.std_code}')"/></td>
				<td><input type="button" value="수정" onclick="location.href='adminUpdateForm.do?std_code=${i.std_code}';"/></td>
			</tr>
		</c:forEach>
	</c:if>
	<tr align="center">
		<td>
			<input type="button" value="추가" onclick="location.href='adminInsertForm.do'"> 
			<input type="button" value="답안지수정" onclick="location.href='adminAnswer.do'"> 
			<input type="button" value="처음으로" onclick="location.href='login.do'"> 
		</td>
	</tr>
</table>
</div>
</body>
</html>
