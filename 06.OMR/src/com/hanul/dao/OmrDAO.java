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
	}//studentExam()
	
	//TimerExam
	public TimerDTO timerExam() {
		SqlSession session = sqlMapper.openSession();
		TimerDTO dtot = null;
		dtot = session.selectOne("timerExam");
		session.close();
		return dtot;
	}//tiemrExam()
	
	public void studentScore(int std_code,int score) { //점수 업데이트 
		SqlSession session = sqlMapper.openSession();
		StudentDTO dto = new StudentDTO();
		dto.setStd_code(std_code);
		dto.setScore(score);
		session.update("studentUpdate_score", dto);
		session.commit();	
		session.close();
	}
	public int studentRank(int score) { //등수 확인
		int rank= 1;
		SqlSession session = sqlMapper.openSession();
		rank = session.selectOne("studentRank", score);
		session.close();
		return rank+1;
	}
}