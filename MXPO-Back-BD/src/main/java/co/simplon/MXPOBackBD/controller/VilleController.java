package co.simplon.MXPOBackBD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBackBD.api.RequetesAPI;
import co.simplon.MXPOBackBD.model.Ville;
import co.simplon.MXPOBackBD.repository.VilleRepository;

@RestController
@CrossOrigin("*")
public class VilleController {

	@Autowired
	private VilleRepository villeRepository;
	
	@PutMapping("/villes/ajout")
	public void addNewRegion() {
		RequetesAPI requete = new RequetesAPI();
		
		List<Ville> villeListe = requete.enregistrerListeVille();
		
		villeRepository.saveAll(villeListe);
		
	}
	
}