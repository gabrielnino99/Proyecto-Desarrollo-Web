import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NavegacionComponent } from './Navegacion/navegacion/navegacion.component';
import { PlanetaComponent } from './Navegacion/planeta/planeta.component';
import { VenderProductoComponent } from './Comercio/vender-producto/vender-producto.component';
import { ComprarProductoComponent } from './Comercio/comprar-producto/comprar-producto.component';
import { ProductoComponent } from './Comercio/producto/producto.component';
import { DashboardComponent } from './dashboard.component';
import { SharedModule } from '../shared/shared.module';
import { AgujeroDeGusanoComponent } from './Navegacion/agujero-de-gusano/agujero-de-gusano.component';


@NgModule({
  declarations: [
    DashboardComponent,
    HomeComponent,
    NavbarComponent, 
    NavegacionComponent,
    PlanetaComponent,
    VenderProductoComponent,
    ComprarProductoComponent,
    ProductoComponent,
    AgujeroDeGusanoComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    SharedModule
  ]
})
export class DashboardModule { }