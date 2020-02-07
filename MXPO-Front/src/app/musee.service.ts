import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MuseeService {

  private baseUrl = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  // Récupérer le JSON de toutes les régions
  getRegionList(): Observable<any> {
    return this.http.get(this.baseUrl + "regions")
  }

  // Récupérer le JSON de touts les départements
  getDepartementList(): Observable<any> {
    return this.http.get(this.baseUrl + "departements")
  }

  // Récupérer le JSON de toutes les villes
  getVilleList(): Observable<any> {
    return this.http.get(this.baseUrl + "villes")
  }

  // Récupérer le JSON des départements d'une région spécifique
  getDepartementsByRegion(codeRegion: String) : Observable<any> {
    return this.http.get(this.baseUrl + "regions/" + codeRegion + "/departements");
  }

  // Récupérer le JSON des villes d'un département spécifique
  getVillesByDepartement(codeDepartement: String) : Observable<any> {
    return this.http.get(this.baseUrl + "departements/" + codeDepartement + "/villes");
  }

  // Récupérer le JSON de tous les musées
  getMuseesList() : Observable<any> {
    return this.http.get(this.baseUrl + "musees");
  }

  // Récupérer le JSON de tous les musées dans une région
  getMuseesByRegion(codeRegion: String) : Observable<any> {
    return this.http.get(this.baseUrl + "regions/" + codeRegion + "/musees");
  }

  // Récupérer le JSON de tous les musées dans un département
  getMuseesByDepartement(codeDepartement: String) : Observable<any> {
    return this.http.get(this.baseUrl + "departements/" + codeDepartement + "/musees");
  }
  
  // Récupérer le JSON des musées d'une ville spécifique
  getMuseesByVille(codeVille : String) : Observable<any> {
    return this.http.get(this.baseUrl + "villes/" + codeVille + "/musees");
  }

  // Récupérer le JSON d'un musée spécifique
  getMuseeById(idMusee : String) : Observable<any> {
    return this.http.get(this.baseUrl + "musees/" + idMusee);
  }

}
