import { Injectable } from '@angular/core';
//import { DatePipe, formatDate } from '@angular/common';
//import { PersonaComponent } from './persona';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { map, catchError, tap } from 'rxjs/operators';
//import { Observable, throwError } from 'rxjs';
import { shipModel } from './OperacionFuegoEntidades/shipModel';
import swal from 'sweetalert2';
//import { Observable} from 'rxjs';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { sateliteModel } from './OperacionFuegoEntidades/sateliteModel';
import { positionModel } from './OperacionFuegoEntidades/positionModel';
import { satelitetopSplit } from './OperacionFuegoEntidades/sateliteTopSplit';
import { TopSecret } from './OperacionFuegoEntidades/TopSecret';

@Injectable({
  providedIn: 'root'
})
export class OperacionServiceService {
  private urlEndPoint: string = '/api/operacion';

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private router: Router) { }



  getNave(): Observable<shipModel> {
    let params = new HttpParams().set('incluirDirecciones', "true");
    return this.http.get<shipModel>(this.urlEndPoint+"/ship");
  }

  getSatellites(): Observable<sateliteModel[]> {
    let params = new HttpParams().set('incluirDirecciones', "true");
    return this.http.get<sateliteModel[]>(this.urlEndPoint+"/satelites");
  }


  getPositionSatellite(idsatelite:number): Observable<positionModel> {
    let params = new HttpParams().set('incluirDirecciones', "true");
    return this.http.get<positionModel>(this.urlEndPoint+"/satelitesposition/"+ idsatelite, {params: params});
  }


  getMenssageSatellite(nombre:string): Observable<sateliteModel> {
    let params = new HttpParams().set('incluirDirecciones', "true");
    return this.http.get<sateliteModel>(this.urlEndPoint+"/topsecret_split1/"+ nombre, {params: params});
  }

  getMenssageSatelliteTop_Split(nombre:string): Observable<satelitetopSplit> {
    let params = new HttpParams().set('incluirDirecciones', "true");
    return this.http.post<satelitetopSplit>(this.urlEndPoint+"/topsecret_split/"+ nombre, {params: params});
  }
  getMenssageSatelliteTop_Split1(nombre:string): Observable<TopSecret> {
    let params = new HttpParams().set('incluirDirecciones', "true");
    return this.http.get<TopSecret>(this.urlEndPoint+"/topsecret_split/"+ nombre, {params: params});
  }

  gettopsecret(listasatelite: sateliteModel[]): Observable<positionModel> {
    return this.http.post<positionModel>(this.urlEndPoint+"/topsecret", listasatelite);
  }

  gettopsecret1(listasatelite: sateliteModel[]): Observable<String> {
    return this.http.post<String>(this.urlEndPoint+"/topsecret1", listasatelite);
  }

  gettopsecret2(listasatelite: sateliteModel[]): Observable<TopSecret> {
    return this.http.post<TopSecret>(this.urlEndPoint+"/topsecret", listasatelite);
  }


}
