package com.hanul.DTO;

import java.io.Serializable;

public class TimerDTO implements Serializable {
	private int minutes, seconds;

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	
	
	
}
