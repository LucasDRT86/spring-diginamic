package fr.diginamic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.dao.VilleDAO;
import fr.diginamic.entite.Ville;
import jakarta.annotation.PostConstruct;

@Service
public class VilleService {
	
	@Autowired
	VilleDAO vDao;
	
	
	List<Ville> villes;
	
	@PostConstruct
	public void initDonnee() {
		this.villes = vDao.extractVille();
	}
	
	public List<Ville> extractVilles(){
		return vDao.extractVille();
	}
	
	public Ville extractVille(int idVille) {
		for(Ville v : villes) {
			if(v.getId() == idVille) {
				return v;
			}
		}
		return null;
	}
	
	public Ville extractVille(String nom) {
		for(Ville v : villes) {
			if(v.getNom().equalsIgnoreCase(nom)) {
				return v;
			}
		}
		return null;
	}
	
	public List<Ville> insertVilles(Ville ville){
		vDao.insertVille(ville);
		return villes;
	}
	
	public List<Ville> modifierVille(int idVille, Ville villeModifiee){
		vDao.modifVille(idVille, villeModifiee);
		return villes;
	}
	
	public List<Ville> supprimerVille(int idVille){
		vDao.deleteVille(idVille);
		return villes;
	}
	
}
