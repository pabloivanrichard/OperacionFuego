import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-operacionfuego',
  templateUrl: './operacionfuego.component.html',
  styleUrls: ['./operacionfuego.component.css']
})
export class OperacionfuegoComponent implements OnInit {

  nombres:String;
  constructor(
    private router:Router
  ) { }

  ngOnInit() {

    this.nombres="PABLO RICHARD";
  }

  
  siquiente(): void {
    this.router.navigate(['/solucion']);
    this.router.navigateByUrl('solucion');
  }

}
