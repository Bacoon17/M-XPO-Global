package co.simplon.MXPOBack.api;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import co.simplon.MXPOBack.model.OeuvreArtiste;

public class RequeteAPI {

	String urlRechercheMusee = "https://data.culture.gouv.fr/api/records/1.0/search/?q=";
	String urlRechercheLocalisationVille = "https://geo.api.gouv.fr/communes?nom=";
	String urlRechercheLocalisationDepartement = "https://geo.api.gouv.fr/departements?nom=";
	String urlRechercheLocalisationRegion = "https://geo.api.gouv.fr/regions?nom=";
	String urlRechercheArtisteOeuvres = "https://data.culture.gouv.fr/api/records/1.0/search/?dataset=base-joconde-extrait&q=";
	
	String urlFiltreMusee = "&dataset=musees-de-france-base-museofile&rows=1216";
	
	//TODO
	String urlRechercheExposition = "https://opendata.paris.fr/api/records/1.0/search/?q=";
	String urlFiltreExposition = "&dataset=que-faire-a-paris-&facet=category&facet=tags&facet=address_zipcode&facet=address_city&facet=pmr&facet=blind&facet=deaf&facet=access_type&facet=price_type&refine.category=Expositions+";
	
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

	public List<String> retournerListeResultatRegionLocalisation (String regionARechercher) {
		
		List<String> listeRechercheRegion = new ArrayList<>();
		
		JSONArray localisationRegionJsonArray = null;
		
		try {
			URL localisationRegionURL = new URL(urlRechercheLocalisationRegion + regionARechercher);
			String localisationRegionString = IOUtils.toString(localisationRegionURL, StandardCharsets.UTF_8);
			localisationRegionJsonArray = new JSONArray(localisationRegionString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object localObject : localisationRegionJsonArray) {
			
			JSONObject localisationJsonObject = (JSONObject) localObject;
			
			String codeRegion = localisationJsonObject.getString("code");
				
			listeRechercheRegion.add(codeRegion);

		}
		
		return listeRechercheRegion;
		
	}
	
	public List<String> retournerListeResultatDepartementLocalisation (String departementARechercher) {
		
		List<String> listeRechercheDepartement = new ArrayList<>();
		
		JSONArray localisationDepartementJsonArray = null;
		
		try {
			URL localisationDepartementURL = new URL(urlRechercheLocalisationDepartement + departementARechercher);
			String localisationDepartementString = IOUtils.toString(localisationDepartementURL, StandardCharsets.UTF_8);
			localisationDepartementJsonArray = new JSONArray(localisationDepartementString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object localObject : localisationDepartementJsonArray) {
			
			JSONObject localisationJsonObject = (JSONObject) localObject;
			
			String codeDepartement = localisationJsonObject.getString("code");
				
			listeRechercheDepartement.add(codeDepartement);
		}
		
		return listeRechercheDepartement;
		
	}
	
	public List<String> retournerListeResultatVilleLocalisation (String villeARechercher) {
		
		List<String> listeRechercheVille = new ArrayList<>();
		
		JSONArray localisationVilleJsonArray = null;
		
		try {
			URL localisationVilleURL = new URL(urlRechercheLocalisationVille + villeARechercher);
			String localisationVilleString = IOUtils.toString(localisationVilleURL, StandardCharsets.UTF_8);
			localisationVilleJsonArray = new JSONArray(localisationVilleString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object localObject : localisationVilleJsonArray) {
			
			JSONObject localisationJsonObject = (JSONObject) localObject;
				
			String codeVille = localisationJsonObject.getString("code");
					
			listeRechercheVille.add(codeVille);
			
		}
		
		return listeRechercheVille;
		
	}
		
	public List<OeuvreArtiste> retournerListeResultatsArtisteOeuvre (String artisteOeuvreARechercher) {
		
		List<OeuvreArtiste> listeRechercheArtisteOeuvre = new ArrayList<>();
		
		JSONArray artisteOeuvreJsonArray = null;
		
		try {
			URL artisteOeuvreURL = new URL(urlRechercheArtisteOeuvres + artisteOeuvreARechercher);
			String artisteOeuvreString = IOUtils.toString(artisteOeuvreURL, StandardCharsets.UTF_8);
			artisteOeuvreJsonArray = new JSONObject(artisteOeuvreString).getJSONArray("records");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object artisteOeuvreObject : artisteOeuvreJsonArray) {
			
			JSONObject artisteOeuvreJson = (JSONObject) artisteOeuvreObject;
			
			OeuvreArtiste oeuvreArtiste = new OeuvreArtiste();
			
			if (artisteOeuvreJson.getJSONObject("fields").has("titr")) {
				String oeuvre = artisteOeuvreJson.getJSONObject("fields").getString("titr");
				oeuvreArtiste.setOeuvre(oeuvre);
			}
			
			if (artisteOeuvreJson.getJSONObject("fields").has("autr")) {
				String artiste = artisteOeuvreJson.getJSONObject("fields").getString("autr");
				oeuvreArtiste.setArtiste(artiste);
			}
			
			if (artisteOeuvreJson.getJSONObject("fields").has("museo")) {
				String musee = artisteOeuvreJson.getJSONObject("fields").getString("museo");
				oeuvreArtiste.setIdMusee(musee);
			}
			
			listeRechercheArtisteOeuvre.add(oeuvreArtiste);
			
		}
			
		return listeRechercheArtisteOeuvre;
	}
}
