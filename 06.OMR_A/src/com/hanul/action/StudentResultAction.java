package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.AnswerDTO;
import com.hanul.DTO.StudentDTO;

public class StudentResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//클라이언트의 요청
		request.setCharacterEncoding("utf-8");
		StudentDTO dto = new StudentDTO();
		dto.setName(request.getParameter("name"));
		dto.setStd_code(Integer.parseInt(request.getParameter("std_code")));
		
		//가져온다! list로 만든 omr카드	
		OmrDAO dao = new OmrDAO();
		ArrayList<Integer> list1 = new ArrayList<>();
		List<AnswerDTO> list2 = dao.answerSearchAll(); //정답지 불러오기

		request.setCharacterEncoding("utf-8");
		ArrayList<AnswerDTO> list = new ArrayList<>(); //학생답안지
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q1"))));
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q2"))));
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q3"))));
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q4"))));
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q5"))));
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q6"))));
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q7"))));
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q8"))));
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q9"))));
		list.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q10"))));

		request.setAttribute("list", list); //학생답안지
		request.setAttribute("list1", list1);	
		request.setAttribute("list2", list2); //정답지 불러오기
		request.setAttribute("dto", dto);	


		
		ActionForward forward = new ActionForward();
		forward.setPath("jsp/studentResult.jsp");	
		forward.setRedirect(false);	
		return forward;
	}

}
