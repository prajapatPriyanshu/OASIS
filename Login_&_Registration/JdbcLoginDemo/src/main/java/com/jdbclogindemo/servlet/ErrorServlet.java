package com.jdbclogindemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String param = request.getParameter("msg");
		String message = "";
		String pageUrl = "";
		
		switch(param) {
		case "loginerror":
			message = "Invalid Login Credentials";
			pageUrl = "login.html";
			break;
		case "regerror":
			message = "Registration Failed, Try Again";
			pageUrl = "register.html";
			break;
		case "notloggedin":
			message = "You Need To Login First";
			pageUrl = "login.html";
			break;	
		}
		
		pw.println("<div class=\"notification\" id=\"loading-notification\">"+message+"</div>");
		pw.println("<style>.notification{position: fixed;top:0;left:0;width: 100%;background-color: #f5f5f5;color:red;padding:10px;text-align: center;display:none;}</style>");
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageUrl);
		dispatcher.include(request, response);
	}
}





