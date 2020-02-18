export class Musee {
    idMusee: string;
    nomMusee: string;
    adresse: string;
    ville: string;
    siteWeb: string;
    geolocalisation: string;
    description: string;

    constructor(id: string, nom: string, adr: string, vil: string, site: string, geo: string, des: string) {
        this.idMusee = id;
        this.nomMusee = nom;
        this.adresse = adr;
        this.ville = vil;
        this.siteWeb = site;
        this.geolocalisation = geo;
        this.description = des;
    }
}
