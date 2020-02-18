import { Component, OnInit, } from '@angular/core';
import {AuthentificationService} from "../authentification.service";
import { User } from "../models/user";

@Component({
  selector: 'app-se-connecter',
  templateUrl: './se-connecter.component.html',
  styleUrls: ['./se-connecter.component.css']
})
export class SeConnecterComponent implements OnInit {

  affichage : boolean = true;
  user: User = new User();

  constructor(private auth : AuthentificationService) { }

  ngOnInit() {

  }

  inscription() {
    console.log('Données du formulaire...', this.user);
    this.auth.postAddUser(this.user).subscribe(user => user);
    console.log(this.user);
  }


  onConnexion(){
    this.affichage = true;
  }

  onInscription(){
    this.affichage = false;
  }

}
