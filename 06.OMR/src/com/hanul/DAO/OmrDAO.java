package com.hanul.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hanul.DTO.StudentDTO;
import com.hanul.dto.BoardDTO;
import com.hanul.dto.SearchDTO;

public class OmrDAO {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			String resource = "com/hanul/mybatis/SqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SqlSessionFactory Exception!!!");
		}
	}//초기화 블럭
	
	//회원 가입
		public int login(StudentDTO dto) {
			//SqlSessionFactory(sqlMapper)에서 session 활성화
			SqlSession session = sqlMapper.openSession();
			int succ = 0;
			succ = session.insert("login", dto); //insert SQL insert 쿼리 : Mapper.xml
			session.commit();	//커밋
			session.close();	//session 비활성화
			return succ;
		} //login()

		//수험생 체크
		loginCheck
		public StudentDTO studentLogin(StudentDTO dto) {
			SqlSession session = sqlMapper.openSession();  //session 활성화
			//mybatis에서는 arraylist가 아닌 list를 사용한다
			//파라미터에 식별자 이름을 적는다. 
			
			dto = (StudentDTO) session.selectList("studentLogin", dto);// mapper로 StudentDTO 값을 넘김
			session.close();
			return dto;


			//② 비지니스 로직
			BookDAO dao = new BookDAO();
			
			-------------------controller
			
			
			int cnt = dao.checkIsbn(dto);
			
			//③ 프리젠테이션 로직
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			if(cnt>0) {
				out.println("<script>alert('수험자번호 중복!!!'); location.href='javascript:history.go(-1);';</script>");
			} else {	
				int succ = dao.insertBook(dto);
				if(succ > 0) {
					out.println("<link rel='stylesheet' href='style.css' />");
					out.println("<div class='bg'>");
					out.println("<video muted autoplay loop>");
					out.println("<source src='rem.mp4' type='video/mp4'></video>");
					out.println("<div class='text'>");
					out.println("<script>alert('도서목록 입력성공!!!');</script>");
					out.println("<div class=wrapper><a href='bookMain.html'>도서정보 입력하기</a>");
					out.println("<br/>");
					out.println("<a href='gals.do'>전체도서 목록보기</a></div>");
					out.println("</div>");
					out.println("</div>");
				}else {
					out.println("<link rel='stylesheet' href='style.css' />");
					out.println("<div class='bg'>");
					out.println("<video muted autoplay loop>");
					out.println("<source src='rem.mp4' type='video/mp4'></video>");
					out.println("<div class='text'>");
					out.println("<script>alert('도서목록 입력실패!!!');</script>");
					out.println("<div class=wrapper><a href='bookMain.html'>도서정보 입력하기</a>");
					out.println("<br/>");
					out.println("<a href='gals.do'>전체도서 목록보기</a></div>");
					out.println("</div>");
					out.println("</div>");
				}
			}		
		}
	}

