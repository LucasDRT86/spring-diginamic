package fr.diginamic.hello.controleurs;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class VilleDAO {

	@PersistenceContext
	private EntityManager em;
	
	// GET
	public List<Ville> extractVille(){ 
		TypedQuery<Ville> query = em.createQuery("SELECT v FROM Ville v", Ville.class);
		return query.getResultList();
	}
	
	// POST
	@Transactional
	public void insertVille(Ville nvVille){
	em.persist(nvVille);
	}

	// PUT
	@Transactional
	public void modifVille(int id, Ville ville) {
		Ville villeFromDB = em.find(Ville.class, id);
		if (villeFromDB!=null) {
			villeFromDB.setNom(ville.getNom());
		}
	}

	// DELETE
	@Transactional
	public void deleteVille(int id) {
		Ville villeFromDB = em.find(Ville.class, id);
		em.remove(villeFromDB);
	}
}
