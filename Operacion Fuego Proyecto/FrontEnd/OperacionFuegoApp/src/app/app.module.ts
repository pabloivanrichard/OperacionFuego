import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { DatePipe, registerLocaleData } from '@angular/common';
import localeES from '@angular/common/locales/es';
import { OperacionfuegoComponent } from './operacionfuego/operacionfuego.component';
import { SolucionComponent } from './solucion/solucion.component';
import { FinalizarComponent } from './finalizar/finalizar.component';



registerLocaleData(localeES, 'es');

const routes: Routes = [
      /*Operacion Fuego */
      { path: 'operacionfuego', component: OperacionfuegoComponent },
       /*Operacion Fuego Solucion */
       { path: 'solucion', component: SolucionComponent },
          /*Operacion Fuego Fin */
          { path: 'fin', component: FinalizarComponent },
  

  

];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    OperacionfuegoComponent,
    SolucionComponent,
    FinalizarComponent,   
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    DatePipe, 
        { provide: LOCALE_ID, useValue: 'es' }
 

],
  bootstrap: [AppComponent]
})
export class AppModule { }
