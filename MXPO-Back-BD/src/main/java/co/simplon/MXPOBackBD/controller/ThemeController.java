package co.simplon.MXPOBackBD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBackBD.api.RequetesAPI;
import co.simplon.MXPOBackBD.model.Theme;
import co.simplon.MXPOBackBD.repository.ThemeRepository;

@RestController
@CrossOrigin("*")
public class ThemeController {

	@Autowired
	private ThemeRepository themeRepository;
	
	@PutMapping("/themes/ajout")
	public void addNewTheme() {
		RequetesAPI requete = new RequetesAPI();
		
		List<Theme> themeListe = requete.enregistrerListeTheme();
		
		
		themeRepository.saveAll(themeListe);
		
	}
	
}
