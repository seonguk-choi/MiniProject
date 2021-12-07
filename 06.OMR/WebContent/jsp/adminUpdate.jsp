
<%@page import="com.hanul.DAO.OmrDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="com.hanul.DTO.StudentDTO">
	<jsp:setProperty property="*" name="dto"/>
</jsp:useBean>

<%
OmrDAO dao = new OmrDAO();
int succ = dao.studentUpdate(dto);

if (succ > 0) {
	out.println("<script>alert('수정완료!');");
	out.println("location.href='adminList.jsp';</script>");
} else {
	out.println("<script>alert('수정실패!');");
	out.println("location.href='adminList.jsp';</script>");
}
%>
