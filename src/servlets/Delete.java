package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Dao;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		deleteItems(request);
		response.sendRedirect("Search");
	}

	private void deleteItems(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			new Dao().deleteItem(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
