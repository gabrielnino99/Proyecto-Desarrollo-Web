import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard.component';
import { AgujeroDeGusanoComponent } from './Navegacion/agujero-de-gusano/agujero-de-gusano.component';
import { NavegacionComponent } from './Navegacion/navegacion/navegacion.component';
import { PlanetaComponent } from './Navegacion/planeta/planeta.component';
import { ProductoComponent } from './Comercio/producto/producto.component';
import { ComprarProductoComponent } from './Comercio/comprar-producto/comprar-producto.component';
import { VenderProductoComponent } from './Comercio/vender-producto/vender-producto.component';

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent,
    children: [
      { path: '', component: HomeComponent },
      { path: 'planetas', component: PlanetaComponent },
      { path: 'usuario/:uid/navegacion/:nid', component: NavegacionComponent },
      {
        path: 'usuario/:uid/navegacion/:nid/estrella/:eid',
        component: PlanetaComponent,
      },
      {
        path: 'usuario/:uid/navegacion/:nid/estrella/:eid/planeta/:plid',
        component: ProductoComponent,
      },
      {
        path: 'usuario/:uid/navegacion/:nid/estrella/:eid/agujeroDeGusano/:aid',
        component: AgujeroDeGusanoComponent,
      },
      {
        path: 'usuario/:uid/navegacion/:nid/estrella/:eid/planeta/:plid/planeta-producto/:prid/comprar/:ppid',
        component: ComprarProductoComponent,
      },
      {
        path: 'usuario/:uid/navegacion/:nid/estrella/:eid/planeta/:plid/planeta-producto/:prid/vender/:ppid',
        component: VenderProductoComponent,
      },
    ],
  },
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DashboardRoutingModule {}
