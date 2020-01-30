package co.simplon.MXPOBack.api;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class RequeteAPI {

	String urlRechercheMusee = "https://data.culture.gouv.fr/api/records/1.0/search/?q=";
	
	//TODO
	String urlRechercheExposition = "https://opendata.paris.fr/api/records/1.0/search/?q=";
	String urlRechercheLocalisationVille = "https://geo.api.gouv.fr/communes?nom=";
	String urlRechercheLocalisationDepartement = "";
	String urlRechercheLocalisationRegion = "";
	String urlRechercheTheme = "";
	String urlRechercheArtiste = "";
	String urlRechercheOeuvres = "";
	
	String urlFiltreMusee = "&dataset=musees-de-france-base-museofile&rows=1216";
	
	//TODO
	String urlFiltreExposition = "";
	String urlFiltreLocalisationVille = "";
	String urlFiltreLocalisationDepartement = "";
	String urlFiltreLocalisationRegion = "";
	String urlFiltreTheme = "";
	String urlFiltreArtiste = "";
	String urlFiltreOeuvres = "";
	
	/**
	 * Obtenir les id de musée d'une recherche de musée à partir d'une API externe
	 * @return Liste d'id de type Musee correspondant à la recherche
	 */
	public List<String> retournerListeResultatMusee (String museeARechercher) {
	
		List<String> listeRechercheMusee = new ArrayList<>();
		
		JSONArray museeJsonArray = null;
		
		try {
			URL museeURL = new URL(urlRechercheMusee + museeARechercher + urlFiltreMusee);
			String museeString = IOUtils.toString(museeURL, StandardCharsets.UTF_8);
			museeJsonArray = new JSONObject(museeString).getJSONArray("records");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object museeObject : museeJsonArray) {
			
			JSONObject museeJson = (JSONObject) museeObject;
			
			if (museeJson.getJSONObject("fields").has("ref")) {
				String idMusee = museeJson.getJSONObject("fields").getString("ref");
				listeRechercheMusee.add(idMusee);	
			}
		}
		
		return listeRechercheMusee;
	}

	
	
}
