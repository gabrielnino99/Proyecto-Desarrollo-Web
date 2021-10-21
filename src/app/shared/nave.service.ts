import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Nave } from 'src/app/model/nave';
import { Estrella } from 'src/app/model/estrella';

@Injectable({
  providedIn: 'root'
})
export class NaveService {

  constructor(private http: HttpClient) { 
    }
  
  findNave(id: number) : Observable<Nave>{
    return this.http.get<Nave>("http://localhost:8080/nave/" + id);
  }

  findEstrellaNave(id: number) : Observable<Estrella>{
    return this.http.get<Estrella>("http://localhost:8080/nave/" + id + "/estrella");
  }

  updateNave(nave: Nave): Observable<Nave>{
    return this.http.put<Nave>("http://localhost:8080/updateNave", nave);
  }
}
