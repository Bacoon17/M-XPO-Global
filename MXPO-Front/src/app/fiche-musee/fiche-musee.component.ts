import { Component, OnInit, Input, SimpleChange } from '@angular/core';
import { Musee } from '../models/musee';
import { MuseeService } from '../musee.service';

@Component({
  selector: 'app-fiche-musee',
  templateUrl: './fiche-musee.component.html',
  styleUrls: ['./fiche-musee.component.css']
})
export class FicheMuseeComponent implements OnInit {

  @Input() codeMusee: String;

  musee: Musee;

  constructor(private museeService: MuseeService) { }

  ngOnInit() {
    this.getMuseesById('M0001');
  }

  ngOnChanges(changes: { [propKey: string]: SimpleChange }) {
    
    for (let propName in changes) {

      if (propName === 'codeMusee') {
        let codeMuseeTableau = changes[propName].currentValue;
        this.getMuseesById(codeMuseeTableau);
      }

    }
  }

  // Fonctions associées au Back

  getMuseesById(idMusee: String) {
    this.museeService.getMuseeById(idMusee).subscribe((musees: Musee) => {
      this.musee = musees;
    })
  }
}
