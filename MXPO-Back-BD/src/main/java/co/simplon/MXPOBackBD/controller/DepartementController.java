package co.simplon.MXPOBackBD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBackBD.api.RequetesAPI;
import co.simplon.MXPOBackBD.model.Departement;
import co.simplon.MXPOBackBD.repository.DepartementRepository;

@RestController
@CrossOrigin("*")
public class DepartementController {

	@Autowired
	private DepartementRepository departementRepository;
	
	@PutMapping("/departements/ajout")
	public void addNewRegion() {
		RequetesAPI requete = new RequetesAPI();
		
		List<Departement> departementListe = requete.enregistrerListeDepartement();
		
		departementRepository.saveAll(departementListe);
		
	}
	
}
