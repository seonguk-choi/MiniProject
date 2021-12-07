package com.hanul.DTO;

import java.io.Serializable;

public class AnswerDTO implements Serializable {
	private int answer;
	
	public AnswerDTO() {
		super();
	}

	public AnswerDTO(int answer) {
		super();
		this.answer = answer;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	
}
