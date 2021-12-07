package com.hanul.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.AnswerDAO;
import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.AnswerDTO;
import com.hanul.DTO.StudentDTO;
import com.hanul.DTO.TimerDTO;

@WebServlet("*.bo")
public class StudentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		OmrDAO dao = new OmrDAO();
		AnswerDAO dao_answer = new AnswerDAO();
		StudentDTO dto = null;
		TimerDTO dtot = new TimerDTO();
		AnswerDTO dto_answer = new AnswerDTO();
		
		if(request.getServletPath().equals("/studentExam.bo")) {
			dto = dao.studentExam(1001);
			dtot = dao.timerExam();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/studentExam.jsp");
			request.setAttribute("dto", dto);
			request.setAttribute("dtot", dtot);
			rd.forward(request,response);
		} else if(request.getServletPath().equals("/studentGrade.bo")) {
			dto = dao.studentExam(1001);
			dtot = dao.timerExam();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/studentExam.jsp");
			request.setAttribute("dto", dto);
			request.setAttribute("dtot", dtot);
			rd.forward(request,response);
		}else if(request.getServletPath().equals("/studentResult.bo")) { //채점
			RequestDispatcher rd = request.getRequestDispatcher("jsp/studentResult.jsp"); 
			List<AnswerDTO> list = dao_answer.answerSearchAll();
			Random random = new Random();
			dto_answer.setAnswer(random.nextInt(4)+1);
			List<AnswerDTO> list_test = new ArrayList<>();
					for (int i = 0; i <= 9; i++) {
						list_test.add(dto_answer);
						dto_answer.setAnswer(random.nextInt(4)+1);
					}
			request.setAttribute("list", list_test); //학생OMR
			request.setAttribute("list2", list);
			rd.forward(request,response);
		}else if(request.getServletPath().equals("/studentRank.bo")) { //등수
			//임시로 만든 값
			int num=1001;
			int sc=30;
			int ranking=4;
			
			dao.studentScore(num, sc); //점수 업데이트코드 dao/ mapper 미완성... 돌아는가는데 값안바뀜
			ranking = dao.studentRank(sc); //랭킹 확인[점수넣어야함]
			RequestDispatcher rd = request.getRequestDispatcher("jsp/studentRank.jsp");
			request.setAttribute("std_code", num); 
			request.setAttribute("score", sc);
			request.setAttribute("rank", ranking); 
			rd.forward(request,response);
	}
}
}
