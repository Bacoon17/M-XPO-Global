import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-localisation',
  templateUrl: './localisation.component.html',
  styleUrls: ['./localisation.component.css']
})
export class LocalisationComponent implements OnInit {

  codeRegionCarte : String = '-1';
  codeRegionListeDeroulante : String = '-1';
  codeDepartementListeDeroulante : String = '-1';
  codeVilleListeDeroulante : String = '-1';
  codeMusee: String;
  
  constructor() { }

  ngOnInit() {
  }

  onCodeRegionCarte(st : String) {
    this.codeRegionCarte = st;
  }

  onCodeRegionListeDeroulante(st : String) {
    this.codeRegionListeDeroulante = st;
  }

  onCodeDepartementListeDeroulante(st : String) {
    this.codeDepartementListeDeroulante = st;
  }

  onCodeVilleListeDeroulante(st: String) {
    this.codeVilleListeDeroulante = st;
  }

  onCodeMusee(st : String) {
    this.codeMusee = st;
  }
}
