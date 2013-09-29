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

		response.getWriter().println("Hello");

		String id = session.getId();
		response.getWriter().println("Your session id is " + id);

		Object attr = request.getParameter("param");
		if (attr != null)
			session.setAttribute("param", attr);
		String sessionAttr = (String) session.getAttribute("param");

		response.getWriter().println("Session attribute is " + sessionAttr);
	}

}
