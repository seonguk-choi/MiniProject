package com.hanul.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.StudentDTO;

public class AdminUpdateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServerException, IOException {
		//클라이언트의 요청
		request.setCharacterEncoding("utf-8");
		StudentDTO dto = new StudentDTO();
		dto.setName(request.getParameter("name"));
		dto.setStd_code(Integer.parseInt(request.getParameter("std_code")));
		dto.setScore(Integer.parseInt(request.getParameter("score")));
		dto.setResult(request.getParameter("result"));
		dto.setApply(request.getParameter("apply"));
		dto.setManager(request.getParameter("manager"));
		
		
		//비지니스 로직
		OmrDAO dao = new OmrDAO();
		dao.studentUpdate1(dto);
		
		//프리젠테이션 로직
		ActionForward forward = new ActionForward();
		forward.setPath("adminList.do");
		forward.setRedirect(false);
		return forward;
	}
}

















