package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.DTO.StudentDTO;

public class AdminInsertAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		return null;	//ActionForward가 필요하지 않는다.
	}
}
