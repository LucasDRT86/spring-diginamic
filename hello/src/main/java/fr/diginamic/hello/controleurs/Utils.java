package fr.diginamic.hello.controleurs;

import java.util.List;

public class Utils {

	/** Méthodes utiliser pour retourner un departement dans une liste donnée
	 *  à partir d'un code départemnet
	 * @param dpts
	 * @param code
	 * @return Departement
	 */
	public static Departement findDepartement(List<Departement> dpts, String code) {
		for(Departement d : dpts) {
			if(d.getCode() == code) {
				return d;
			}
		}
		
		return null;
	}
}
