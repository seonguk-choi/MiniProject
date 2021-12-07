package com.hanul.DAO;

import java.io.InputStream;
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
	
	//전체회원 목록검색
	public List<AnswerDTO> answerSearchAll() {
		SqlSession session = sqlMapper.openSession();
		List<AnswerDTO> list = null;
		list = session.selectList("answerSearchAll");
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



