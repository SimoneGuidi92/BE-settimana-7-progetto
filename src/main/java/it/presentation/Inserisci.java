package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.business.GestioneContattiEJB;
import it.data.Contatto;
import it.data.NumTelefono;

/**
 * Servlet implementation class Inserisci
 */
@WebServlet("/inserisci")
public class Inserisci extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inserisci() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	GestioneContattiEJB gcejb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");        
		String cognome = request.getParameter("cognome");        
		String email = request.getParameter("email");         
		String numero1 = request.getParameter("numero1");       
		String numero2 = request.getParameter("numero2");	
		
		Contatto c = new Contatto();
		
		NumTelefono num1 = new NumTelefono();
		NumTelefono num2 = new NumTelefono();
		
		num1.setNumTelefono(numero1);
		num2.setNumTelefono(numero2);
		
		num1.setContatto(c);
		num2.setContatto(c);
		
		c.setNome(nome);
		c.setCognome(cognome);
		c.setEmail(email);
		c.aggiungiNumeri(num1);
		c.aggiungiNumeri(num2);
		gcejb.aggiungiContatto(c);
		response.getWriter().append("Contatto inserito correttamente").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {






	}

}
