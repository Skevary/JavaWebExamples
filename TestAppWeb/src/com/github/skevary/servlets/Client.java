package com.github.skevary.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.skevary.local.GreetingLocal;

@WebServlet("/message")
public class Client extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private GreetingLocal hello;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String result = hello.getMessage(request.getParameter("name"));
			request.getSession().setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}

}
