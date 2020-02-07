import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { Musee } from '../models/musee';
import { MuseeService } from '../musee.service';

@Component({
  selector: 'app-tableau-resultat-musee',
  templateUrl: './tableau-resultat-musee.component.html',
  styleUrls: ['./tableau-resultat-musee.component.css']
})
export class TableauResultatMuseeComponent implements OnInit {

  displayedColumns: string[] = ['N°', 'Musée', 'Adresse', 'Reservation'];
  listMusees: Musee[];
  dataSource: MatTableDataSource<Musee>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private museeService: MuseeService) { }

  ngOnInit() {
    this.getAllMusees();
  }
  
  getAllMusees() {
    this.museeService.getMuseesList().subscribe((musees: Musee[]) => {
      this.listMusees = musees;
      this.setDataSourceTab();
    })
  }

  getMuseesByRegions(codeRegion : String) {
    this.museeService.getMuseesByRegion(codeRegion).subscribe((musees: Musee[]) => {
      this.listMusees = musees;
      this.setDataSourceTab();
    })
  }

  getMuseesByDepartements(codeDepeartement : String) {
    this.museeService.getMuseesByDepartement(codeDepeartement).subscribe((musees: Musee[]) => {
      this.listMusees = musees;
      this.setDataSourceTab();
    })
  }

  getMuseesByVilles(codeVille : String) {
    this.museeService.getMuseesByVille(codeVille).subscribe((musees: Musee[]) => {
      this.listMusees = musees;
      this.setDataSourceTab();
    })
  }

  setDataSourceTab() {
    this.dataSource = new MatTableDataSource<Musee>(this.listMusees);
    this.dataSource.paginator = this.paginator;
  }

}