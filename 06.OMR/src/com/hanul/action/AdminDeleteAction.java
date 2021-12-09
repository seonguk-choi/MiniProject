package com.hanul.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;


public class AdminDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//클라이언트 요청
		request.setCharacterEncoding("utf-8");
		int std_code = Integer.parseInt(request.getParameter("std_code"));
		
		//비지니스 로직
		OmrDAO dao = new OmrDAO();
		dao.studentDelete(std_code);
		
		//프리젠테이션 로직
		ActionForward forward = new ActionForward();
		forward.setPath("adminList.do");
		forward.setRedirect(true);	//true : sendRedirect() 페이지 전환 → url 변경된다.		
		return forward;
	}
}
