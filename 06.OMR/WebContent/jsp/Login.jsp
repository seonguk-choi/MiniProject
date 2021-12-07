<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
function fnSubmit(){
	if(confirm("응시 하시겠습니까?")){
		return true;
	}
	return false;
}
function fnReset(){
	if(confirm("입력한 내용을 삭제 하시겠습니까?")){
		return true;
	}
	return false;
}
</script>
</head>
<body>
	<div class="bg">
		<div class="text">
			<div align="center">
				<h3>Login</h3>
				<form action="LoginAction.do" method="post" onsubmit="return fnSubmit()" onreset="return fnReset()">
					<table>
						<tr>
							<th class="ths">Name</th>
							<td class="tds">
								<input type="text" name="name"required="required" class="input" />
							</td>
						</tr>
						<tr>
							<th class="ths">Student Code</th>
							<td class="tds">
								<input type="number" name="code" required="required" class="input" />
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="시험응시"/>
								<input type="reset" value="초기화하기" />
								<input type="button" value="성적확인" onclick="location.href='studentGrade.do'"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>