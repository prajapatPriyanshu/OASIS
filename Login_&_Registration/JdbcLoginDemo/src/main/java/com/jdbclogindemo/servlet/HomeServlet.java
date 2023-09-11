package com.jdbclogindemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
		
		String uname = (String) 
				session.getAttribute("USERNAME");
		String sid = session.getId();
		
		pw.println("<!DOCTYPE html><html><head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		pw.println("<title>Welcome"+uname+"</title> ");
		pw.println("<link rel=\"stylesheet\" href=\".\\src\\main\\java\\com\\jdbclogindemo\\servlet\\style.css\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css\"/>");
		pw.println("</head><body><nav>");
		pw.println("<div class=\"menu\"><div class=\"logo\">");
		pw.println("<a href=\"#\">Welcome!</a></div>");
		pw.println("<div class=\"btns\"><a href=\"logout\"><button>LOGOUT</button></a>");
		pw.println("</div></div></nav><div class=\"center\">");
		pw.println("<div class=\"title\">Welcome "+uname+" , to your home page </div>");
		pw.println("<div class=\"sub_title\">Your session id "+ " : " + sid + "</div>");
		pw.println("</div></body>");
		pw.println("<style>@import url(\"https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap\");");
		pw.println("*{margin: 0;padding: 0;box-sizing: border-box;font-family:'Poppins',sans-serif;}");
		pw.println("body{background-color:bisque;color:black;}");
		pw.println("nav{position: fixed;background: #1b1b1b;width: 100%;padding: 10px 0;z-index: 12;}");
		pw.println("nav .menu{max-width: 1250px;margin: auto;display: flex;align-items: center;justify-content: space-between;padding: 0 20px;}");
		pw.println(".menu .logo a{text-decoration: none;color: #fff;font-size: 35px;font-weight: 600;}");
		pw.println(".center{position: absolute;top: 52%;left: 50%;transform: translate(-50%, -50%);width: 100%;padding: 0 20px;text-align: center;}");
		pw.println(".center .title{font-size: 55px;font-weight: 600;}.center .sub_title{font-size: 42px;font-weight: 600;}.menu .btns{margin-top: 20px;}");
		pw.println(".menu .btns button{height: 55px;width: 170px;border-radius: 5px;border: none;margin: 0 10px;border: 2px solid white;font-size: 20px;");
		pw.println("font-weight: 500;padding: 0 10px;cursor: pointer;outline: none;transition: all 0.3s ease;}");
		pw.println(".btns button:hover{background: rgb(185, 74, 74);color: black;}</style></html>");
		}
		else {
			response.sendRedirect(
					"error?msg=notloggedin");
		}
	}
}




