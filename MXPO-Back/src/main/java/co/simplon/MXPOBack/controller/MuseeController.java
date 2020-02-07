package co.simplon.MXPOBack.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.model.Departement;
import co.simplon.MXPOBack.model.Musee;
import co.simplon.MXPOBack.model.Ville;
import co.simplon.MXPOBack.repository.DepartementRepository;
import co.simplon.MXPOBack.repository.MuseeRepository;
import co.simplon.MXPOBack.repository.VilleRepository;

@RestController
@CrossOrigin("*")
public class MuseeController {

	@Autowired
	private DepartementRepository departementRepository;
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private MuseeRepository museeRepository;
	
	@GetMapping("/musees")
	public List<Musee> getAllMusee() {
		return museeRepository.findAll();
	}
	
	@GetMapping("/musees/{id}")
	public ResponseEntity<Optional<Musee>> getMuseeById(@PathVariable(value = "id") String codeMusee) {
		Optional<Musee> musee = museeRepository.findById(codeMusee);
		return ResponseEntity.ok().body(musee);
	}
	
	@GetMapping("/regions/{id}/musees")
	public List<Musee> getMuseesParRegion(@PathVariable(value = "id") String codeRegion) {
		
		List<Musee> museeListe = new ArrayList<>();
				
		List<Departement> departementListe = departementRepository.findByCodeRegion(codeRegion);
		
		for (Departement departement : departementListe) {
			
			List<Ville> villeListe = villeRepository.findByCodeDepartement(departement.getCodeDepartement());
			
				for (Ville ville : villeListe) {
					
					museeListe.addAll(museeRepository.findByCodeVille(ville.getCodeVille()));
					
				}
		}
		
		return museeListe;
		
	}
	
	@GetMapping("/departements/{id}/musees")
	public List<Musee> getMuseesParDepartement(@PathVariable(value = "id") String codeDepartement) {
		
		List<Musee> museeListe = new ArrayList<>();
		
		List<Ville> villeListe = villeRepository.findByCodeDepartement(codeDepartement);
		
		for (Ville ville : villeListe) {
			
			museeListe.addAll(museeRepository.findByCodeVille(ville.getCodeVille()));
			
		}
		
		return museeListe;
		
	}
	
	@GetMapping("/villes/{id}/musees")
	public List<Musee> getMuseesParVille(@PathVariable(value = "id") String codeVille) {
		
		return museeRepository.findByCodeVille(codeVille);
	
	}
	
}
