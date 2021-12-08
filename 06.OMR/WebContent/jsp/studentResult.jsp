<%@page import="java.util.ArrayList"%>
<%@ page import="com.hanul.DTO.AnswerDTO"%>
<<<<<<< HEAD
<%@ page import="com.hanul.DTO.StudentDTO"%>
=======
>>>>>>> origin/CSU
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
<<<<<<< HEAD
request.setCharacterEncoding("utf-8");
StudentDTO dto = (StudentDTO) request.getAttribute("dto");
List<AnswerDTO> list = (List<AnswerDTO>) request.getAttribute("list");
request.setAttribute("dto", dto);
=======
ArrayList<Integer> list = new ArrayList<Integer>();
for(int i=0; i<10; i++){
	list.add(i);
}

>>>>>>> origin/CSU
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentResult</title>
</head>
<body>
<div align="center">
<h3>[채점 보기]</h3>
<<<<<<< HEAD
<form method="post" action="studentRank.do">
<table border="1" style="width: 80%">
	<tr>
		<th>문제</th>
		<th>작성자 답</th>
		<th>답안</th>
		<th>정답여부</th>
	</tr>
	<c:if test="${empty list}">
		<tr align="center">
			<td colspan="5">작성된 답안이 없습니다!</td>
		</tr>
	</c:if>
		<c:if test="${!empty list}">	
		<c:set var="count" value="0"/>
<c:forEach var="i" items="${list}" varStatus="status">
	<c:set var="student_eq" value="${i.answer}" />
	<c:set var="answer_eq" value="${list2[status.index].answer}" />
 	<c:if test= "${student_eq eq answer_eq}"  >
    <tr align="center">
    <td> ${status.index+1 }</td>
    <td> ${i.answer}</td>
    <td> ${list2[status.index].answer}</td>
    <td> O </td>
    <c:set var="count" value="${count+1}"/>
	</tr>
	</c:if>
	 	<c:if test= "${student_eq ne answer_eq}"  >
    <tr align="center">
    <td> ${status.index+1 }</td>
    <td> ${i.answer}</td>
    <td> ${list2[status.index].answer}</td>
    <td> X </td>
	</tr>
	</c:if>

</c:forEach>
	    <c:set var="count" value="${count*10}"/>
	<c:set var="pass" value="80"/> 
	</c:if>
	 <tr align="center">
	<td> 이름: ${dto.name}</td>
	<td> 수험번호: ${dto.std_code}</td>
	<td> 점수: <c:out value="${count}"></c:out> </td>
		 <c:if test="${count ge pass}">
		 <td>합격</td>
		 </c:if>
		 <c:if test="${count lt pass}">
		 <td>불합격</td>
		</c:if>
		 
	</tr>

	
	<tr align="center">
		<td colspan="5">
			<input type="button" value="처음으로" onclick="location.href='Login.do'"/> // 뭐엿지?
			<input type="submit" value="등수확인" onclick="location.href='studentRank.do'"/>
		</td>
	</tr>
	

</table>
	<input type="hidden" name="name" value="${dto.name}"/>
	<input type="hidden" name="code" value="${dto.std_code}"/>
	<input type="hidden" name="score" value="${count}"/>
</form>
=======
<table border="1" style="width: 80%">
   <tr>
      <th>문제</th>
      <th>정답여부</th>
   </tr>
   <%-- JSTL과 EL 표현식을 이용한 출력 : 글번호가 일련번호 형식으로 출력 --%>
   <c:if test="${empty list}">
      <tr align="center">
         <td colspan="5">작성된 글이 없습니다!</td>
      </tr>
   </c:if>
   <c:if test="${!empty list}">
      <c:set var="count" value="0"/>
      <tr align="center">
      <c:forEach var="i" begin="0" end="${fn:length(list) - 1}" step="1">
         <c:choose>
            <td colspan="5">i번 문제</td>
               <c:when test="${list[i].answer == list2[i].answer}">
                  <td>"정답"</td>
               <c:set var="count" value="${count + 1}"/>
               </c:when>
               <c:otherwise>
                  <td>"오답"</td>
               </c:otherwise>
            </c:choose>
         </c:forEach>
         <c:set var="point" value="${count*(100/fn:length(list))}"/>
         <td>point</td>
      </tr>
   </c:if>
   
   <tr align="center">
      <td colspan="5">
         <input type="button" value="글쓰기" onclick="location.href='boardWriteForm.do'"/>
      </td>
   </tr>
</table>
>>>>>>> origin/CSU
</div>
</body>
</html>