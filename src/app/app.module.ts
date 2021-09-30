import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/Login/login/login.component';
import { CrearUsuarioComponent } from './components/CrudUsuario/crear-usuario/crear-usuario.component';
import { ComprarProductoComponent } from './components/Comercio/comprar-producto/comprar-producto.component';
import { ProductoComponent } from './components/Comercio/producto/producto.component';
import { VenderProductoComponent } from './components/Comercio/vender-producto/vender-producto.component';
import { PlanetaComponent } from './components/Navegacion/planeta/planeta.component';
import { EstrellaComponent } from './components/Navegacion/estrella/estrella.component';
import { NaveComponent } from './components/Navegacion/nave/nave.component';
import { LogoutComponent } from './components/Logout/logout/logout.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CrearUsuarioComponent,
    ComprarProductoComponent,
    ProductoComponent,
    VenderProductoComponent,
    PlanetaComponent,
    EstrellaComponent,
    NaveComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
