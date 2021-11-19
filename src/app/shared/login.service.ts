import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Usuario } from '../model/usuario';

import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private isAuth = false;
  constructor(private http: HttpClient) {}

  getIsAuth() {
    return this.isAuth;
  }

  login(username: string, password: string) {
    const formHeaders = new HttpHeaders();
    formHeaders.append('Content-Type', 'application/x-www-form-urlencoded');
    const formParams = new HttpParams()
      .set('username', username)
      .set('password', password);
    return this.http
      .post('http://localhost:8080/login', null, {
        headers: formHeaders,
        params: formParams,
        withCredentials: true,
      })
      .pipe(
        map((res: any) => {
          console.log(res);
          this.isAuth = true;
          this.saveAuthData(username);
        })
      );
  }

  private saveAuthData(username: string) {
    sessionStorage.setItem('username', username);
    // sessionStorage.setItem('Rol', rol);
  }

  getAuthData() {
    const user = sessionStorage.getItem('username');

    if (!user) {
      return;
    }
    return {
      message: 'Este es el usuario',
      user,
    };
  }

  clearAuthData() {
    sessionStorage.removeItem('username');
  }

  logout() {
    this.isAuth = false;
    return this.http
      .post('http://localhost:8080/logout', '', {
        withCredentials: true,
      })
      .pipe(
        map((res) => {
          this.clearAuthData();
        })
      );
  }
}
