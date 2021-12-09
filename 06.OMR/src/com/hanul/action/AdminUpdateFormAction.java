package com.hanul.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.StudentDTO;

public class AdminUpdateFormAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServerException, IOException {
		//클라이언트의 요청
		request.setCharacterEncoding("utf-8");
		int std_code = Integer.parseInt(request.getParameter("std_code"));
		
		//비지니스 로직
		OmrDAO dao = new OmrDAO();
		StudentDTO dto = dao.getById(std_code);
		request.setAttribute("dto", dto);
		
		//프리젠테이션 로직
		ActionForward forward = new ActionForward();
		forward.setPath("jsp/adminUpdateForm.jsp");
		forward.setRedirect(false);		
		return forward;
	
	}
}
