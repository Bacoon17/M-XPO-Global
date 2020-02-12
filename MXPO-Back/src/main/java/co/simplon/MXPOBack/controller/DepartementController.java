package co.simplon.MXPOBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.model.Departement;
import co.simplon.MXPOBack.repository.DepartementRepository;

@RestController
@CrossOrigin("*")
public class DepartementController {
	
	@Autowired
	private DepartementRepository departementRepository;
	
	@GetMapping("/departements")
	public List<Departement> getAllDepartement() {
		return departementRepository.findAll();
	}
	
	@GetMapping("/departements/{id}")
	public Optional<Departement> getDepartementById(@PathVariable(value = "id") String codeDepartement) {
		return departementRepository.findById(codeDepartement);
	}
	
	@GetMapping("regions/{id}/departements")
	public List<Departement> getDepartementsParRegion(@PathVariable(value = "id") String codeRegion) {
		return departementRepository.findByCodeRegion(codeRegion);
	}
	
}
