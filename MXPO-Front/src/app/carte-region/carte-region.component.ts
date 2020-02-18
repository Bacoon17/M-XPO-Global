import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-carte-region',
  templateUrl: './carte-region.component.html',
  styleUrls: ['./carte-region.component.css']
})
export class CarteRegionComponent implements OnInit {

  @Output() codeRegionCarte = new EventEmitter<String>();

  constructor() { }

  ngOnInit() {
  }

  recupererCodeRegion(valeur : String) {
    this.codeRegionCarte.emit(valeur);
  }

}
