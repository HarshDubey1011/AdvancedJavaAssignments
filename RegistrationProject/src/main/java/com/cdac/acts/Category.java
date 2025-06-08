package com.cdac.acts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.acts.DAO.CategoryDAO;

/**
 * Servlet implementation class Category
 */
@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		CategoryDAO cad = new CategoryDAO();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Description</th>");
		out.println("<th>Image</th>");
		out.println("</tr>");
			ResultSet rs = cad.isValid();
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td><a href='Products?categoryId=" + rs.getInt("categoryId") + "'>" + rs.getString("categoryName") + "</a></td>");
				out.println("<td>"+rs.getString("categoryDescription")+ "</td>");
				out.println("<td><img src='Images/" + rs.getString("categoryImageUrl") + "' height='60px' width='60px' /></td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage()+"Jar or Bin file not found!");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
