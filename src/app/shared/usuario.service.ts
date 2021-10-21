import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Usuario } from 'src/app/model/usuario';
import { Nave } from 'src/app/model/nave';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }
  findUsuario(id: number) : Observable<Usuario>{
    return this.http.get<Usuario>("http://localhost:8080/usuario/" + id);
  }

  findNaveUsuario(id: number) : Observable<Nave>{
    return this.http.get<Nave>("http://localhost:8080/usuario/" + id + "/nave");
  }

  updateUsuario(usuario: Usuario): Observable<Usuario>{
    return this.http.put<Usuario>("http://localhost:8080/updateUsuario", usuario);
  }
}
