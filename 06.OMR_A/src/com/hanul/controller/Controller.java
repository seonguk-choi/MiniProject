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
import com.hanul.action.AdminDeleteAction;
import com.hanul.action.AdminInsertAction;
import com.hanul.action.AdminInsertFormAction;
import com.hanul.action.AdminListAction;
import com.hanul.action.AdminUpdateAction;
import com.hanul.action.AdminUpdateFormAction;
import com.hanul.action.LoginAction;
import com.hanul.action.StudentExamAction;
import com.hanul.action.StudentGradeAction;
import com.hanul.action.StudentGradeFormAction;
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
		} else if (command.equals("/LoginAction.do")) { //로그인확인
			action = new LoginAction();
			forward = action.execute(request, response);
		} else if (command.equals("/studentExam.do")) { //시험응시
			action = new StudentExamAction();
			forward = action.execute(request, response);
		} else if (command.equals("/studentGrade.do")) { //성적로그인확인
			action = new StudentGradeAction();
			forward = action.execute(request, response);
		} else if (command.equals("/studentGradeForm.do")) { //성적확인
			action = new StudentGradeFormAction();
			forward = action.execute(request, response);
		} else if (command.equals("/studentResult.do")) { //시험결과
			action = new StudentResultAction();
			forward = action.execute(request, response);
		} else if (command.equals("/studentRank.do")) { //등수확인
			action = new StudentRankAction();
			forward = action.execute(request, response);
		} else if (command.equals("/adminList.do")) {	//관리자모드
			action = new AdminListAction();
			forward = action.execute(request, response);
		} else if (command.equals("/adminInsertForm.do")) { //학생정보추가화면
			forward = new ActionForward();
			forward.setPath("jsp/adminInsertForm.jsp");
			forward.setRedirect(false);
		}	else if (command.equals("/adminInsert.do")) {	//학생 추가하기
			action = new AdminInsertAction();
			forward = action.execute(request, response);			
		} else if (command.equals("/adminUpdateForm.do")) { //학생 정보 수정화면
			action = new AdminUpdateFormAction();
			forward = action.execute(request, response);
		} else if (command.equals("/adminUpdate.do")) { //학생 정보 수정
			action = new AdminUpdateAction();
			forward = action.execute(request, response);
		} else if(command.equals("/adminDelete.do")) {	//학생 정보 삭제
			action = new AdminDeleteAction();
			forward = action.execute(request, response);
		} else if (command.equals("/adminAnswer.do")) { //답안지수정
			forward = new ActionForward();
			forward.setPath("/adminAnswer.jsp");
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
