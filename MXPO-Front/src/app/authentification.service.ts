import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import {User} from "./models/user";



@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {

  private baseUrl = "http://localhost:8080/";
  constructor(private http: HttpClient) { }

  // créer un Utilisateur
  postAddUser(user: User): Observable<any> {
    console.log(user);
    return this.http.post<User>(this.baseUrl + 'users/add', user);
  }


  login(mail, mdp) {
    this.http.get(`${this.baseUrl}/users/login?mail=${mail}&mdp=${mdp}`).subscribe(
      (user : User) => {
        if (user !== null) {
          sessionStorage.setItem('idUser', String(+user.idUser));
          sessionStorage.setItem('nom', user.nom);
          sessionStorage.setItem('prenom', user.prenom);
        }
      }
    )
  }


  logout() {
      sessionStorage.removeItem('isUser');
      sessionStorage.removeItem('nom');
      sessionStorage.removeItem('prenom');
  }

  isLoggedIn() {
    const idUser = sessionStorage.getItem('idUser');
    const nomUser = sessionStorage.getItem('nom');
    const prenomUser = sessionStorage.getItem('prenom')
    return (idUser !== null && nomUser !== null && prenomUser !== null);
  }

}
