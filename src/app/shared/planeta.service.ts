import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Planeta } from 'src/app/model/planeta';
import { PlanetaProducto } from 'src/app/model/planeta-producto';
import { Producto } from 'src/app/model/producto';



@Injectable({
  providedIn: 'root'
})
export class PlanetaService {

  constructor(private http: HttpClient) { }

  findPlaneta(id: number) : Observable<Planeta>{
    return this.http.get<Planeta>("http://localhost:8080/planeta/" + id);
  }

  findProductosPlaneta(id: number) : Observable<Producto[]>{
    return this.http.get<Producto[]>("http://localhost:8080/planeta/" + id + "/productos");
  }

  findProductosPlanetas(id: number) : Observable<PlanetaProducto[]>{
    return this.http.get<PlanetaProducto[]>("http://localhost:8080/planeta/" + id + "/planetas-productos");
  }
}
