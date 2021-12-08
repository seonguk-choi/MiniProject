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
import com.hanul.action.AdminInsertAction;
import com.hanul.action.AdminListAction;
import com.hanul.action.AdminUpdateAction;
import com.hanul.action.AdminUpdateFormAction;


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
		
		if (command.equals("/Login.do")) { //로그인
			forward = new ActionForward();
			forward.setPath("jsp/Login.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/LoginAction.do")) { //로그인확인
		
			forward = action.execute(request, response);
		} else if (command.equals("/studentExam.do")) { //시험응시
			
			forward = action.execute(request, response);
		} else if (command.equals("/studentGrade.do")) { //성적확인
		
			forward = action.execute(request, response);
		} else if (command.equals("/studentResult.do")) { //시험결과
		} else if (command.equals("/studentRank.do")) { //등수확인
		//----------------------------------------------------------//
		} else if (command.equals("/adminList.do")) {	//관리자모드
			action = new AdminListAction();
			forward = action.execute(request, response);
		} else if (command.equals("/adminInsert.do")) { //학생등록
			action = new AdminInsertAction();
			forward = action.execute(request, response);
		} else if (command.equals("/adminUpdateForm.do")) { //학생정보수정
			action = new AdminUpdateFormAction();
			forward = action.execute(request, response);
			
		} else if (command.equals("/adminUpdate.do")) { //학생정보수정
			action = new AdminUpdateAction();
			forward = action.execute(request, response);
			
		} else if (command.equals("/adminAnswer.do")) { //답안지수정
			forward = new ActionForward();
			forward.setPath("/adminAnswer.jsp");
			forward.setRedirect(false);
		}
		//----------------------------------------------------------//
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
