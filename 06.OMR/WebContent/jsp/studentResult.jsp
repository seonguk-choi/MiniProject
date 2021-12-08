<%@page import="java.util.ArrayList"%>
<%@ page import="com.hanul.DTO.AnswerDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
ArrayList<Integer> list = new ArrayList<Integer>();
for(int i=0; i<10; i++){
	list.add(i);
}

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
</div>
</body>
</html>