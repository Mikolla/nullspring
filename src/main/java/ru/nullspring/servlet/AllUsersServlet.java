package ru.nullspring.servlet;



import ru.nullspring.model.User;
import ru.nullspring.service.abstraction.user.UserService;
import ru.nullspring.service.impl.user.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/allusers")
public class AllUsersServlet extends HttpServlet{
	private final UserService userService = new UserServiceImpl();

	public AllUsersServlet()  {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = null;
        users = userService.getAllUsers();
		request.setAttribute("users", users);
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/allusers.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String newUserName = request.getParameter("name");
		String newUserLogin = request.getParameter("login");
		String newUserPassword = request.getParameter("password");
		String newUserRole = request.getParameter("role");
		User newUser = new User(newUserName, newUserLogin, newUserPassword, newUserRole);
        userService.saveUser(newUser);
        response.sendRedirect("/admin/allusers");
	}

}
