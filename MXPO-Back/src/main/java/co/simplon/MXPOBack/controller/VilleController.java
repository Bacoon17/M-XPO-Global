package co.simplon.MXPOBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.model.Ville;
import co.simplon.MXPOBack.repository.VilleRepository;

@RestController
@CrossOrigin("*")
public class VilleController {
	
	@Autowired
	private VilleRepository villeRepository;
	
	@GetMapping("/villes")
	public List<Ville> getAllville() {
		return villeRepository.findAll();
	}
	
	@GetMapping("departements/{id}/villes")
	public List<Ville> getVillesParDepartement(@PathVariable(value = "id") String codeDepartement) {
		return villeRepository.findByCodeDepartement(codeDepartement);
	}
	
}
