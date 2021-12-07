<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		location.href="Login.bo";
		return true;
	}
	return false;
}
</script>
</head>
<body>
	<form action="studentResult.do" method="post" onsubmit="return fnAnswerSubmit()">
	<input type="hidden" />
		<div class="exam">
			<img alt="시험지" src="images/exam.png">
		</div>
		<div class="wrapper" align="center">
			<table border="1">
				<tr>
					<th colspan="2">OMR</th>
				</tr>
				<tr>
					<th>이름</th>
					<th>수험번호</th>
				</tr>
				<tr>
					<td>${dto.name}</td> 
					<td>${dto.std_code}</td>
				</tr>
			</table>
			<div class="answer-wrap">
				<table>
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
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="btn-wrap">
					<input type="button" value="처음으로" onclick="return fnMain()" />
					<input type="submit" value="시험제출" />
				</div>
			</div>
		</div>
	</form>
</body>
</html>