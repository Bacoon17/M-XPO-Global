package co.simplon.MXPOBackBD.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBackBD.api.RequetesAPI;
import co.simplon.MXPOBackBD.model.Musee;
import co.simplon.MXPOBackBD.model.Theme;
import co.simplon.MXPOBackBD.model.Ville;
import co.simplon.MXPOBackBD.repository.MuseeRepository;
import co.simplon.MXPOBackBD.repository.ThemeRepository;
import co.simplon.MXPOBackBD.repository.VilleRepository;

@RestController
@CrossOrigin("*")
public class MuseeController {
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@Autowired
	private MuseeRepository museeRepository;
	
	@PutMapping("/musees/ajout")
	public void addNewMusee() {
		RequetesAPI requete = new RequetesAPI();
		
		List<Musee> museeListe = requete.enregistrerListeMusee();
		
		List<Musee> listToSave = new ArrayList<Musee> ();
		
		List<Theme> listeThemeBD = new ArrayList<>();
		// Initialisation d'un objet thème
		
		// Initialiser des variables qui seront les variables par défaut si aucun thème n'est présent pour un musée
		int idTheme = 12;
		String nomTheme = "Aucun thème associé";
		
		// Récupérer la liste des thèmes présent dans la BD
		listeThemeBD = themeRepository.findAll();

		// Instancier une liste de thème vide
		
//		for (Musee musee : museeListe) {
		for (int j = 0; j < museeListe.size(); j++) {
			
			Musee musee = museeListe.get(j);
			
			System.out.println("------------------------------------------------------------------------------");
			System.out.println(musee);
			
			List<Theme> themeParMusee = new ArrayList<>();
			
		// I. Gestion liaison Ville
			
			// Sortir la ville de musée
			String museeVille = musee.getVille();
			
			// Rechercher la ville dans la BD
			List<Ville> rechercheVilleMusee = villeRepository.findByNomVille(museeVille);
			System.out.println(rechercheVilleMusee);
			
			// Récupérer le code ville du résultat
			if (!rechercheVilleMusee.isEmpty()) {
				String codeVille = rechercheVilleMusee.get(0).getCodeVille();
				musee.setCodeVille(codeVille);
			}
			
		// II. Gestion liaison thème
				
				
			// Parser les thèmes d'un musée dans un tableau
			String[] themeTab = musee.getListeThemeString().split(";");
			System.out.println(themeTab);
				
			// Parcourir le tableau des thèmes d'un musée et les comparer à chaque thème enregistré dans la base (double boucle for)
			for (int i = 0; i < themeTab.length; i++) {
					
				for (Theme themeBD : listeThemeBD) {
					boolean trouve = false;
					if(!trouve) {
						String s1 = themeBD.getNomTheme();
						String s2 = themeTab[i].toLowerCase().trim();
						
						System.out.println("Theme BD : " + s1);
						System.out.println("Theme récupéré : " + s2);
						
						System.out.println(s1.equals(s2));	
						
						if (s1.equals(s2)) {
							
							System.out.println("equals");
							idTheme = themeBD.getIdTheme();
							nomTheme = themeBD.getNomTheme();
							
							System.out.println(idTheme + " / " + nomTheme);
							Theme theme = new Theme();

							theme.setIdTheme(idTheme);
							theme.setNomTheme(nomTheme);
							
							themeParMusee.add(theme);
							trouve = true;
						}					
					}
				
				}
					
					
			}
			System.out.println(themeParMusee);
			
			musee.setThemes(themeParMusee);
			listToSave.add(musee);
			System.out.println(musee);
		}
		
		System.out.println(listToSave);
		
		museeRepository.saveAll(listToSave);
	
	}
	
}