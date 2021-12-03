
<%@page import="com.hanul.DTO.StudentDTO"%>
<%@page import="com.hanul.DAO.OmrDAO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminList JSP</title>
<!-- <script type="text/javascript">
function fnDelete(id){
	//alert("ID : " + id);
	if(confirm("정말 삭제하시겠습니까?")){
		location.href = "delete.jsp?id=" + id;
	}
	return false;
}

function fnUpdate(id){
	//alert("ID : " + id);
	location.href = "detail.jsp?id=" + id;
}
</script> -->
</head>
<body>
<div align="center">
<h3>[Student List]</h3>
<table border="1">
	<tr>
		<th>이름</th>
		<th>수험번호</th>
		<th>점수</th>
		<th>합격결과</th>
		<th>응시여부</th>
		<th>매니저유무</th>
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
				<td>${i.manager}</td>
				<td><input type="button" value="삭제" onclick="fnDelete('${i.std_code}')"/></td>
				<td><input type="button" value="수정" onclick="fnUpdate('${i.std_code}')"/></td>
			</tr>
		</c:forEach>
	</c:if>
	<!-- 수험생 한명 검색하는거 시간나면 하기 -->
	<!-- <tr align="center">
		<td colspan="8">
			<form action="search.jsp" method="post">
				<select name="part">
					<option value="name">이름</option>
					<option value="id">아이디</option>
					<option value="addr">주소</option>
					<option value="tel">전화번호</option>
				</select>
				<input type="text" name="searchData" required="required"/>
				<input type="submit" value="검색하기"/>
				<input type="button" value="회원가입" onclick="location.href='memberMain.html'"/>
			</form>
		</td>
	</tr> -->
</table>
</div>
</body>
</html>
