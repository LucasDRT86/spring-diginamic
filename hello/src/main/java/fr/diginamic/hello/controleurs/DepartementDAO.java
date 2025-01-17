package fr.diginamic.hello.controleurs;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class DepartementDAO {

	@PersistenceContext
	private EntityManager em;
	
	// GET
	public List<Departement> extractDepartement(){ 
		TypedQuery<Departement> query = em.createQuery("SELECT d FROM Departement d", Departement.class);
		return query.getResultList();
	}

	public Departement findByName(String name) {
		TypedQuery<Departement> query = em.createQuery("SELECT d FROM Departement d WHERE nom = '" + name +"'", Departement.class);
		return query.getResultList().get(0);
	}
	
	// POST
	@Transactional
	public void insertDepartement(Departement nvDepartement){
	em.persist(nvDepartement);
	}

	// PUT
	@Transactional
	public void modifDepartement(int id, Departement dpt) {
		Departement departementFromDB = em.find(Departement.class, id);
		if (departementFromDB!=null) {
			departementFromDB.setNom(dpt.getNom());
		}
	}

	// DELETE
	@Transactional
	public void deleteDepartement(int id) {
		Departement departementFromDB = em.find(Departement.class, id);
		em.remove(departementFromDB);
	}
}
