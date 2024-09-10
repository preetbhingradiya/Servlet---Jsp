package servlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/run")  //apply the path where Servlet is run 
public class FirstServlet implements Servlet {
	
	private ServletConfig config;

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		this.config = arg0;
		System.out.println("Service init..");
	}
	
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {

	    System.out.println("Service Request");
	}


	@Override
	public void destroy() {

		System.out.println("Service End");
	}

	
	//non life cycle method
	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		return "This service created by crawlapps";
	}


}
