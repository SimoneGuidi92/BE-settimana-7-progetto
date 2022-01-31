package it.business;

import java.util.List;

import it.data.Contatto;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;



@Stateless
@LocalBean
public class GestioneContattiEJB implements GestioneContattiEJBLocal {

	@PersistenceContext(unitName = "rubricaPS")
	EntityManager em;


	public GestioneContattiEJB() {




	}

	@SuppressWarnings ("unchecked")
	public List<Contatto>getAllContatti() {

		Query q =em.createNamedQuery("contatti.getAllContatti");
		return q.getResultList();

	}

	public void aggiungiContatto(Contatto contatto) {
		em.persist(contatto);
		em.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Contatto> getContattoByCognome(String cognome) {
		Query q = em.createNamedQuery("contatti.get.byCognome");
		q.setParameter("cognome", cognome);
		return q.getResultList();

	}
	/*@SuppressWarnings("unchecked")
	public List<Contatto> getContattoByNumero(String numTelefono) {
		Query q = em.createNamedQuery("contatti.get.byNumero");
		q.setParameter("numero", numTelefono);
		return q.getResultList();
	}*/

}
