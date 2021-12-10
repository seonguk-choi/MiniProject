<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/style.css" />
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
function fnGrade(){		
	var name = $('input[type=text]').val();
	var code = $('input[type=number]').val();
	if(name.trim()!=""){
		if(code.trim()!=""){
			location.href="studentGrade.do?name="+name+"&std_code="+code;	
		}else {
			alert("수험번호를 입력하세요");
			$('input[type=number]').focus();			
		}
	} else{
		alert("이름을 입력하세요");
		$('input[type=text]').focus();
	}
}
</script>
</head>
<body>
	<div>
		<div class="text">
			<div class="login" align="center">
				<h3>Login</h3>
				<form action="LoginAction.do" method="post" onsubmit="return fnSubmit()" onreset="return fnReset()">
					<table>
						<tr>
							<th class="ths">Name</th>
							<td class="tds">
								<input type="text" name="name"required="required" />
							</td>
						</tr>
						<tr>
							<th class="ths">Student Code</th>
							<td class="tds">
								<input type="number" name="std_code" required="required" />
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="Start exam"/>
								<input type="reset" value="Reset" />
								<input type="button" value="My Grade" onclick="fnGrade()"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>