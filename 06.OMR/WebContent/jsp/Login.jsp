<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style >
body {
	font:14px/1.5 "Noto Sans KR", sans-serif;
	color: #888;
	overflow-x:hidden;
}

.blind {
	display: none;
}

a, a:link {
	text-decoration: none;
	color: inherit; /* 부모 요소로부터 색상을 상속받아 사용한다 */
}
ul {
	   list-style:none;
  	   padding-left:0px;
}
</style>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/index.js"></script>
<script type="text/javascript">
	/* 수험자번호 글자수제한 */
	function maxLenthCheck(e) {
	  if(e.value.length > e.maxLength)  {
	    e.value  = e.value.slice(0, e.maxLength);
	  }//if
}//function

//EnterKey금지
document.addEventListener('keydown', function(event) {
	  if (event.keyCode === 13) {
	    event.preventDefault();
	  };
	}, true);
$(document).ready(function(){ 
	$("#adminBtn").click(function() {
		var studentid = $("#studentid").val();
		var studentname = $("#studentname").val();
		
		if (!studentid || !studentname) {
			swal("관리자만 접근 가능합니다.");
		} else {
			$.ajax({ //ajax 실행
				url : "cs.do",
				type : "POST",
				data : {
					studentid : studentid,
					studentname : studentname
				}, 
				success : function(result) {
					if (result == 0) {
							swal("관리자 정보가 잘못됐습니다.");
							$("#studentid").focus();
					} else if (result == 3) {
							if(confirm("관리자 페이지로 이동하시겠습니까?") == false){
								swal("취소되었습니다.");
							}else {
								location.href="Manager.jsp";
							}
					}//if
				}//success
			});//ajax 
		}//if
	});//click
})//ready
</script>
</head>
<body>
	<div class="container">
		<div id="wrap">
		<form method="post" action="studentExam.do" id="studentform" onsubmit="return fnSubmit()" onreset="return fnReset()">
			<table>
				<div>
				<img src="images/visual_bg.PNG" alt="omr" />
				</div>
				<ul>
					<li><label for="studentname">수험자 이름</label></li>
					<li>
						<input type="text" class="input" placeholder="수험자 이름"name="studentname" id="studentname" maxlength="6">
					</li>
				</ul>
				<ul>
					<li><label for="studentid">수험자 번호</label></li>
					<li>
						<input type="number" class="input" placeholder="수험자 번호" name="studentid" id="studentid" 
						 maxlength="5" autofocus="autofocus" oninput="maxLenthCheck(this);"/>
					</li>
				</ul>

				<div>			
					<input type="submit" class="submitBtn" id="submitBtn" value="응시하기" />
					<input type="reset" class="resetBtn" id="resetBtn" value="초기화" />
					<input type="button" class="plustBtn" id="plusBtn" value="추가접수" />
					<input type="button" class="adminBtn" id="adminBtn" value="관리자" />
					
				</div>

			 </table>
		</form>
		</div>
	</div>	<!-- class: container  -->

</body>
</html>