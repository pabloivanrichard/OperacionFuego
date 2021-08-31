import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-finalizar',
  templateUrl: './finalizar.component.html',
  styleUrls: ['./finalizar.component.css']
})
export class FinalizarComponent implements OnInit {

  nombres:String;
  constructor(
    private router:Router
  ) { }

  ngOnInit() {

    this.nombres="PABLO RICHARD";
  }
}
