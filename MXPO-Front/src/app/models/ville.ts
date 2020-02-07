export class Ville {
    codeVille: String;
    codePostal : String;
    nomVille: String;

    constructor(code: String, codeP: String, nom: String) {
        this.codeVille = code;
        this.codePostal = codeP;
        this.nomVille = nom;
    }
}