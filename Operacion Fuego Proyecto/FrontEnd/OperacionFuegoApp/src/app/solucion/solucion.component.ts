import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { tap } from 'rxjs/internal/operators/tap';
import { OperacionServiceService } from './operacion-service.service';
import { positionModel } from './OperacionFuegoEntidades/positionModel';
import { sateliteModel } from './OperacionFuegoEntidades/sateliteModel';
import { satelitetopSplit } from './OperacionFuegoEntidades/sateliteTopSplit';
import { shipModel } from './OperacionFuegoEntidades/shipModel';
import { TopSecret } from './OperacionFuegoEntidades/TopSecret';

@Component({
  selector: 'app-solucion',
  templateUrl: './solucion.component.html',
  styleUrls: ['./solucion.component.css']
})
export class SolucionComponent implements OnInit {

  nave:String;
  satelite1:String;
  satelite2:String;
  satelite3:String;
  ship: shipModel=new shipModel;
  satelites: sateliteModel[];
  satelite:sateliteModel=new sateliteModel();
  position:positionModel=new  positionModel();
  satelitetop_split:satelitetopSplit=new satelitetopSplit();
  satelitename:String;
  message:String;
  topsecretresponse:TopSecret=new TopSecret();
  topsecretresponseget:TopSecret=new TopSecret();
  positionget:positionModel=new  positionModel();
  satelitenameget:String;


  constructor(
  private router:Router,
  private operacionService: OperacionServiceService
  ) { }

  ngOnInit() {

    this.nave="nave portacarga imperial";
    this.satelite1="Satelite 1";
    this.satelite2="Satelite 2";
    this.satelite3="Satelite 3";

    this.operacionService.getNave().pipe(
      tap(ship => {
        console.log('SolucionComponent: tap 1');

          console.log(ship.nameship);
        
      })
    ).subscribe(ship => this.ship = ship);

   // this.getSatelites();
  }

  
  siquiente(): void {
    this.router.navigate(['/solucion']);
    this.router.navigateByUrl('solucion');
  }

  getSatelites(): void {
    this.operacionService.getSatellites().pipe(
      tap(satelites => {
        console.log('SolucionComponent: tap 2');
        satelites.forEach(satelites => {
          console.log(satelites.name);
        });
      })
    ).subscribe(satelites => this.satelites = satelites);

  }

  verPosicion(idsatelite:number):void{

    this.operacionService.getPositionSatellite(idsatelite).pipe(
      tap(position => {
        console.log('SolucionComponent: tap 4');

          console.log(position.satelite.name);
        
      })
    ).subscribe(position => this.position = position);
   // this.satelite=this.position.satelite
  }

  verMessage(nombresatelite:string):void{

    this.operacionService.getMenssageSatellite(nombresatelite).pipe(
      tap(satelite => {
        console.log('SolucionComponent: tap 4');

          console.log(satelite.message);
        
      })
    ).subscribe(satelite => this.satelite = satelite);

  }

  verMessagetopSplit(nombresatelite:string):void{
    this.satelitename=nombresatelite;
    this.operacionService.getMenssageSatelliteTop_Split(nombresatelite).pipe(
      tap(satelitetop_split => {
        console.log('SolucionComponent: tap 4');

          console.log(satelitetop_split.message);
        
      })
    ).subscribe(satelitetop_split => this.satelitetop_split = satelitetop_split);

  }

  
  verMessagetopSplit1(nombresatelite:string):void{
    this.satelitenameget=nombresatelite;
    this.operacionService.getMenssageSatelliteTop_Split1(nombresatelite).pipe(
      tap(topsecretresponseget => {
        console.log('SolucionComponent: tap 4');

          console.log(topsecretresponseget.message);
          console.log(topsecretresponseget.position)
          console.log(topsecretresponseget.position.x)
          this.positionget=this.topsecretresponseget.position;
        
      })
    ).subscribe(topsecretresponseget => this.topsecretresponseget = topsecretresponseget);
     
  
  }


  topsecret():void{
    this.getSatelites();
    this.operacionService.gettopsecret(this.satelites).pipe(
      tap(position => {
        console.log('SolucionComponent: tap 4');
          console.log(position.idPosition);
        
      })
    ).subscribe(position => this.position = position);
  }


  topsecret1():void{
    this.getSatelites();
    this.operacionService.gettopsecret1(this.satelites).pipe(
      tap(message => {
        console.log('SolucionComponent: tap 4');
          console.log(message);
        
      })
    ).subscribe(message => this.message = message);
  }

  topsecret2():void{
    this.getSatelites();
    this.operacionService.gettopsecret2(this.satelites).pipe(
      tap(topsecretresponse => {
        console.log('SolucionComponent: tap 4');
          console.log(topsecretresponse.position);
        //this.positionget=topsecretresponse.position;
      })
    ).subscribe(topsecretresponse => this.topsecretresponse = topsecretresponse);
  }

  finalizar(): void {
    this.router.navigate(['/fin']);
    this.router.navigateByUrl('fin');
  }


}