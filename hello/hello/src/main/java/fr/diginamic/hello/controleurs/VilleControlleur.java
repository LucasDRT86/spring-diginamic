package fr.diginamic.hello.controleurs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/villes")
public class VilleControlleur {

	List<Ville> villes = new ArrayList<>();

	@GetMapping()
	public List<Ville> getVilles(){		
		return villes;
	}

	@PostMapping
	public ResponseEntity<String> addVille(@RequestBody Ville ville) {
		for(Ville v : villes) {
			if(v.getNom().equalsIgnoreCase(ville.getNom())) {
				return ResponseEntity.badRequest().body("Erreur 400 : La ville existe déjà");
			}
			else if(v.getId() == ville.getId()) {
				return ResponseEntity.badRequest().body("Erreur 400 : L'id : "+ville.getId() +" est déjà utilisé");
			}
		}
		villes.add(ville);
		return ResponseEntity.ok("La ville de " + ville.getNom() +" à été ajouté avec succés !");
	}

	@PutMapping
	public ResponseEntity<String> addVilleUniqueId(@RequestBody Ville ville){
		for(Ville v : villes) {
			if(v.getId() == ville.getId()) {
				return ResponseEntity.badRequest().body("Erreur 400 : L'id : "+ville.getId() +" est déjà utilisé");
			}
		}
		villes.add(ville);
		return ResponseEntity.ok("La ville de " + ville.getNom() +" à été ajouté avec succés !");

	}

	@GetMapping(path ="/ville")
	public Ville getVilleById(@RequestParam int id) {
		Ville ville = null;

		for(Ville v : villes) {
			if(v.getId() == id) {
				ville = v;
			}
		}

		return ville;
	}

	@DeleteMapping
	public ResponseEntity<String> deleteVille(@RequestParam int id){
		int index = 0;
		for(Ville v : villes) {			
			if(v.getId() == id) {
				villes.remove(index);
				return ResponseEntity.ok("La ville de " + v.getNom() +" à été supprimé de la liste");
			}	
			index++;
		}
		return ResponseEntity.badRequest().body("Erreur 400 : L'id n'existe pas");
	}
}