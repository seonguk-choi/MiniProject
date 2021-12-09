package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.StudentDTO;

public class StudentGradeFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트의 요청
				request.setCharacterEncoding("utf-8");
				StudentDTO dto = new StudentDTO();
				int std_code = Integer.parseInt(request.getParameter("std_code"));
				
				// 비지니스 로직
				OmrDAO dao = new OmrDAO();
				dto = dao.loginCheck2(std_code);
				
				//프리젠테이션 수행
				response.setContentType("text/html;charset=utf-8");	
				request.setAttribute("dto", dto);
				
				ActionForward forward = new ActionForward();
				forward.setPath("jsp/studentGrade.jsp");	
				forward.setRedirect(false);	
				return forward;
	}

}
