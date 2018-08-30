package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daoModelLayer.SearchEmployeeDaoImplementation;
import com.model.Employees;

/**
 * Servlet implementation class UpdateDataOfEmployee
 */

public class UpdateDataOfEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDataOfEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<body><html>");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");

		SearchEmployeeDaoImplementation empdao = new SearchEmployeeDaoImplementation();

		boolean isDataUpdated = empdao.update(new Employees(firstName, lastName, email, age));
		String message = isDataUpdated ? "Data Has Been Updated" : "Data Has Not Been Updated";

		out.println("<h2 align = 'center'>" + message + "</h2>");

		out.println("<a href = 'index.html'>Home</a>");

		out.println("</body></hrml>");
		System.out.println("data has been updtaed: " + isDataUpdated);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}