package command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpleadoDao;
import manager.EmpleadoManager;

/**
 * Servlet implementation class LoginCommand
 */
@WebServlet("/LoginCommand")
public class LoginCommand extends HttpServlet {
	EmpleadoManager empleadoManager= new EmpleadoManager();
	EmpleadoDao empleadoDao= new EmpleadoDao();
	private static final long serialVersionUID = 1L;	

    /**
     * Default constructor. 
     */
    public LoginCommand() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_Persona=Integer.parseInt(request.getParameter("identi"));
		System.out.println("id" + id_Persona);
		try {
			String user=empleadoManager.consultarUsuario(id_Persona);
			if(user==null){
				response.setContentType("text/plain");
				response.getWriter().write("null");					
			}
			else{
				response.setContentType("text/plain");
				response.getWriter().write(user);	
			}			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
