package com.hanul.DTO;

import java.io.Serializable;

public class StudentDTO implements Serializable{
	
	//필드 선언
	private String name		;  //varchar2(20 byte)
	private int std_code	;  //number
	private int score		;  //number(4,0)
	private String result	;  //varchar2(4 byte)
	private String apply	;  //varchar2(4 byte)
	private String manager	;  //varchar2(4 byte)
	private int rank		; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStd_code() {
		return std_code;
	}
	public void setStd_code(int std_code) {
		this.std_code = std_code;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getApply() {
		return apply;
	}
	public void setApply(String apply) {
		this.apply = apply;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
