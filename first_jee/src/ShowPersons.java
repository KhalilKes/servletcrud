

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowPersons
 */
@WebServlet("/showpersons")
public class ShowPersons extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPersons() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		String query = "select * from person";
		
		try {
			Connection conn =  Connex.getConnected();
			
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				int personId = rs.getInt("id");
				String lname = rs.getString("lname");
				String fname = rs.getString("fname");
				int age = rs.getInt("age");
				
				writer.append(
						 "<table border> <tr><th>id</th> <th>weird last name</th> <th>weird first name</th><th>weird age</th></tr> "
						+ "<tr><td>"+ personId +"</td><td>"+ lname +"</td> <td>"+ fname +"</td> <td>"+ age +"</td> "
								+ "<td><a href='deletepersons?id="+ personId +"'>delete</a></td> <td><a href=''>update</a></td> </tr>"
						+ "</table> ");
				
			}
			
			writer.println("<a href='index.html'>return to home</a>");
			
			
			
		}catch(Exception e) {
			writer.append("something went wrong");
			System.out.println(e);
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
