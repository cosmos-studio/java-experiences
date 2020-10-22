package cn.icanbe.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, name = "AnnotationServlet", urlPatterns = { "/as" })
public class AnnotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("=> Servlet init()");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("=> Servlet destroy()");
	}

	public AnnotationServlet() {
		super();
		System.out.println("=> Servlet is created.");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/").forward(request, response);
		System.out.println("=> Servlet is used...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
