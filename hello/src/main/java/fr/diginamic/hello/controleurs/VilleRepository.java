package fr.diginamic.hello.controleurs;

import org.springframework.data.repository.CrudRepository;

public interface VilleRepository extends CrudRepository<Ville, Integer> {
	
	/*Ville findByNom(String nom);
	
	Ville findByNbHabitantBetweenMinAndMax(int min,int max);*/
	
	//Ville fyndByDepartementAboveMax
}
