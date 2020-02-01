package co.simplon.MXPOBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.model.Musee;
import co.simplon.MXPOBack.repository.MuseeRepository;
import co.simplon.MXPOBack.repository.ThemeRepository;

@RestController
@CrossOrigin("*")
public class MuseeController {

	@Autowired
	private MuseeRepository museeRepository;
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@GetMapping("/musees")
	public List<Musee> getAllMusee() {
		return museeRepository.findAll();
	}
	
	@GetMapping("/musees/{id}")
	public ResponseEntity<Optional<Musee>> getMuseeById(@PathVariable(value = "id") String codeMusee) {
		Optional<Musee> musee = museeRepository.findById(codeMusee);
		return ResponseEntity.ok().body(musee);
	}
	
	@GetMapping("/villes/{id}/musees")
	public List<Musee> getMuseesParVille(@PathVariable(value = "id") String codeVille) {
		return museeRepository.findByCodeVille(codeVille);
	}
	
//	@GetMapping("/themes/{id}/musees")
//	public List<Musee> getMuseesParTheme(@PathVariable(value = "id") String codeTheme) {
//		return themeRepository.
//	}
	
}
