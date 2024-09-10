package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api")
public class ThirdHttpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = req.getParameter("message");
		System.out.println(message);
//		res.getWriter().println(message);
		
		//sending Response
//		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		
		Date date = new Date()
;		writer.println("<h1>Form submitted</h1>");
		writer.print("""
					<h2>Message : %s</h2>
					<p>Date : %s</p>
				""".formatted(message, date));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().println("<h1>Hello, World!</h1>");
		System.out.println("Service request from Http servlet");
		
	}
	
	
}
