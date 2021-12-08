package com.hanul.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.AnswerDTO;

public class StudentResultAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		OmrDAO dao = new OmrDAO();
		ArrayList<AnswerDTO> lista = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0 ; i <10 ; i++) {
			lista.add(new AnswerDTO(Integer.parseInt(request.getParameter("Q"+i))));
		}
		System.out.println(lista.get(1).getAnswer());
		
		ActionForward forward = new ActionForward();
		forward.setPath("jsp/studentResult.jsp");	
		forward.setRedirect(false);	
		return forward;
	}

}
