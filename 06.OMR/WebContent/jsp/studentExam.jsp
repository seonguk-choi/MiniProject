<%@page import="com.hanul.DTO.AnswerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
var q[i]= tetxname[i] 
list[i] =q[i]
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Exam</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/style.css" />
<script type="js/main.js"></script>
</head>
<body>
<form action="studentResult.bo" method="post" onsubmit="fnAnswerSubmit()">
	<div class="exam">
		<img alt="시험지" src="images/exam.png">
	</div>
	<div class="wrapper">
		<div class="info-wrap">
			<h3>OMR</h3>
			<div class="std-info">		
				<div class="std">
					<div>이름</div>
					<div>${dto.name}</div>
				</div>
				<div class="std">
					<div>수험번호</div>
					<div>${dto.std_code}</div>
				</div>
			</div>
			<div class="std">
				<div id="timer"></div>
			</div>
		</div>
		<div class="answer-wrap">
		<c:forEach var="i" begin="1" end="10" step="1">
		<div class="answer">
				<h4><c:out value="${i}" />번</h4>	
				<div class="radio-items">
					<div>
						<input type="radio" name="Q<c:out value="${i}" />" id="one" class="only-sr checked" value="1"/>
						<label for="one">1</label>				
					</div>
					<div>
						<input type="radio" name="Q<c:out value="${i}" />" id="two" class="only-sr checked" value="2"/>
						<label for="one">2</label>				
					</div>
					<div>
						<input type="radio" name="Q<c:out value="${i}" />" id="three" class="only-sr checked" value="3"/>
						<label for="one">3</label>				
					</div>
					<div>
						<input type="radio" name="Q<c:out value="${i}" />" id="four" class="only-sr checked" value="4"/>
						<label for="one">4</label>		
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="btn-wrap">
			<input type="button" value="처음으로" onclick="fnMain()"/>
			<input type="submit" value="시험제출"/>
		</div>
	</div>
</form>
</body>
</html>