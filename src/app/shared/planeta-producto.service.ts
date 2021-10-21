import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { PlanetaProducto } from 'src/app/model/planeta-producto';

@Injectable({
  providedIn: 'root'
})
export class PlanetaProductoService {

  constructor(private http: HttpClient) { }

  findPlanetaProducto(id: number) : Observable<PlanetaProducto>{
    return this.http.get<PlanetaProducto>("http://localhost:8080/planetaProducto/" + id);
  }

  updatePlanetaProducto(planetaProducto: PlanetaProducto): Observable<PlanetaProducto>{
    return this.http.put<PlanetaProducto>("http://localhost:8080/updatePlanetaProducto", planetaProducto);
  }
}
