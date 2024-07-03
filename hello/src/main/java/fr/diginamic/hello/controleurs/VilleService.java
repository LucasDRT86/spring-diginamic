package fr.diginamic.hello.controleurs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VilleService {
	
	List<Ville> villes = new ArrayList<>();
	
	public List<Ville> extractVilles(){
		return villes;
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
		villes.add(ville);
		return villes;
	}
	
	public List<Ville> modifierVille(int idVille, Ville villeModifiee){
		for(Ville v : villes) {
			if(v.getId() == idVille) {
				v.setNom(villeModifiee.getNom());
				v.setHabitant(villeModifiee.getHabitant());
			}
		}
		return villes;
	}
	
	public List<Ville> supprimerVille(int idVille){
		int index = 0;
		for(Ville v : villes) {
			if(v.getId() == idVille) {
				villes.remove(index);
			}
			index++;
		}
		return villes;
	}
	
}
