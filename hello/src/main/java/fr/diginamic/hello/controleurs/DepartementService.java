package fr.diginamic.hello.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class DepartementService {
	
	@Autowired
	DepartementDAO dDao;
	
	
	List<Departement> departements;
	
	@PostConstruct
	public void initDonnee() {
		this.departements = dDao.extractDepartement();
	}
	
	public List<Departement> extractDepartement(){
		return dDao.extractDepartement();
	}
	
	public Departement extractDepartement(int idDepartement) {
		for(Departement d : departements) {
			if(d.getId() == idDepartement) {
				return d;
			}
		}
		return null;
	}
	
	public Departement extractDepartement(String nom) {
		for(Departement d : departements) {
			if(d.getNom().equalsIgnoreCase(nom)) {
				return d;
			}
		}
		return null;
	}
	
	public List<Departement> insertDepartement(Departement departement){
		dDao.insertDepartement(departement);
		return departements;
	}
	
	public List<Departement> modifierDepartement(int idDepartement, Departement departementModifiee){
		dDao.modifDepartement(idDepartement, departementModifiee);
		return departements;
	}
	
	public List<Departement> supprimerDepartement(int idDepartement){
		dDao.deleteDepartement(idDepartement);
		return departements;
	}
}
