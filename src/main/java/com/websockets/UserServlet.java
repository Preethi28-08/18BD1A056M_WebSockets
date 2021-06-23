package com.websockets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@=Annotations help to associate metadata (information) to the program elements 
//i.e. instance variables, constructors, methods, classes, etc.
@WebServlet("/login")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RequestDispatcher rd;
	//Defines an object(rd) that receives requests from 
	//the client and sends them to any resource 
	//(such as a servlet, HTML file, or JSP file) on the server.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();

		HttpSession session=request.getSession(true);
		//session to track username
		String username=request.getParameter("username");
		session.setAttribute("username",username);

		if(username!=null && username.equals("doctor"))
		{
			rd=request.getRequestDispatcher("/doctor.jsp");
			rd.forward(request,response);
		}
		else if(username!=null && username.equals("ambulance"))
		{
			rd=request.getRequestDispatcher("/ambulance.jsp");
			rd.forward(request, response);
		}
		else if(username!=null)
		{
			rd=request.getRequestDispatcher("/patient.jsp");
			rd.forward(request, response);
		}
	}
}