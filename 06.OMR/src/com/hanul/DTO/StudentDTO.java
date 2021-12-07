package com.hanul.DTO;

import java.io.Serializable;

public class StudentDTO implements Serializable{
	private String name     ;
	private int	   std_code ;
	private int	   score    ;
	private String result   ;
	private String apply    ;
	private String manager  ;
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
	
	
	
	
}
