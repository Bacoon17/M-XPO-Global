import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { MuseeService } from '../musee.service';
import { Musee } from '../models/musee';

@Component({
  selector: 'app-liste-deroulante-themes',
  templateUrl: './liste-deroulante-themes.component.html',
  styleUrls: ['./liste-deroulante-themes.component.css']
})
export class ListeDeroulanteThemesComponent implements OnInit {

  @Output() codeThemeSelectionne = new EventEmitter<String>();

  constructor(private museeService: MuseeService) { }

  ngOnInit() {
  }

  handleSelectTheme(evt) {
    let codeThemeRecupere = evt.target.value;
    this.codeThemeSelectionne.emit(codeThemeRecupere);
  }

}
