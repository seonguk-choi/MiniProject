<%@page import="com.hanul.DTO.StudentDTO"%>
<%@page import="com.hanul.DAO.OmrDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
StudentDTO dto = (StudentDTO) request.getAttribute("dto");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Update Form</title>
<style type="text/css">
.in{
	background-color: #E0E0E0;
}
</style>
<script type="text/javascript">
function fnSubmit(){
	if(confirm("정말 수정하시겠습니까?")){
		return true;
	}
	return false;
}

function fnReset(){
	var msg = "수정하신 내용이 초기화 됩니다.";
	msg += "\n계속 진행하시겠습니까?";
	if(confirm(msg)){
		return true;
	}
	return false;
}
</script>
</head>
<body>
<div align="center">
<h3>[수험생정보 수정화면]</h3>
<form action="adminUpdate.jsp" method="post" onsubmit="return fnSubmit()" onreset="return fnReset()"> 
<input type="hidden" name="std_code" value="${dto.std_code}"/>                                                                
<table border="1">                                                                                                         
	<tr>                                                                                                                   
		<th>이름</th>                                                                                                      
		<td><input type="text" name="name" value="${dto.name}" required="required" class="in"/></td>                       
	</tr>                                                                                                                  
	<tr>                                                                                                                   
		<th>수험번호</th>
		<td><input type="number" name="std_code" value="${dto.std_code}" required="required" class="in"/></td>
	</tr>
	<tr>                                                                                                                          
		<th>점수</th>
		<td><input type="number" name="score" value="${dto.score}" required="required" class="in"/></td>
	</tr>
	<tr>                                                                                                                          
		<th>합격결과</th>
		<td><input type="text" name="result" value="${dto.result}" required="required" class="in"/></td>
	</tr>
	<tr>                                                                                                                          
		<th>응시여부</th>
		<td><input type="text" name="apply" value="${dto.apply}" required="required" class="in"/></td>
	</tr>
	<tr>                                                                                                                          
		<th>매니저유무</th>
		<td><input type="text" name="manager" value="${dto.manager}" required="required" class="in"/></td>
	</tr>
	<tr>                                                                                                                          
		<th>등수</th>
		<td><input type="number" name="rank" value="${dto.rank}" required="required" class="in"/></td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<input type="button" value="수정하기" />
			<input type="reset" value="초기화하기"/>
			<input type="button" value="목록보기" onclick="location.href='adminList.jsp'"/>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>









