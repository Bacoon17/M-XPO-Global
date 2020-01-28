package co.simplon.MXPOBackBD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBackBD.api.RequetesAPI;
import co.simplon.MXPOBackBD.model.Musee;
import co.simplon.MXPOBackBD.model.Ville;
import co.simplon.MXPOBackBD.repository.MuseeRepository;
import co.simplon.MXPOBackBD.repository.VilleRepository;

@RestController
@CrossOrigin("*")
public class MuseeController {

	@Autowired
	private MuseeRepository museeRepository;
	
	@Autowired
	private VilleRepository villeRepository;
	
	@PutMapping("/musees/ajout")
	public void addNewRegion() {
		RequetesAPI requete = new RequetesAPI();
		
		List<Musee> museeListe = requete.enregistrerListeMusee();
		
		for (Musee musee : museeListe) {
			// 1. Sortir la ville de musée
			String museeVille = musee.getVille();
			// 2. Rechercher la ville dans la BD
			List<Ville> rechercheVilleMusee = villeRepository.findByNomVille(museeVille);
			System.out.println(rechercheVilleMusee);
			// 3. Récupérer le code ville du résultat
			if (!rechercheVilleMusee.isEmpty()) {
				String codeVille = rechercheVilleMusee.get(0).getCodeVille();
				musee.setCodeVille(codeVille);
			}
		}
		
		museeRepository.saveAll(museeListe);
	
	}
	
}