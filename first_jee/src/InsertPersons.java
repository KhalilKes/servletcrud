

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertPersons
 */
@WebServlet("/insertpersons")
public class InsertPersons extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPersons() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		String query = "insert into person(lname, fname, age) values (?,?,?)";
		
		try {
			Connection conn =  Connex.getConnected();
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, request.getParameter("lname"));
			st.setString(2, request.getParameter("fname"));
			st.setString(3, request.getParameter("age"));
			
			st.executeUpdate();
			
			st.close();
			conn.close();
			
			writer.println("<html><body><h4><strong>Inserted successfully !!</strong></h4></body><a href='index.html'>return to home</a></html>");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
