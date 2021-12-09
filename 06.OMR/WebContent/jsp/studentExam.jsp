<!--studentExam.JSP 통쨰로 복붙  -->
<%@page import="com.hanul.DTO.AnswerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.DTO.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
StudentDTO dto = (StudentDTO) request.getAttribute("dto");
ArrayList<AnswerDTO> list = (ArrayList<AnswerDTO>) request.getAttribute("list");
int time =(int) request.getAttribute("time");
%>
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
		location.href="login.do";
		return true;
	}
	return false;
}


var SetTime = ${time};			// 최초 설정 시간(기본 : 초)
function msg_time() {	// 1초씩 카운트
	m = Math.floor(SetTime / 60) + "분 " + (SetTime % 60) + "초";	// 남은 시간 계산
	var msg = "현재 남은 시간은 <font color='red'>" + m + "</font> 입니다.";
	document.all.ViewTimer.innerHTML = msg;		// div 영역에 보여줌 
	SetTime--;					// 1초씩 감소
	if (SetTime < 0) {			// 시간이 종료 되었으면..
		clearInterval(tid);		// 타이머 해제
		alert("종료");
	}
	
}
window.onload = function TimerStart(){ tid=setInterval('msg_time()',1000) };
</script>
</head>
<div id="ViewTimer"></div>  <!-- 이 코드가 타이머 실행입니다! -->
<body onload="fnTimer()">
	<form action="studentResult.do" method="post" onsubmit="return fnAnswerSubmit()">
	<input type="hidden" name="name" value="${dto.name}"/>
	<input type="hidden" name="std_code" value="${dto.std_code}"/>
	<input type="hidden" name="std_answer"
	value="<c:forEach var="i" begin="1" end="10">
	</c:forEach>">	
	<c:forEach var="i" begin="1" end="10"></c:forEach>
		<div class="exam">
			<img alt="시험지" src="images/exam.png">
		</div>
		<div class="wrapper" align="center">
			<table border="1">
				<tr>
					<th colspan="3">OMR</th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Student Code</th>
					<th>TIME</th>

				</tr>
				<tr>
					<td>${dto.name}</td> 
					<td>${dto.std_code}</td>  
					<td>${time}</td>
				</tr>
			</table>
			<div class="answer-wrap">
				<table>
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
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="btn-wrap">
					<input type="button" value="Previous" onclick="return fnMain()" />
					<input type="submit" value="Applying" />
				</div>
			</div>
		</div>
	</form>
</body>
</html>