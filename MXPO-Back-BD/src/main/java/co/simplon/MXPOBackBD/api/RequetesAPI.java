package co.simplon.MXPOBackBD.api;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import co.simplon.MXPOBackBD.model.Departement;
import co.simplon.MXPOBackBD.model.Musee;
import co.simplon.MXPOBackBD.model.Region;
import co.simplon.MXPOBackBD.model.Ville;

public class RequetesAPI {
	
	String UrlApi = "https://geo.api.gouv.fr/communes?fields=nom,code,codesPostaux,departement,region&format=json&geometry=centre";
	String UrlApiMusee = "https://data.culture.gouv.fr/api/records/1.0/search/?dataset=musees-de-france-base-museofile&rows=1216";
	
	JSONArray localisationJsonArray = null;
	
	public List<Region> enregistrerListeRegion() {
		
		List<Region> listeRegion = new ArrayList<>();
		
		try {
			URL localisationURL = new URL(UrlApi);
			String localisationString = IOUtils.toString(localisationURL, StandardCharsets.UTF_8);
			localisationJsonArray = new JSONArray(localisationString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object localObject : localisationJsonArray) {
			
			JSONObject localisationJsonObject = (JSONObject) localObject;
			
			Region region = new Region();
			
			if (localisationJsonObject.has("region")) {
				String codeRegion = localisationJsonObject.getJSONObject("region").getString("code");
				String nomRegion = localisationJsonObject.getJSONObject("region").getString("nom");
			
				region.setCodeRegion(codeRegion);
				region.setNomRegion(nomRegion);
				
				listeRegion.add(region);
			}
		}
		
		return listeRegion;
		
	}

	public List<Departement> enregistrerListeDepartement() {
		
		List<Departement> listeDepartement = new ArrayList<>();
		
		try {
			URL localisationURL = new URL(UrlApi);
			String localisationString = IOUtils.toString(localisationURL, StandardCharsets.UTF_8);
			localisationJsonArray = new JSONArray(localisationString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object localObject : localisationJsonArray) {
			
			JSONObject localisationJsonObject = (JSONObject) localObject;
			
			Departement departement = new Departement();
			
			if (localisationJsonObject.has("departement")) {
				String codeDepartement = localisationJsonObject.getJSONObject("departement").getString("code");
				String nomDepartement = localisationJsonObject.getJSONObject("departement").getString("nom");
				
				departement.setCodeDepartement(codeDepartement);
				departement.setNomDepartement(nomDepartement);
			}
			
			if (localisationJsonObject.has("region")) {
				String codeRegion = localisationJsonObject.getJSONObject("region").getString("code");
				
				departement.setCodeRegion(codeRegion);
				listeDepartement.add(departement);	
			}		
		}
		return listeDepartement;
	}
	
	public List<Ville> enregistrerListeVille() {
		
		List<Ville> listeVille = new ArrayList<>();
		
		try {
			URL localisationURL = new URL(UrlApi);
			String localisationString = IOUtils.toString(localisationURL, StandardCharsets.UTF_8);
			localisationJsonArray = new JSONArray(localisationString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object localObject : localisationJsonArray) {
			
			JSONObject localisationJsonObject = (JSONObject) localObject;
			
			Ville ville = new Ville();
			String codeVille = "";
			String codePostal = "";
			String nomVille = "";
			String codeDepartement = "";
			
			if (!localisationJsonObject.getJSONArray("codesPostaux").isEmpty() && localisationJsonObject.has("departement")) {
				codeVille = localisationJsonObject.getString("code");
				codePostal = localisationJsonObject.getJSONArray("codesPostaux").getString(0);
				nomVille =  localisationJsonObject.getString("nom");
				codeDepartement = localisationJsonObject.getJSONObject("departement").getString("code");
			
				ville.setCodeVille(codeVille);
				ville.setCodePostal(codePostal);
				ville.setNomVille(nomVille);
				ville.setCodeDepartement(codeDepartement);
			
				listeVille.add(ville);
			}
		}
		
		return listeVille;
	}
	
	public List<Musee> enregistrerListeMusee() {

		List<Musee> listeMusee = new ArrayList<>();
		
		JSONArray museeJsonArray = null;
		
		try {
			URL museeURL = new URL(UrlApiMusee);
			String museeString = IOUtils.toString(museeURL, StandardCharsets.UTF_8);
			museeJsonArray = new JSONObject(museeString).getJSONArray("records");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object museeObject : museeJsonArray) {
			
			JSONObject museeJson = (JSONObject) museeObject;
			
			Musee musee = new Musee();
			
			if (museeJson.getJSONObject("fields").has("ref")) {
				String idMusee = museeJson.getJSONObject("fields").getString("ref");
				musee.setIdMusee(idMusee);	
			}
		
			if (museeJson.getJSONObject("fields").has("nomusage")) {
				String nomMusee = museeJson.getJSONObject("fields").getString("nomusage");
				musee.setNomMusee(nomMusee);
			}
			
			if (museeJson.getJSONObject("fields").has("adrl1_m")) {
				String adresse = museeJson.getJSONObject("fields").getString("adrl1_m");
				musee.setAdresse(adresse);
			}
			
			if (museeJson.getJSONObject("fields").has("ville_m")) {
				String ville = museeJson.getJSONObject("fields").getString("ville_m");
				musee.setVille(ville);
			}
			
			if (museeJson.getJSONObject("fields").has("url_m")) {
				String siteWeb = museeJson.getJSONObject("fields").getString("url_m");
				musee.setSiteWeb(siteWeb);
			}
			
			if (museeJson.getJSONObject("fields").has("geolocalisation")) {
				double geoloc1 = museeJson.getJSONObject("fields").getJSONArray("geolocalisation").getDouble(0);
				double geoloc2 = museeJson.getJSONObject("fields").getJSONArray("geolocalisation").getDouble(1);
				String geolocalisation = geoloc1 + " ; " + geoloc2;
				musee.setGeolocalisation(geolocalisation);
			}
			
			if (museeJson.getJSONObject("fields").has("atout")) {
				String description = museeJson.getJSONObject("fields").getString("atout");
				musee.setDescription(description);
			}
			
			listeMusee.add(musee);
		}
		
		return listeMusee;
	}

//	public List<Theme> enregistrerListeTheme() {
//		
//		List<Theme> listeTheme = new ArrayList<>();
//		
//		JSONArray museeJsonArray = null;
//		
//		try {
//			URL museeURL = new URL(UrlApiMusee);
//			String museeString = IOUtils.toString(museeURL, StandardCharsets.UTF_8);
//			museeJsonArray = new JSONObject(museeString).getJSONArray("records");
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		for (Object museeObject : museeJsonArray) {
//			
//			JSONObject museeJson = (JSONObject) museeObject;
//			
//			Theme theme = new Theme();
//			HashSet<Theme> listeEnCours = new HashSet<>();
//			
//			if (museeJson.getJSONObject("fields").has("themes")) {
//				String nomTheme = museeJson.getJSONObject("fields").getString("dompal");
//				
//				String themeTab[] = nomTheme.split(";");
//				
//				for (int i = 0; i < themeTab.length; i++) {
//					themeTab[i].toLowerCase().trim();
//					listeTheme
//				}
//				
//				HashSet<Integer> HSList2 = new HashSet<>(list2);
//				
//				
//			}
//		
//		
//			listeTheme.add(theme);
//		}
//		
//		return listeTheme;
//	}
}
