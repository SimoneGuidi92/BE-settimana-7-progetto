package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import it.business.GestioneContattiEJB;
import it.data.Contatto;

/**
 * Servlet implementation class CercaContattoPerCognome
 */
@WebServlet("/cercacognome")
public class CercaContattoPerCognome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CercaContattoPerCognome() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	GestioneContattiEJB gcejb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cognome = request.getParameter("cognome");

		List<Contatto> lc = gcejb.getContattoByCognome(cognome);

		if(lc != null) {
			request.setAttribute("cognome", lc);
		}
		else {

			response.getWriter().append("Contatto non trovato!");

		}


		for(Contatto c: lc) {
			
			response.getWriter()
			.append("<div>")
			.append("Nome: ").append(c.getNome() + "<br>")
			.append("Cognome: ").append(c.getCognome() + "<br>")
			.append("Email: ").append(c.getEmail() + "<br>")
			.append("Numeri di telefono: ").append(c.stampaNumeri() + "<br>")
			.append("</div>")
			;
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
