import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estrella } from 'src/app/model/estrella';
import { Nave } from 'src/app/model/nave';
import { Usuario } from 'src/app/model/usuario';
import { LoginService } from 'src/app/shared/login.service';
import { UsuarioService } from 'src/app/shared/usuario.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  private username = '';
  private stored = '';

  estrella: Estrella = new Estrella('', 0, 0, 0, 0, 0);
  nave: Nave = new Nave('', 0, 0, 0, 0, 0, this.estrella);
  usuario: Usuario = new Usuario(0, '', '', '', '', 0, 0, 0, this.nave);

  constructor(
    private _router: Router,
    private authService: LoginService,
    private usuarioService: UsuarioService
  ) {}

  ngOnInit(): void {
    this.stored = this.authService.getAuthData()?.user!;
    console.log('Username: ', this.stored);
    this.encontrarUser(this.stored);
  }

  encontrarUser(username: string) {
    this.usuarioService.findUsuarioByUsername(username).subscribe((res) => {
      this.usuario = res;
      console.log('Encontrado: ', this.usuario);
    });
  }

  redirigir() {
    this._router.navigate([
      '/dashboard/usuario/:uid/navegacion/:nid',
      { uid: this.usuario.id, nid: this.nave.nid },
    ]);
  }
}
