package co.simplon.MXPOBack.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.model.Departement;
import co.simplon.MXPOBack.model.Musee;
import co.simplon.MXPOBack.model.Ville;
import co.simplon.MXPOBack.repository.DepartementRepository;
import co.simplon.MXPOBack.repository.VilleRepository;

@RestController
@CrossOrigin("*")
public class VilleController {
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private DepartementRepository departementRepository;
	
	@GetMapping("/villes")
	public List<Ville> getAllville() {
		return villeRepository.findAll();
	}
	
	@GetMapping("departements/{id}/villes")
	public List<Ville> getVillesParDepartement(@PathVariable(value = "id") String codeDepartement) {
		return villeRepository.findByCodeDepartement(codeDepartement);
	}
	
	@GetMapping("regions/{id}/villes")
	public List<Ville> getVillesParRegion(@PathVariable(value = "id") String codeRegion) {
		
		List<Ville> villeListe = new ArrayList<>();
		
		List<Departement> departementListe = departementRepository.findByCodeRegion(codeRegion);
		
		for (Departement departement : departementListe) {
			
			List<Ville> listeIntermediaire = villeRepository.findByCodeDepartement(departement.getCodeDepartement());
			
			villeListe.addAll(listeIntermediaire);
				
		}
		
		return villeListe;
		
	}
	
	
}
