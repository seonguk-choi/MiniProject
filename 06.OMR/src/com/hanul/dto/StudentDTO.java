package com.hanul.dto;

public class StudentDTO {
	String name;
	int std_code;
	int score;
	int result;
	String apply;
	String manager;
	
	
	
	public StudentDTO() {
		super();
	}

	public StudentDTO(String name, int std_code, int score, int result, String apply, String manager) {
		super();
		this.name = name;
		this.std_code = std_code;
		this.score = score;
		this.result = result;
		this.apply = apply;
		this.manager = manager;
	}
	
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
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
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
	
}
