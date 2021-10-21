import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Transaccion } from 'src/app/model/transaccion';

@Injectable({
  providedIn: 'root'
})
export class TransaccionService {

  constructor(private http: HttpClient) { }

  addTransaccion(transaccion: Transaccion): Observable<Transaccion>{
    return this.http.post<Transaccion>("http://localhost:8080/addTransaccion", transaccion);
  }
}
