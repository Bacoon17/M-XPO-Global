import { Component, OnInit } from '@angular/core';
import { NgImageSliderComponent } from 'ng-image-slider';

@Component({
  selector: 'app-image-themes',
  templateUrl: './image-themes.component.html',
  styleUrls: ['./image-themes.component.css']
})
export class ImageThemesComponent implements OnInit {

  ngOnInit() {
  }
  
  //@ViewChild('nav') 
  slider: NgImageSliderComponent;
  
  imageObject: Array<object> = 
  [{
      image: 'assets/images/musee1.jpg',
      thumbImage: 'assets/images/musee1.jpg',
      title: 'Beaux-Arts',
    }, 
    {
      image: 'assets/images/musee2.jpg',
      thumbImage: 'assets/images/musee2.jpg',
      title: 'Sciences Fondamentales',
    }, 
    {
      image: 'assets/images/musee3.jpg',
      thumbImage: 'assets/images/musee3.jpg',
      title: 'Ethnologie',
    },
    {
      image: 'assets/images/musee4.jpg',
      thumbImage: 'assets/images/musee4.jpg',
      title: 'Arts décoratifs',
    },
    {
      image: 'assets/images/musee5.jpg',
      thumbImage: 'assets/images/musee5.jpg',
      title: 'Sciences de la nature',
    },
    {
      image: 'assets/images/musee6.jpg',
      thumbImage: 'assets/images/musee6.jpg',
      title: 'Technique et industrie',
    },
    {
      image: 'assets/images/musee7.jpg',
      thumbImage: 'assets/images/musee7.jpg',
      title: 'Archéologie',
    },
    {
      image: 'assets/images/musee6.jpg',
      thumbImage: 'assets/images/musee6.jpg',
      title: 'Histoire',
    },
    {
      image: 'assets/images/musee6.jpg',
      thumbImage: 'assets/images/musee6.jpg',
      title: 'Art moderne et contemporain',
    },
    {
      image: 'assets/images/musee6.jpg',
      thumbImage: 'assets/images/musee6.jpg',
      title: 'Photographie',
    },
    {
      image: 'assets/images/musee6.jpg',
      thumbImage: 'assets/images/musee6.jpg',
      title: 'Civilisation extra-européenne',
    },
    {
      image: 'assets/images/musee6.jpg',
      thumbImage: 'assets/images/musee6.jpg',
      title: 'Aucun thème associé',
    }
    ];
  
    prevImageClick() {
        this.slider.prev();
    }
    
    nextImageClick() {
        this.slider.next();
    }

    // onClick() {
    //   console.log("test")
    // }
  
}
