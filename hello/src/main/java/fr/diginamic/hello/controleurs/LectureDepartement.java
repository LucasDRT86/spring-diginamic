package fr.diginamic.hello.controleurs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectureDepartement {

	/** Méthode utilisé pour un fichier csv regroupent des villes
	 * @return List<Departement>
	 */
	public static List<Departement> lireFichier(){

		List<Departement> departements = new ArrayList<>();

		Path path = Paths.get("src/main/resources/departements-france.csv");

		try {
			List<String> lignes =Files.readAllLines(path);
			lignes.remove(0);

			for(String departement : lignes) {
				Departement d = new Departement();
				String[] elt = departement.split(",");

				d.setCode(elt[0]);
				d.setNom(elt[1]);
				
				departements.add(d);

			}

			return departements;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return departements;
	}

}
