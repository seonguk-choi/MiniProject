
<%@page import="com.hanul.DAO.OmrDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
OmrDAO dao = new OmrDAO();
int succ = dao.studentDelete(id);

if (succ > 0) {
	out.println("<script>alert('삭제성공!');");
	out.println("location.href='adminList.jsp';</script>");
}else {
	out.println("<script>alert('삭제실패!');");
	out.println("location.href='adminList.jsp';</script>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete JSP</title>
</head>
<body>

</body>
</html>