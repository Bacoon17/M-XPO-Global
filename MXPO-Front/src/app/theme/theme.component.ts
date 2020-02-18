import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.css']
})
export class ThemeComponent implements OnInit {

  codeMusee: String;
  codeTheme: number;

  constructor() { }

  ngOnInit() {
  }

  onCodeMusee(st : String) {
    this.codeMusee = st;
  }

  onCodecodeThemeSelectionne(int : number) {
    this.codeTheme = int;
    console.log("theme : " + this.codeTheme)
  }

}
