import { Component, OnInit, ViewChild } from '@angular/core';
import { NgImageSliderComponent } from 'ng-image-slider';

@Component({
  selector: 'app-image-musees',
  templateUrl: './image-musees.component.html',
  styleUrls: ['./image-musees.component.css']
})
export class ImageMuseesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  //@ViewChild('nav') 
  slider: NgImageSliderComponent;
  
  imageObject: Array<object> = [{
    image: 'assets/images/musee1.jpg',
    thumbImage: 'assets/images/musee1.jpg',
    }, 
    {
    image: 'assets/images/musee2.jpg',
    thumbImage: 'assets/images/musee2.jpg',
    }, 
    {
      image: 'assets/images/musee3.jpg',
      thumbImage: 'assets/images/musee3.jpg',
    },
    {
      image: 'assets/images/musee4.jpg',
      thumbImage: 'assets/images/musee4.jpg',
    },
    {
      image: 'assets/images/musee5.jpg',
      thumbImage: 'assets/images/musee5.jpg',
    },
    {
      image: 'assets/images/musee6.jpg',
      thumbImage: 'assets/images/musee6.jpg',
    },
    {
      image: 'assets/images/musee7.jpg',
      thumbImage: 'assets/images/musee7.jpg',
    }
    ];
  
    prevImageClick() {
        this.slider.prev();
    }
    
    nextImageClick() {
        this.slider.next();
    }


}
