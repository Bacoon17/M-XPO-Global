import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchMuseeComponent} from './searchbar/search-musee.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule} from '@angular/common/http';
import { MuseeComponent } from './musee/musee.component';
import { LocalisationComponent } from './localisation/localisation.component';
import { ThemeComponent } from './theme/theme.component';
import { ArtistesComponent } from './artiste/artistes.component';
import { SeConnecterComponent } from './se-connecter/se-connecter.component';
import { OeuvreComponent } from './oeuvre/oeuvre.component';
import { ExpositionComponent } from './exposition/exposition.component';
import { AccueilComponent } from './accueil/accueil.component';
import { CarteRegionComponent } from './carte-region/carte-region.component';
import { ListeDeroulanteEnCascadeComponent } from './liste-deroulante-en-cascade/liste-deroulante-en-cascade.component';
import { TableauResultatMuseeComponent } from './tableau-resultat-musee/tableau-resultat-musee.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SearchMuseeComponent,
    FooterComponent,
    MuseeComponent,
    LocalisationComponent,
    ThemeComponent,
    ArtistesComponent,
    SeConnecterComponent,
    OeuvreComponent,
    ExpositionComponent,
    AccueilComponent,
    CarteRegionComponent,
    ListeDeroulanteEnCascadeComponent,
    TableauResultatMuseeComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatPaginatorModule,
    MatTableModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
