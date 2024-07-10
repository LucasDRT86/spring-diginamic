package fr.diginamic.hello.controleurs;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class VilleDAO {

	@PersistenceContext
	private EntityManager em;
	
	

	/** GET /villes : permet d'extraire la liste de toutes les villes 
	 * présente dans le système
	 * @return
	 */
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
