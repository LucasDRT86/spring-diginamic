package fr.diginamic.hello.controleurs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectureVille {
	
	/** Méthode utilisé pour un fichier csv regroupent des villes
	 * @return List<Ville>
	 */
	public static List<Ville> lireFichier(){
		
		List<Ville> villes = new ArrayList<>();

		Path path = Paths.get("src/main/resources/recensement.csv");

		try {
			List<String> lignes =Files.readAllLines(path);
			lignes.remove(0);

			for(String ville : lignes) {
				
				Ville v = new Ville();

				String[] elt = ville.split(";");
				
				

				Departement d = Utils.findDepartement(LectureDepartement.lireFichier(), elt[2]);
				v.setDepartement(d);
				v.setNom(elt[6]);
				
				String hbt = elt[9]; // La chaîne de caractères initiale
				hbt = hbt.replace(" ", "");
				v.setHabitant(Integer.parseInt(hbt));
				
				if(v.getDepartement() != null) {
					villes.add(v);
				}

			}
			
			return villes;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return villes;
	}
}
