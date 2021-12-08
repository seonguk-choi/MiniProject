package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.StudentDTO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트의 요청
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		StudentDTO dto = new StudentDTO();
		String name = request.getParameter("name");
		int std_code = Integer.parseInt(request.getParameter("code"));
		System.out.println(name);
		System.out.println(std_code);
		int cnt = 0; 
		// 비지니스 로직
		PrintWriter out = response.getWriter();
		OmrDAO dao = new OmrDAO();
		cnt = dao.loginCheck1(std_code);
		
		if (cnt == 0 ) {
			out.println("<script>alert('등록완료!');</script>");
			forward.setPath("jsp/Login.jsp");
		} else if(cnt > 0) {
			dto = dao.loginCheck2(std_code);
			if (dto.getName().equals(name) && dto.getManager().equals("N")) {
				out.println("<script>alert('시험응시를 시작합니다.');");
				forward.setPath("jsp/studentExam.jsp");
			} else if (dto.getName().equals(name) && dto.getApply().equals("YES")) {
				out.println("<script>alert('이미 응시 하였습니다.');");
				forward.setPath("jsp/adminList.jsp");
			} else if (dto.getName().equals(name) && dto.getManager().equals("Y")) {
				out.println("<script>alert('관리자 모드로 이동합니다.');");
				forward.setPath("jsp/adminList.jsp");
			} else {
				out.println("<script>alert('이름 또는 수험번호가 잘 못 되었습니다.');");
				forward.setPath("jsp/Login.jsp");
			}
		} else {
			out.println("<script>alert('이름 또는 수험번호가 잘 못 되었습니다.');");
			forward.setPath("jsp/Login.jsp");
		}
		
		forward.setRedirect(false);
		return forward;

		StudentDTO dto = new StudentDTO();
		String name = request.getParameter("name");
		int std_code = Integer.parseInt(request.getParameter("code"));
		int cnt = 0; 
		
		// 비지니스 로직
		OmrDAO dao = new OmrDAO();
		cnt = dao.loginCheck1(std_code);
		
		//프리젠테이션 수행
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		if (cnt == 0 ) {
			out.println("<script>alert('이름 또는 수험번호가 잘 못 되었습니다.');");
			out.println("location.href='Login.do';</script>");
		} else if(cnt > 0) {
			dto = dao.loginCheck2(std_code);
			if (dto.getName().equals(name) && dto.getApply().equals("NO")) {
				out.println("<script>alert('시험응시를 시작합니다.');");
				out.println("location.href='studentExam.do?std_code="+dto.getStd_code()+"';</script>");
			} else if (dto.getName().equals(name) && dto.getManager().equals("Y")) {
				out.println("<script>alert('관리자 모드로 이동합니다.');");
				out.println("location.href='adminList.do?std_code="+dto.getStd_code()+"';</script>");
			} else if (dto.getName().equals(name) && dto.getApply().equals("YES")) {
				out.println("<script>alert('이미 응시 하였습니다.');");
				out.println("location.href='Login.do';</script>");				
			}  else {
				out.println("<script>alert('이름 또는 수험번호가 잘 못 되었습니다.');");
				out.println("location.href='Login.do';</script>");				
			}
		} else {
			out.println("<script>alert('이름 또는 수험번호가 잘 못 되었습니다.');");
			out.println("location.href='Login.do';</script>");
		}
		return null;
	}

}
