package co.simplon.MXPOBackBD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBackBD.api.RequetesAPI;
import co.simplon.MXPOBackBD.model.Region;
import co.simplon.MXPOBackBD.repository.RegionRepository;

@RestController
@CrossOrigin("*")
public class RegionController {
	
	@Autowired
	private RegionRepository regionRepository;

//	@GetMapping("/regions")
//	public List<Region> getAllRegion() {
//		return regionRepository.findAll();
//	}
//
//	//
//	@GetMapping("/regions/{id}")
//	public ResponseEntity<Optional<Region>> getRegionById(@PathVariable(value = "id") String codeRegion) {
//		Optional<Region> region = regionRepository.findById(codeRegion);
//		return ResponseEntity.ok().body(region);
//	}
	
	@PutMapping("/regions/ajout")
	public void addNewRegion() {
		RequetesAPI requete = new RequetesAPI();
		
		List<Region> regionListe = requete.enregistrerListeRegion();
		regionRepository.saveAll(regionListe);
		
	}
	
}