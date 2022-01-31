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

@WebServlet ("/visualizza")

public class Visualizza extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public Visualizza() {
		super();

	}

	@EJB GestioneContattiEJB gcejb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		List<Contatto> contatti = gcejb.getAllContatti();

		response.getWriter()
		.append("<h1>")
		.append("Lista dei contatti trovati")
		.append("</h1>")
		;

		for(Contatto c: contatti) {

			response.getWriter()
			.append("<div>")
			.append(" Nome: ").append(c.getNome() + "<br>")
			.append(" Cognome: ").append(c.getCognome() + "<br>")
			.append(" Email: ").append(c.getEmail() + "<br>")
			.append("Numeri di telefono:").append(c.stampaNumeri() + "<br>")
			.append("</div>")
			;
		}



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




	}

}
