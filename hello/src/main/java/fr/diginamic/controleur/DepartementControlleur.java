package fr.diginamic.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.entite.Departement;
import fr.diginamic.service.DepartementService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/departement")
public class DepartementControlleur {
	
	@Autowired
	DepartementService departementService;
	

	@GetMapping()
	public List<Departement> getDepartement(){		
		return departementService.extractDepartement();
	}

	@PostMapping
	public ResponseEntity<String> addDepartement(@Valid @RequestBody Departement departement,BindingResult result) throws Exception {
		if(result.hasErrors()) {
			throw new Exception(result.getAllErrors().get(0).getDefaultMessage());
		}
		for(Departement d : departementService.extractDepartement()) {
			if(d.getNom().equalsIgnoreCase(departement.getNom())) {
				return ResponseEntity.badRequest().body("Erreur 400 : Le departement existe déjà");
			}
			else if(d.getId() == departement.getId()) {
				return ResponseEntity.badRequest().body("Erreur 400 : L'id : "+departement.getId() +" est déjà utilisé");
			}
		}
		
		departementService.insertDepartement(departement);
		return ResponseEntity.ok("Le departement de " + departement.getNom() +" à été ajouté avec succés !");
	}

	@PutMapping
	public ResponseEntity<String> addDepartementUniqueId(@Valid @RequestBody Departement departement){
		for(Departement d : departementService.extractDepartement()) {
			if(d.getId() == departement.getId()) {
				return ResponseEntity.badRequest().body("Erreur 400 : L'id : "+departement.getId() +" est déjà utilisé");
			}
		}
		departementService.insertDepartement(departement);
		return ResponseEntity.ok("La ville de " + departement.getNom() +" à été ajouté avec succés !");

	}

	@GetMapping(path ="/departement")
	public Departement getDepartementById(@RequestParam int id) {
		Departement departement = null;

		for(Departement d : departementService.extractDepartement()) {
			if(d.getId() == id) {
				departement = d;
			}
		}

		return departement;
	}

	@DeleteMapping
	public ResponseEntity<String> deleteDepartement(@RequestParam int id){
		for(Departement d : departementService.extractDepartement()) {			
			if(d.getId() == id) {
				departementService.supprimerDepartement(id);
				return ResponseEntity.ok("Le departement de " + d.getNom() +" à été supprimé de la liste");
			}
		}
		return ResponseEntity.badRequest().body("Erreur 400 : L'id n'existe pas");
	}
}
