package co.simplon.MXPOBackBD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBackBD.api.RequetesAPI;
import co.simplon.MXPOBackBD.model.Musee;
import co.simplon.MXPOBackBD.repository.MuseeRepository;

@RestController
@CrossOrigin("*")
public class MuseeController {

	@Autowired
	private MuseeRepository museeRepository;
	
	@PutMapping("/musees/ajout")
	public void addNewRegion() {
		RequetesAPI requete = new RequetesAPI();
		
		List<Musee> museeListe = requete.enregistrerListeMusee();
		
		museeRepository.saveAll(museeListe);
	
	}
	
}