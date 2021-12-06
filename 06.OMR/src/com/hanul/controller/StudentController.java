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
import com.hanul.DTO.TimerDTO;

@WebServlet("*.bo")
public class StudentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		OmrDAO dao = new OmrDAO();
		StudentDTO dto = new StudentDTO();
		TimerDTO dtot = new TimerDTO();
		
		if(request.getServletPath().equals("/studentExam.bo")) {
			dto = dao.studentExam(1001);
			dtot = dao.timerExam();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/studentExam.jsp");
			request.setAttribute("dto", dto);
			request.setAttribute("dtot", dtot);
			rd.forward(request,response);
		} else if(request.getServletPath().equals("/login.bo")) {
			dto = dao.studentLogin(dto);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/Login.jsp");
			request.setAttribute("dto", dto);
			rd.forward(request,response);
		}
	}
}
