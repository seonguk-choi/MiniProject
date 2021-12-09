
<%@page import="com.hanul.DAO.OmrDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int std_code = Integer.parseInt(request.getParameter("std_code"));
OmrDAO dao = new OmrDAO();
int succ = dao.studentDelete(std_code);

if (succ > 0) {
	out.println("<script>alert('삭제성공!');");
	out.println("location.href='adminList.jsp';</script>");
}else {
	out.println("<script>alert('삭제실패!');");
	out.println("location.href='adminList.jsp';</script>");
}
%>