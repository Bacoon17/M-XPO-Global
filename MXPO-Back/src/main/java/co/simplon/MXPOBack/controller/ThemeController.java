package co.simplon.MXPOBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.model.Theme;
import co.simplon.MXPOBack.repository.ThemeRepository;

@RestController
@CrossOrigin("*")
public class ThemeController {

	@Autowired
	private ThemeRepository themeRepository;
	
	@GetMapping("/themes")
	public List<Theme> getAllThemes() {
		return themeRepository.findAll();
	}
	
	@GetMapping("/themes/{id}/musees")
	public ResponseEntity<Optional<Theme>> getThemeById(@PathVariable(value = "id") int idTheme) {
		Optional<Theme> theme = themeRepository.findById(idTheme);
		
		
		return ResponseEntity.ok().body(theme);
	}
	
}
