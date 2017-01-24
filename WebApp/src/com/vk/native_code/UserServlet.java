package com.vk.native_code;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<Integer,String> users = new ConcurrentHashMap<>();
	private AtomicInteger counter;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	super.init();
	users.put(1, "Asuka");
	users.put(2, "Rei");
	users.put(3, "Misato");
	users.put(4, "Ikari");
	counter = new AtomicInteger(4);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Integer id = Integer.parseInt(request.getParameter("id"));
	String user = users.get(id);
	if(user==null){
		user="";
	}
	
	response.setContentType("text/html; charset=utf-8");
	PrintWriter out = response.getWriter();
	out.println("<h3>User: "+user+"</h3>");
	out.print("<a href='javascript:history.back();'>Back</a>");
	out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	Integer id = null;
	if(!users.containsValue(name)){
		id = counter.incrementAndGet();
		users.put(id,name);
	}
	
	response.setContentType("text/html; charset=utf-8");
	PrintWriter out = response.getWriter();
	if(id==null){
		out.println("<h3>User: "+name+" already exists!</h3>");
	}else{
		out.println("<h3>Created user: "+name+" with id:"+counter.get()+"</h3>");
	}
	out.println("<a href='http://localhost:8080/WebApp/index.html'>&lt;&lt;Home</a>");
	out.close();
	}

}
