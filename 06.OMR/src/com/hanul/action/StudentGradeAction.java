package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.StudentDTO;

public class StudentGradeAction implements Action {

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
		// 비지니스 로직
		PrintWriter out = response.getWriter();
		OmrDAO dao = new OmrDAO();
		int cnt = dao.loginCheck1(std_code);
		
		//프레젠테이션 로
		if (cnt == 0) {
			out.println("<script>alert('이름 또는 수험번호가 잘 못 되었습니다.');");
			forward.setPath("jsp/Login.jsp");
			forward.setRedirect(false);
			return forward;
		} else if (cnt == 1) {
			dto = dao.loginCheck2(std_code);
			if (dto.getName().equals(name) && dto.getApply().equals("NO")) {
				out.println("<script>alert('아직 응시하지 않았습니다.');");
				forward.setPath("jsp/Login.jsp");
				forward.setRedirect(false);
				return forward;
			} else if (dto.getName().equals(name) && dto.getApply().equals("YES")) {
				forward.setPath("jsp/studentGrade.jsp");
				forward.setRedirect(false);
				return forward;
			} else if (dto.getName().equals(name) && dto.getManager().equals("Y")) {
				out.println("<script>alert('관리자 모드로 이동합니다.');");
				forward.setPath("jsp/adminList.jsp");
				forward.setRedirect(false);
				return forward;

			} else {
				out.println("<script>alert('이름 또는 수험번호가 잘 못 되었습니다.');");
				forward.setPath("jsp/Login.jsp");
				forward.setRedirect(false);
				return forward;
			}
		} else {
			out.println("<script>alert('이름 또는 수험번호가 잘 못 되었습니다.');");
			forward.setPath("jsp/Login.jsp");
			forward.setRedirect(false);
			return forward;
		}
	}

}
