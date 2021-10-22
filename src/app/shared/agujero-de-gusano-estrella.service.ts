import { AgujeroDeGusanoEstrella } from 'src/app/model/agujero-de-gusano-estrella';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AgujeroDeGusanoEstrellaService {

  constructor(private http: HttpClient) { }

  findAgujeroDeGusanoEstrella(id: number) : Observable<AgujeroDeGusanoEstrella>{
    return this.http.get<AgujeroDeGusanoEstrella>("http://localhost:8080/agujeroDeGusanoEstrella/" + id);
  }
}
