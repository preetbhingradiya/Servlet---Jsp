package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//@WebServlet("/form")
//use of servlet in web.xml
public class FeedbackServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		//Get data
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String message = req.getParameter("text");
		
		res.setContentType("text/html");
		
		PrintWriter writer = res.getWriter();
		
		//connection to postgres 

		try {
			Class.forName("org.postgresql.Driver");
			
			Servletconnection conne = new Servletconnection();
			boolean isExitUser = conne.exitUser(email, phone);
			if(!isExitUser) {
				int feedbackId = conne.inserData(email, phone, message);
				
                if (feedbackId != -1) { // Check if ID is valid
                   
                    Cookie cookie = new Cookie("userId", Integer.toString(feedbackId));
                    cookie.setMaxAge(10 * 60); // Set the cookie to expire in 10 minute
                    cookie.setPath("/"); // Set the cookie to be accessible by all pages in the application
                    res.addCookie(cookie);
                    
                    //Store the session id
                    HttpSession session = req.getSession();
                    session.setAttribute("userIdScret", feedbackId);
                }
					
				writer.println("<h3>Your feddback message is</h3>");
				
				writer.print("""
						<p>Email : %s</p>
						<p>Phone number : %s</p>
						<p>message : %s</p>
					""".formatted(email, phone, message));
				
				//get the session id
				HttpSession session = req.getSession();
				Integer secret = (Integer) session.getAttribute("userIdScret");
					
				if (secret != null) {
				    writer.print("""
				            <p>Secret : %d</p>
				        """.formatted(secret));
				} else {
				    writer.print("<p>No secret found in session.</p>");
				}
				
			}
			else {
				writer.println("<p> Email or phone number is alredy exit ! </p>");
			}

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	
	}
		
}
