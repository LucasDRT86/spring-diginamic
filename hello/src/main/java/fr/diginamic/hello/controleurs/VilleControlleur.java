package fr.diginamic.hello.controleurs;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/villes")
public class VilleControlleur {

	@Autowired
	VilleService villeService;
	

	@GetMapping()
	public List<Ville> getVilles(){		
		return villeService.extractVilles();
	}

	@PostMapping
	public ResponseEntity<String> addVille(@Valid @RequestBody Ville ville,BindingResult result) throws Exception {
		if(result.hasErrors()) {
			throw new Exception(result.getAllErrors().get(0).getDefaultMessage());
		}
		for(Ville v : villeService.extractVilles()) {
			if(v.getNom().equalsIgnoreCase(ville.getNom())) {
				return ResponseEntity.badRequest().body("Erreur 400 : La ville existe déjà");
			}
			else if(v.getId() == ville.getId()) {
				return ResponseEntity.badRequest().body("Erreur 400 : L'id : "+ville.getId() +" est déjà utilisé");
			}
		}
		
		villeService.insertVilles(ville,ville.getDepartement().getNom());
		return ResponseEntity.ok("La ville de " + ville.getNom() +" à été ajouté avec succés !");
	}

	@PutMapping
	public ResponseEntity<String> addVilleUniqueId(@Valid @RequestBody Ville ville){
		for(Ville v : villeService.extractVilles()) {
			if(v.getId() == ville.getId()) {
				return ResponseEntity.badRequest().body("Erreur 400 : L'id : "+ville.getId() +" est déjà utilisé");
			}
		}
		villeService.insertVilles(ville,ville.getDepartement().getNom());
		return ResponseEntity.ok("La ville de " + ville.getNom() +" à été ajouté avec succés !");

	}

	@GetMapping(path ="/ville")
	public Ville getVilleById(@RequestParam int id) {
		Ville ville = null;

		for(Ville v : villeService.extractVilles()) {
			if(v.getId() == id) {
				ville = v;
			}
		}

		return ville;
	}

	@DeleteMapping
	public ResponseEntity<String> deleteVille(@RequestParam int id){
		for(Ville v : villeService.extractVilles()) {			
			if(v.getId() == id) {
				villeService.supprimerVille(id);
				return ResponseEntity.ok("La ville de " + v.getNom() +" à été supprimé de la liste");
			}
		}
		return ResponseEntity.badRequest().body("Erreur 400 : L'id n'existe pas");
	}
}