import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = session.getId();

		Object attr = request.getParameter("param");
		session.setAttribute("param", attr);
		String sessionAttr = (String) session.getAttribute("param");

		response.getWriter().println("Hello");
		response.getWriter().println("Your session id is " + id);
		response.getWriter().println("Session attribute is " + sessionAttr);
	}

}
