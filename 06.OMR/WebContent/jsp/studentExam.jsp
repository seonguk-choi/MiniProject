<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
=======
<%@page import="com.hanul.DTO.AnswerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.DTO.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
StudentDTO dto = (StudentDTO) request.getAttribute("dto");
ArrayList<AnswerDTO> list = (ArrayList<AnswerDTO>) request.getAttribute("list");
%>
>>>>>>> origin/CSU
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Exam</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
function fnAnswerSubmit(){
	if(confirm("제출하시겠습니까?")){
		return true;
	}
	return false;
}
function fnMain(){
	if(confirm("처음으로 이동합니다.")){
<<<<<<< HEAD
		location.href="Login.bo";
=======
		location.href="Login.do";
>>>>>>> origin/CSU
		return true;
	}
	return false;
}
</script>
</head>
<<<<<<< HEAD
<body>
	<form action="studentResult.do" method="post" onsubmit="return fnAnswerSubmit()">
=======
<body onload="fnTimer()">
	<form action="studentResult.do" method="post" onsubmit="return fnAnswerSubmit()">
	<input type="hidden" name="list" value="${dto}"/>
>>>>>>> origin/CSU
	<input type="hidden" />
		<div class="exam">
			<img alt="시험지" src="images/exam.png">
		</div>
		<div class="wrapper" align="center">
			<table border="1">
				<tr>
<<<<<<< HEAD
					<th colspan="2">OMR</th>
				</tr>
				<tr>
					<th>이름</th>
					<th>수험번호</th>
				</tr>
				<tr>
					<td>${dto.name}</td> 
					<td>${dto.std_code}</td>
=======
					<th colspan="3">OMR</th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Student Code</th>
					<th>Timer</th>
				</tr>
				<tr>
					<td>${dto.name}</td> 
					<td>${dto.std_code}</td> 
					<td class="timer"></td> 
>>>>>>> origin/CSU
				</tr>
			</table>
			<div class="answer-wrap">
				<table>
<<<<<<< HEAD
					<c:forEach var="i" items="${lista}">
						<tr>
							<th><c:out value="${i.answer}" />번</th>
							<td>
								<div class="radio-items">
									<div>
										<input type="radio" name="Q${i.answer}" id="one" class="only-sr checked" value="1" /> 
										<label for="one">1</label>
									</div>
									<div>
										<input type="radio" name="Q${i.answer}" id="two" class="only-sr checked" value="2" /> 
										<label for="two">2</label>
									</div>
									<div>
										<input type="radio" name="Q${i.answer}" id="three" class="only-sr checked" value="3" /> 
										<label for="three">3</label>
									</div>
									<div>
										<input type="radio" name="Q${i.answer}" id="four" class="only-sr checked" value="4" /> 
										<label for="four">4</label>
=======
					<c:forEach var="i" begin="1" end="10">
						<tr>
							<th><c:out value="${i}" />번</th>
							<td>
								<div class="radio-items">
									<div>
										<input type="radio" name="Q${i}" class="only-sr checked" id="one${i}" value="1" /> 
										<label for="one${i}">1</label>
									</div>
									<div>
										<input type="radio" name="Q${i}" class="only-sr checked" id="two${i}" value="2" /> 
										<label for="two${i}">2</label>
									</div>
									<div>
										<input type="radio" name="Q${i}" class="only-sr checked" id="three${i}" value="3" /> 
										<label for="three${i}">3</label>
									</div>
									<div>
										<input type="radio" name="Q${i}" class="only-sr checked" id="four${i}" value="4" /> 
										<label for="four${i}">4</label>
>>>>>>> origin/CSU
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="btn-wrap">
<<<<<<< HEAD
					<input type="button" value="처음으로" onclick="return fnMain()" />
					<input type="submit" value="시험제출" />
=======
					<input type="button" value="Previous" onclick="return fnMain()" />
					<input type="submit" value="Applying" />
>>>>>>> origin/CSU
				</div>
			</div>
		</div>
	</form>
</body>
</html>