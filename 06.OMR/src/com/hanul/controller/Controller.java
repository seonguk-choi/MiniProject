package com.hanul.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.action.Action;
import com.hanul.action.ActionForward;
import com.hanul.action.LoginAction;
import com.hanul.action.StudentRankAction;
import com.hanul.action.StudentResultAction;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());

		Action action = null;
		ActionForward forward = null;
		
		if (command.equals("/login.do")) { //로그인
			forward = new ActionForward();
			forward.setPath("jsp/Login.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/LoginAction.do")) { //시험응시
			action = new LoginAction();
			forward = action.execute(request, response);
		} else if (command.equals("/studentGrade.do")) { //시험응시
			action = new LoginAction();
			forward = action.execute(request, response);
		} else if (command.equals("/studentResult.do")) { //시험결과
			action = new StudentResultAction();
			forward = action.execute(request, response);
		} else if (command.equals("/studentRank.do")) { //등수확인
			action = new StudentRankAction();
			forward = action.execute(request, response);
		} else if (command.equals("/adminList.do")) {	//관리자모드
			
		} else if (command.equals("/adminRegister.do")) { //학생등록
			forward = new ActionForward();
			forward.setPath("jsp/adminRegister.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/adminCorrection.do")) { //학생정보수정
			forward = new ActionForward();
			forward.setPath("jsp/adminCorrection.jsp");
			forward.setRedirect(false);
			forward = action.execute(request, response);
		} else if (command.equals("/adminAnswer.do")) { //답안지수정
			forward = new ActionForward();
			forward.setPath("jsp/adminAnswer.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/adminTimer.do")) { //시간 수정
			forward = new ActionForward();
			forward.setPath("jsp/adminTimer.jsp");
			forward.setRedirect(false);
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else { // false : forward()
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		} // if
	}// service()
}// class
