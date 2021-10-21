import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { NaveProducto } from 'src/app/model/nave-producto';

@Injectable({
  providedIn: 'root'
})
export class NaveProductoService {

  constructor(private http: HttpClient) { }

  findNaveProducto(nid: number, prid: number) : Observable<NaveProducto>{
    return this.http.get<NaveProducto>("http://localhost:8080/naveProducto/" + nid + "/" + prid);
  }

  updateNaveProducto(naveProducto: NaveProducto): Observable<NaveProducto>{
    return this.http.put<NaveProducto>("http://localhost:8080/updateNaveProducto", naveProducto);
  }
  addNaveProducto(naveProducto: NaveProducto): Observable<NaveProducto>{
    return this.http.post<NaveProducto>("http://localhost:8080/addNaveProducto", naveProducto);
  }
}
