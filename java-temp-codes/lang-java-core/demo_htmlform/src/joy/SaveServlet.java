package joy;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

public class SaveServlet extends HttpServlet {

	public SaveServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rootPath = request.getSession().getServletContext().getRealPath(
				"/");
		File file = new File(rootPath + "MyHtml.html");
		String content = request.getParameter("content");
		System.out.println(content);
		FileUtils.writeStringToFile(file, content, "UTF-8");

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

}