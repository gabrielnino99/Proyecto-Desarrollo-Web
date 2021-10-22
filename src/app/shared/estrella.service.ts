import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { AgujeroDeGusanoEstrella } from "src/app/model/agujero-de-gusano-estrella";
import { Estrella } from 'src/app/model/estrella';
import { Planeta } from 'src/app/model/planeta';

@Injectable({
  providedIn: 'root'
})
export class EstrellaService {

  constructor(private http: HttpClient) { }

  private estrellaDB: {[key: number]: Estrella} = {
    0: new Estrella("Elnath", 30, 30, 30, 0, 0),
    1: new Estrella("Spica", 10, 10, 10, 1, 1),
    2: new Estrella("Aldebaran", 20, 20, 20, 2, 2),
    3: new Estrella("Polaris", 30, 30, 30, 3, 3),
    4: new Estrella("Antares", 10, 10, 10, 4, 4),
    5: new Estrella("Altair", 20, 20, 20, 5, 5),
    6: new Estrella("Betelgeuse", 30, 30, 30, 6, 6),
    7: new Estrella("Alfa Centauri A", 10, 10, 10, 7, 7),
    8: new Estrella("Rigel", 20, 20, 20, 8, 8),
    9: new Estrella("Pollux", 30, 30, 30, 9, 9),
    10: new Estrella("Regulus", 10, 10, 10, 10, 10),
    11: new Estrella("Sirio", 10, 10, 10, 11, 11),
    12: new Estrella("Arturo", 20, 20, 20, 12, 12),
    13: new Estrella("Vega", 30, 30, 30, 13, 13),
    14: new Estrella("Bellatrix", 30, 30, 30, 14, 14)
  };

  findAll(): Observable<Estrella[]>{
    return of(Object.values(this.estrellaDB));
  }

  findByEid(eid: number): Observable<Estrella>{
    return of(this.estrellaDB[eid]);
  }

  findEstrella(id: number) : Observable<Estrella>{
    return this.http.get<Estrella>("http://localhost:8080/estrella/" + id);
  }

  findPlanetasEstrella(id: number) : Observable<Planeta[]>{
    return this.http.get<Planeta[]>("http://localhost:8080/estrella/" + id + "/planetas");
  }

  findAgujeroDeGusanoEstrella(id: number) : Observable<AgujeroDeGusanoEstrella>{
    return this.http.get<AgujeroDeGusanoEstrella>("http://localhost:8080/estrella/" + id + "/agujerosDeGusano");
  }

  findEstrellasCercanas(id: number) : Observable<Estrella[]>{
    return this.http.get<Estrella[]>("http://localhost:8080/estrellasCercanas/" + id);
  }
}
