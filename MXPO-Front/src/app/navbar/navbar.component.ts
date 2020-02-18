import {Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../authentification.service";


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{

  activeMenu: boolean = false;
  nom : string;
  prenom: string;

  constructor(private auth : AuthentificationService) {
}
  handleClickMenu(){
    this.activeMenu = !this.activeMenu;
  }
 ngOnInit() {
  this.nom = sessionStorage.getItem('nom');
  this.prenom = sessionStorage.getItem('prenom');
 }

}
