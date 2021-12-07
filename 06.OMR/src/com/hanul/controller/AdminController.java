package com.hanul.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.StudentDTO;

@WebServlet("*.co")
public class AdminController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트가 어떤 요청을 하였는지를 파악
		request.setCharacterEncoding("utf-8");
		

		//System.out.println("uri : " + uri);				//출력값 : /mbb/boardList.do
		//System.out.println("ctx : " + ctx);				//출력값 : /mbb
		//System.out.println("command : " + command);		//출력값 : /boardList.do
		//list.add(new StudentDTO("nav" ,2, 2 ,"a" , "a" , "a"));
		
		
		//2. 클라이언트의 요청(*.do : command)과 실제 처리할 Action Class(비지니스 로직) 연결 ▶ BoardxxxAction.java
		if(request.getServletPath().equals("/adminList.do")) {		//StudentList page를 응답하는 로직
			//데이터 조회하고 req.set("list" , list);
			OmrDAO dao = new OmrDAO();
			List<StudentDTO> list = dao.studentSearchAll();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/adminList.jsp");//내가 이동할 페이지 경로
			request.setAttribute("list", list);
			rd.forward(request,response);
		}
	}		
}
