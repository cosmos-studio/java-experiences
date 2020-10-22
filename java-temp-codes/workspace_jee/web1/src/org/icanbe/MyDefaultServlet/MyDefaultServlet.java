package org.icanbe.MyDefaultServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/MyDefaultServlet")
public class MyDefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyDefaultServlet() {
		super();
		System.out.println("=> My default Servlet is created.");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.append("<html><head></head><body>");
		writer.append("Served at: ").append(request.getContextPath()).append("<br/>");
		writer.append("My Default Servlet.");
		writer.append("</body></html>");
		System.out.println("=> My default Servlet is used...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
