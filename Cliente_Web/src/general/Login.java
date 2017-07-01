package general;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelegate.BusinessDelegate;
import dto.UsuarioDto;
import exceptions.RemoteObjectNotFoundException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDto usuario = null;
		String userName = request.getParameter("usuario");
		String password = request.getParameter("password");
		String page = request.getContextPath()+"/Login";
		
		try {
			usuario = BusinessDelegate.getInstance().Login(userName, password);
			
			if(usuario!= null){
						
				switch (usuario.getRol()) {
				case Cliente:
					page = request.getContextPath()+"/PedidosPendientes";
					break;
				case Admin: 
				case Almacen: 
					page = request.getContextPath()+"/Almacen";
					break;
				case Despacho:
					page = request.getContextPath()+"/Despacho";
					break;
				default:
					break;
				}
				
				Cookie coockie = new Cookie("usuario", usuario.getCodigo()+"");
				response.addCookie(coockie);
				
			}
			
			response.sendRedirect(page);
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
