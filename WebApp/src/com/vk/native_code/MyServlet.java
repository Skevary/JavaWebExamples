package com.vk.native_code;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		// String job = request.getParameter("job");
		String[] jobs = request.getParameterValues("job");
		String gender = request.getParameter("gender");
		if (gender == null) {
			gender = "-";
		}
		String age18 = request.getParameter("age18");
		if (age18 == null) {
			age18 = "-";
		}

		System.out.println("First name: " + firstName);
		System.out.println("Second name: " + secondName);
		System.out.println("The number of roles: " + jobs.length);
		System.out.println("Profession: " + Arrays.deepToString(jobs));
		System.out.println("Sex: " + gender);
		System.out.println("Over 18 years of age? " + age18);
		System.out.println();

		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<h1>Employee profile: </h1>");
		out.println("First name: <i>" + firstName + "</i><br>");
		out.println("Second name: <i>" + secondName + "</i><br>");
		out.println("Profession: <i>" + Arrays.deepToString(jobs) + "</i><br>");
		out.println("Sex: <i>" + gender + "</i><br>");
		out.println("Over 18 years of age? <i>" + age18 + "</i><br>");
		out.close();
	}
}
