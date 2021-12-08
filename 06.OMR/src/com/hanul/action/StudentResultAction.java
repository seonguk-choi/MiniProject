package com.hanul.action;

import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
=======
import java.util.ArrayList;
>>>>>>> origin/CSU

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.hanul.DAO.AnswerDAO;
import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.AnswerDTO;
import com.hanul.DTO.StudentDTO;

public class StudentResultAction implements Action {
=======
import com.hanul.DAO.OmrDAO;
import com.hanul.DTO.AnswerDTO;

public class StudentResultAction implements Action{
>>>>>>> origin/CSU

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
		//클라이언트의 요청을 받는다 : 매개변수를 가져온다 → BoardDTO Type으로 묶어준다.
		request.setCharacterEncoding("utf-8");
		StudentDTO dto = new StudentDTO();
		dto.setName("길동이");
		dto.setStd_code(1004);
	//	dto.setName(request.getParameter("name"));
	//	dto.setStd_code(Integer.parseInt(request.getParameter("code")));
		//가져온다! list로 만든 omr카드
		
		AnswerDAO dao = new AnswerDAO(); //작성자 정보
		List<AnswerDTO> list2 = dao.answerSearchAll(); //답안
		//test용 수험자 채점지
		Random random = new Random();
		AnswerDTO dto_answer = new AnswerDTO();
		dto_answer.setAnswer(random.nextInt(4)+1);
		List<AnswerDTO> list_test = new ArrayList<>();
				for (int i = 0; i <= 9; i++) {
					list_test.add(dto_answer);
					dto_answer.setAnswer(random.nextInt(4)+1);
				}
		request.setAttribute("list", list_test);
		//
		request.setAttribute("list2", list2);	//바인딩(연결) 객체 생성
		request.setAttribute("dto", dto);	//바인딩(연결) 객체 생성
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("jsp/studentResult.jsp");
		forward.setRedirect(false);		
=======
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
>>>>>>> origin/CSU
		return forward;
	}

}
