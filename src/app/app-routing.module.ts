import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearUsuarioComponent } from './components/CrudUsuario/crear-usuario/crear-usuario.component';
import { LoginComponent } from './components/Login/login/login.component';
import { NavegacionComponent } from './components/Navegacion/navegacion/navegacion.component';
import { PlanetaComponent } from './components/Navegacion/planeta/planeta.component';
import { ProductoComponent } from './components/Comercio/producto/producto.component';
import { ComprarProductoComponent } from './components/Comercio/comprar-producto/comprar-producto.component';
import { VenderProductoComponent } from './components/Comercio/vender-producto/vender-producto.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path: 'login', component: LoginComponent},
  {path: 'registro', component: CrearUsuarioComponent},
  {path: 'usuario/:uid/navegacion/:nid', component: NavegacionComponent},
  {path: 'usuario/:uid/navegacion/:nid/estrella/:eid', component: PlanetaComponent},
  {path: 'usuario/:uid/navegacion/:nid/estrella/:eid/planeta/:plid', component: ProductoComponent},
  {path: 'usuario/:uid/navegacion/:nid/estrella/:eid/planeta/:plid/planeta-producto/:prid/comprar/:ppid', component: ComprarProductoComponent},
  {path: 'usuario/:uid/navegacion/:nid/estrella/:eid/planeta/:plid/planeta-producto/:prid/vender/:ppid', component: VenderProductoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
