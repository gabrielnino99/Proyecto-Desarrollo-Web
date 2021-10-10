import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearUsuarioComponent } from './components/CrudUsuario/crear-usuario/crear-usuario.component';
import { LoginComponent } from './components/Login/login/login.component';
import { NavegacionComponent } from './components/Navegacion/navegacion/navegacion.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path: 'login', component: LoginComponent},
  {path: 'registro', component: CrearUsuarioComponent},
  {path: 'navegacion', component: NavegacionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
