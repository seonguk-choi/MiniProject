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

public class StudentRankAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//클라이언트의 요청을 받는다 : 매개변수를 가져온다 → BoardDTO Type으로 묶어준다.
		request.setCharacterEncoding("utf-8");
		StudentDTO dto = new StudentDTO();
		dto.setScore(Integer.parseInt(request.getParameter("score")));//점수값
		dto.setName(request.getParameter("name"));
		dto.setStd_code(Integer.parseInt(request.getParameter("code")));
		
		int score = dto.getScore();
		int std_code = dto.getStd_code();
		
		OmrDAO dao = new OmrDAO(); 
		dao.studentScore(std_code, score); //점수 수정
		int rank = dao.studentRank(score);  //랭킹 정보 넣기
		
		request.setAttribute("rank", rank);	//바인딩(연결) 객체 생성
		request.setAttribute("dto", dto);	//바인딩(연결) 객체 생성
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("jsp/studentRank.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
