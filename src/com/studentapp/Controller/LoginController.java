package com.studentapp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentapp.model.ClassDAOImpl;

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		ClassDAOImpl dao = new ClassDAOImpl();
		dao.connectDB();
		
		boolean result = dao.verifyLoginCredentials(email, password);
		if(result==true) {
			
		}else {
			request.setAttribute("loginError", "invalid user/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			
		}
	}

}
