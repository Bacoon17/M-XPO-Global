import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from "rxjs";
import {debounceTime, distinctUntilChanged, map, startWith, switchMap} from 'rxjs/operators';
import { Musee} from '../models/musee'
import { MuseeService } from "../musee.service";
import {FormControl} from "@angular/forms";
import { Globals } from '../global';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-musee',
  templateUrl: './search-musee.component.html',
  styleUrls: ['./search-musee.component.scss']
})

export class SearchMuseeComponent implements OnInit {

  recherche : string = "";
  listMusees: Musee[];

  constructor(private museeService: MuseeService, private globals: Globals, private router: Router) {
    this.recherche = globals.recherche;
    this.listMusees = globals.listeMuseeRecherche;
  }

  ngOnInit(): void{}

  /**
   * Récupérer la valeur écrite dans la barre de recherche
   */
  setValueRecherche() {
    this.getMuseesByRechercheMusee(this.recherche);
    console.log(this.recherche);
    this.globals.recherche = this.recherche;
  }

  /**
   * Récupérer la liste des musées correspondant aux critères de la recherche par "Musées" à partir de l'API externe
   * @param rechercheMusee 
   */
  getMuseesByRechercheMusee(rechercheMusee : string) {
    this.museeService.getMuseeByRecherche(rechercheMusee).subscribe((musees: Musee[]) => {
      this.listMusees = musees;
      this.globals.listeMuseeRecherche = this.listMusees;
      console.log(this.listMusees);
      // Se déplacer dans le menu musée
      this.router.navigate(['musees'])
    })
  }

  

}




















// @Component({
//   selector: 'app-search-musee',
//   templateUrl: './search-musee.component.html',
//   styleUrls: ['./search-musee.component.scss']
// })

// export class SearchMuseeComponent implements OnInit {
//      listMusee$: Musee[];
//      private searchTerms = new Subject<string>();
//      myControl: FormControl = new FormControl();
//      //filteredOption : Observable<string[]>;
//      displayFn(subject){ return subject ? subject.nomMusee : undefined; }

//   constructor(private museeService: MuseeService) {
//   }

//   ngOnInit(): void{
//     this.recupeMuseeList();
//     // this.filteredOption = this.myControl.valueChanges.pipe(
//     //     startWith(''),
//     //     map(val => this.filter(val))
//     //   );
//     // console.log(this.filteredOption);
//   }
//   // filter(val: string): string[]{
//   //   return this.listMusee$.map(musee => musee.nomMusee).filter(option =>
//   //   option.toLowerCase().includes(val.toLowerCase()));
//   // }

//   recupeMuseeList(): void {
//     this.museeService.getMuseesList()
//       .subscribe((musee$: any) => {
//         this.listMusee$ = musee$;
//         console.log(this.listMusee$);
//       });
//   };


// }






// ngOnInit(): void {
//   // console.log(this.museeService.getMuseesList());

//   this.listMusee$= this.searchTerms.pipe(
//     debounceTime(300),
//     distinctUntilChanged(),
//     switchMap((term:string) => this.museeService.getMuseeById(term))
//     );
//   console.log(this.listMusee$);
// }
// displayfonction(subject){
//   return subject ? subject : undefined;
// }

// }
// search(term):void {
//   this.searchTerms.next(term);
//   console.log(term);
// }

