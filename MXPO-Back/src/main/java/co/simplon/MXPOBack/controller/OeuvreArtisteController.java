package co.simplon.MXPOBack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.api.RequeteAPI;
import co.simplon.MXPOBack.model.OeuvreArtiste;

@RestController
@CrossOrigin("*")
public class OeuvreArtisteController {
	
	@GetMapping("/oeuvresartistes/{recherche}")
	public List<OeuvreArtiste> getMuseesParRechercheOeuvreArtiste(@PathVariable(value = "recherche") String artisteOeuvreARechercher) {
		
		RequeteAPI requete = new RequeteAPI();

		return requete.retournerListeResultatsArtisteOeuvre(artisteOeuvreARechercher);
	}
	
}