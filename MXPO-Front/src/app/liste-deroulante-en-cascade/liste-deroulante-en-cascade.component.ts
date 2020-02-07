import { Component, OnInit, Input, SimpleChange } from '@angular/core';
import { Region } from '../models/region';
import { MuseeService } from '../musee.service';
import { Departement } from '../models/departement';
import { Ville } from '../models/ville';

@Component({
  selector: 'app-liste-deroulante-en-cascade',
  templateUrl: './liste-deroulante-en-cascade.component.html',
  styleUrls: ['./liste-deroulante-en-cascade.component.css']
})
export class ListeDeroulanteEnCascadeComponent implements OnInit {

  catPays = "--Pays--";
  catRegion = "--Regions--";
  catDepartement = "--Departements--";
  catVille = "--Villes--"
  listRegions: Region[];
  listDepartements: Departement[];
  listVilles: Ville[];
  activeListe: boolean = true;
  selected="-1";

  @Input() codeRegionCarte: String;

  constructor(private museeService: MuseeService) { }

  // Au chargement de la page
  ngOnInit() {
    this.getAllRegions();
    this.getAllDepartements();
  }

  ngOnChanges(changes: { [propKey: string]: SimpleChange }) {
    console.log(this.selected);
    
    for (let propName in changes) {
      console.log(propName, changes[propName].currentValue);
      if (propName === 'codeRegionCarte') {
        // Récupérer le codeRegion de l'entité Parent suite au changement de l'attribut constaté par ngOnChanges
        let codeRegion = changes[propName].currentValue;
        // Relier le codeRegion sélectionné sur la carte à la barre défilante des Régions pour l'affichage
        this.selected = codeRegion;
        // Télécharger la liste de tous les départements pour la région sélectionnée sur la carte
        this.getAllDepartementsByRegion(codeRegion);
      }
    } 
  }

  // Fonctions associées au Back

  getAllRegions() {
    this.museeService.getRegionList().subscribe((regions: Region[]) => {
      this.listRegions = regions;
    })
  }

  getAllDepartements() {
    this.museeService.getDepartementList().subscribe((departements: Departement[]) => {
      this.listDepartements = departements;
    })
  }

  getAllVilles() {
    this.museeService.getVilleList().subscribe((villes: Ville[]) => {
      this.listVilles = villes;
    })
  }

  getAllDepartementsByRegion(codeRegion: String) {
    this.museeService.getDepartementsByRegion(codeRegion).subscribe((departements: Departement[]) => {
      this.listDepartements = departements;
    })
  }

  getAllVillesByDepartement(codeDepartement: String) {
    this.museeService.getVillesByDepartement(codeDepartement).subscribe((villes: Ville[]) => {
      this.listVilles = villes;
    })
  }

  // Fonctions des évènements associés

  handleSelectRegion(evt) {
    let codeRegion = evt.target.value;

    if (codeRegion !== "-1") {
      this.getAllDepartementsByRegion(codeRegion);
      // Activer la liste des villes
      this.activeListe = false;
    } else {
      this.getAllDepartements();
      // Désactiver la liste des villes
      this.activeListe = true;
    }

  }

  handleSelectDepartement(evt) {
    let codeDepartement = evt.target.value;
    this.getAllVillesByDepartement(codeDepartement);
  }

}
