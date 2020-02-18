import { Injectable } from '@angular/core';
import { Musee } from './models/musee';

@Injectable()
export class Globals {
  
    recherche: string = "";
    listeMuseeRecherche : Musee[];
  
}