package com.hanul.DAO;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hanul.DTO.AnswerDTO;
import com.hanul.DTO.StudentDTO;
import com.hanul.DTO.TimerDTO;

public class AnswerDAO {
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

	//전체답안 검색
	public List<AnswerDTO> answerSearchAll() {
		SqlSession session = sqlMapper.openSession();
		List<AnswerDTO> list = null;
		list = session.selectList("answerSearchAll");
		return list;
	}
	//loginCheck1
	public int loginCheck1(int std_code) {
		SqlSession session = sqlMapper.openSession();
		int cnt = 0;
		cnt = session.selectOne("loginCheck1", std_code);
		session.close();
		return cnt;
	}//loginCheck1()
	
	//loginCheck2
	public StudentDTO loginCheck2(int std_code) {
		SqlSession session = sqlMapper.openSession();
		int cnt = 0;
		StudentDTO dto = session.selectOne("loginCheck2", std_code);
		session.close();
		return dto;
	}//loginCheck2()
	
	//수험생 등록
		public int studentInsert(StudentDTO dto) {
			//SqlSessionFactory(sqlMapper)에서 session 활성화
			SqlSession session = sqlMapper.openSession();
			
			int succ = 0;	//성공여부 판단
			
			//insert 작업(SQL문장작성) → Mapper.xml
			succ = session.insert("studentInsert", dto);
			
			session.commit();	//커밋명령
			
			session.close();	//session 종료
			
			return succ;		//결과를 리턴		
		}//memberInsert()
		
		//전체수험생 목록검색
		public List<StudentDTO> studentSearchAll() {
			SqlSession session = sqlMapper.openSession();
			List<StudentDTO> list = null;
			list = session.selectList("studentSearchAll");
			session.close();
			return list;
		}//studentSearchAll()

		//수험생정보 검색
		public StudentDTO getById(int std_code) {
			SqlSession session = sqlMapper.openSession();
			StudentDTO dto = null;
			dto = session.selectOne("getById", std_code);
			session.close();
			return dto;
		}//getById()
		
		//수험생 정보 수정
		public int studentUpdate(StudentDTO dto) {
			SqlSession session = sqlMapper.openSession();
			int succ = 0;
			succ = session.update("studentUpdate", dto);
			session.commit();
			session.close();
			return succ;
		}//memberUpdate()
		
		//수험생 정보 삭제
		public int studentDelete(String sdt_code) {
			SqlSession session = sqlMapper.openSession();
			int succ = 0;
			succ = session.delete("studentDelete", sdt_code);
			session.commit();
			session.close();
			return succ;
		}//studentDelete()

		public ArrayList<AnswerDTO> studentAnswer() {
			ArrayList<AnswerDTO> list = new ArrayList<>();
			for(int i = 0 ; i < 10 ; i++) {
				list.add(new AnswerDTO(1));
			}
			return list;
		}

	
}



