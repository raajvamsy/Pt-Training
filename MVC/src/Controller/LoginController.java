package Controller;
import Model.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginModel lm = new LoginModel();
		Conn cn = new Conn();
		lm.setuser(request.getParameter("username"));
		lm.setpass(request.getParameter("password"));
		System.out.println(cn.validate(lm));
		if (cn.validate(lm))
		{
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/Login.jsp");
		}
			
	}

}
