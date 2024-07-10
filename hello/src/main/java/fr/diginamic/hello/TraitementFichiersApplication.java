package fr.diginamic.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.hello.controleurs.Departement;
import fr.diginamic.hello.controleurs.DepartementService;
import fr.diginamic.hello.controleurs.LectureDepartement;
import fr.diginamic.hello.controleurs.LectureVille;
import fr.diginamic.hello.controleurs.Ville;
import fr.diginamic.hello.controleurs.VilleService;

@SpringBootApplication
public class TraitementFichiersApplication implements CommandLineRunner {
	
	@Autowired
	private VilleService villeService;
	
	@Autowired
	private DepartementService dptService;
	
	public static void main(String[] args) {
		SpringApplication application = new
				SpringApplication(TraitementFichiersApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Departement> departements = LectureDepartement.lireFichier();
		for(Departement d : departements) {
			dptService.insertDepartement(d);
		}
		
		List<Ville> villes = LectureVille.lireFichier();
		for(Ville v : villes) {
			villeService.insertVilles(v, v.getDepartement().getNom());
		}
		
	}
}

