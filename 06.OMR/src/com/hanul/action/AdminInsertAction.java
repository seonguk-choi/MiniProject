package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.StudentDTO;


public class AdminInsertAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//클라이언트의 요청을 받는다 : 매개변수를 가져온다 → BoardDTO Type으로 묶어준다.
	
		request.setCharacterEncoding("utf-8");
		StudentDTO dto = new StudentDTO();
		dto.setName(request.getParameter("name"));
		dto.setStd_code(Integer.parseInt(request.getParameter("std_code")));
		dto.setScore(Integer.parseInt(request.getParameter("score")));
		dto.setResult(request.getParameter("result"));
		dto.setApply(request.getParameter("apply"));
		dto.setManager(request.getParameter("manager"));
		dto.setRank(Integer.parseInt(request.getParameter("rank")));
		
		//비지니스 로직 : DAO 연동하여 글을 등록하는 작업
		OmrDAO dao = new OmrDAO();
		int succ = dao.studentInsert(dto);
		
		//프리젠테이션 로직 : alert 창을 사용 → out.println();
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		forward.setPath("jsp/adminInsert.jsp");
		forward.setRedirect(false);		
	
		if(succ > 0) {
			out.println("<script>alert('등록완료!');");
			out.println("location.href='adminList.do';</script>");
		}else {
			out.println("<script>alert('등록실패!');");
			out.println("location.href='adminList.do';</script>");
		}
		return forward;	
	}
}
