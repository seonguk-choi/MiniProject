package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.AnswerDTO;
import com.hanul.DTO.StudentDTO;

public class StudentExamAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int std_code = Integer.parseInt(request.getParameter("std_code"));
			// 비지니스 로직
			OmrDAO dao = new OmrDAO();
			StudentDTO dto = dao.loginCheck2(std_code);
			ArrayList<AnswerDTO> list = dao.studentAnswer();
			
			
			dto.setApply("YES");
			dao.studentUpdate2(dto);
			dto = dao.loginCheck2(std_code);	
			//프리젠테이션 수행
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			int time;
			time=(dao.timeSerch1()*60);//분 계산[분 > 초로 변환]
			time=(time+dao.timeSerch2());//초 합치기
			
			request.setAttribute("list", list);
			request.setAttribute("dto", dto);
			request.setAttribute("time", time);
			
			ActionForward forward = new ActionForward();
			forward.setPath("jsp/studentExam.jsp");	
			forward.setRedirect(false);	
			return forward;
	}

}
