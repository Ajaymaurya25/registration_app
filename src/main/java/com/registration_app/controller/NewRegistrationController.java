package com.registration_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration_app.model.DAOService;
import com.registration_app.model.DAOServiceImpl;
@WebServlet("/registrationPage")
public class NewRegistrationController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public NewRegistrationController() {
		super();
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
		 rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService service = new DAOServiceImpl();
		service.connectDB();
	    service.saveRegistration(name, city, email, mobile);
		 
		
		request.setAttribute("msg","Data save Successfully...!!");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
	    rd.forward(request, response);
			 
		
		
		
	}

}
