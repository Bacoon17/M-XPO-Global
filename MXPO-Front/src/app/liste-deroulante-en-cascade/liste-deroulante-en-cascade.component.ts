import { Component, OnInit, Input, SimpleChange, Output, EventEmitter } from '@angular/core';
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
  selected = "-1";

  @Input() codeRegionCarte: String;

  @Output() codeRegionListeDeroulante = new EventEmitter<String>();

  @Output() codeDepartementListeDeroulante = new EventEmitter<String>();

  @Output() codeVilleListeDeroulante = new EventEmitter<String>();

  constructor(private museeService: MuseeService) { }

  // Au chargement de la page
  ngOnInit() {
    this.getAllRegions();
    this.getAllDepartements();
  }

  ngOnChanges(changes: { [propKey: string]: SimpleChange }) {

    for (let propName in changes) {
      if (propName === 'codeRegionCarte') {
        // Récupérer le codeRegion de l'entité Parent suite au changement de l'attribut constaté par ngOnChanges
        let codeRegion = changes[propName].currentValue;
        // Relier le codeRegion sélectionné sur la carte à la barre défilante des Régions pour l'affichage
        this.selected = codeRegion;
        // Télécharger la liste de tous les départements pour la région sélectionnée sur la carte
        this.getAllDepartementsByRegion(codeRegion);
        this.getAllVillesByRegion(codeRegion);
        this.activeListe = false;
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
    if (codeRegion !== "-1") {
      this.listDepartements=[]
      this.museeService.getDepartementsByRegion(codeRegion).subscribe((departements: Departement[]) => {
        this.listDepartements = departements;
      })
    }
  }

  getAllVillesByRegion(codeRegion: String) {
    this.museeService.getVillesByRegion(codeRegion).subscribe((villes: Ville[]) => {
      this.listVilles = villes;
      // Trier la liste par ordre alphabétique sur le critère de nomVille
      this.listVilles.sort((a, b) => { return a.nomVille > b.nomVille ? 1 : -1;});
    })
  }

  getAllVillesByDepartement(codeDepartement: String) {
    this.listVilles = [];
    this.museeService.getVillesByDepartement(codeDepartement).subscribe((villes: Ville[]) => {
      this.listVilles = villes;
      this.activeListe = false;
    })
  }

  getRegionByDepartement(codeDepartement: String) {
  }

  // Fonctions des évènements associés

  handleSelectRegion(evt) {
    let codeRegion = evt.target.value;
  
    if (codeRegion !== "-1") {
      this.getAllDepartementsByRegion(codeRegion);
      this.getAllVillesByRegion(codeRegion);
      // Activer la liste des villes      
      this.activeListe = false;
    
      // Récupérer le codeRegionListeDéroulante pour la tableMusée
      this.codeRegionListeDeroulante.emit(codeRegion);
    
    
    } else {
      this.getAllDepartements();
      // Désactiver la liste des villes
      this.getAllVilles();
      this.activeListe = true;

      this.codeRegionListeDeroulante.emit(codeRegion);
      
    }

  }

  handleSelectDepartement(evt) {
    let codeDepartement = evt.target.value;

    if (codeDepartement !== "-1") {
      this.getAllVillesByDepartement(codeDepartement);
      // TODO : Afficher la bonne région automatiquement

      // Activer la liste des villes
      this.activeListe = true;

      this.codeDepartementListeDeroulante.emit(codeDepartement);
    }
    
  }

  handleSelectVille(evt) {
    let codeVille = evt.target.value;

    console.log("Code Ville LD : "+codeVille);

    if (codeVille !== "-1") {
      // TODO : Afficher le bon département automatiquent
      // TODO : Afficher la bonne région automatiquement

      this.codeVilleListeDeroulante.emit(codeVille);
    }
  }

}
