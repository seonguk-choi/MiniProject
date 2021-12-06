package com.hanul.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hanul.DTO.StudentDTO;
import com.hanul.DTO.TimerDTO;

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
	
	//수험생 등록
	public int memberInsert(StudentDTO dto) {
		//SqlSessionFactory(sqlMapper)에서 session 활성화
		SqlSession session = sqlMapper.openSession();
		
		int succ = 0;	//성공여부 판단
		
		//insert 작업(SQL문장작성) → Mapper.xml
		succ = session.insert("sdInsert", dto);
		
		session.commit();	//커밋명령
		
		session.close();	//session 종료
		
		return succ;		//결과를 리턴		
	}//memberInsert()
	
	//전체회원 목록검색
	public List<StudentDTO> studentSearchAll() {
		SqlSession session = sqlMapper.openSession();
		List<StudentDTO> list = null;
		list = session.selectList("studentSearchAll");
		session.close();
		return list;
	}//studentSearchAll()
	
	
	//StudentExam
	public StudentDTO studentExam(int std_code) {
		SqlSession session = sqlMapper.openSession();
		StudentDTO dto = null;
		dto = session.selectOne("studentExam", std_code);
		session.close();
		return dto;
	}//studentExam()
	
	//TimerExam
	public TimerDTO timerExam() {
		SqlSession session = sqlMapper.openSession();
		TimerDTO dtot = null;
		dtot = session.selectOne("timerExam");
		session.close();
		return dtot;
	}//tiemrExam()

	
	
	
}



