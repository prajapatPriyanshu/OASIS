package com.jdbclogindemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {

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
		case "regsuccess":
			message = "Registration Successful";
			pageUrl = "login.html";
			break;
		case "logoutsuccess":
			message = "Logged Out Successfully";
			pageUrl = "login.html";
			break;	
		}
		
		pw.println("<div class=\"notification\" id=\"loading-notification\">"+message+"</div>");
		pw.println("<style>.notification{position: fixed;top:0;left:0;width: 100%;background-color: #f5f5f5;color: green;padding:10px;text-align: center;display:none;}</style>");
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageUrl);
		dispatcher.include(request, response);
	}
}





