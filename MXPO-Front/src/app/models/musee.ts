export class Musee {
    idMusee: String;
    nomMusee: String;
    adresse: String;
    ville: String;
    siteWeb: String;
    geolocalisation: String;
    description: String;

    constructor(id: String, nom: String, adr: String, vil: String, site: String, geo: String, des: String) {
        this.idMusee = id;
        this.nomMusee = nom;
        this.adresse = adr;
        this.ville = vil;
        this.siteWeb = site;
        this.geolocalisation = geo;
        this.description = des;
    }
}