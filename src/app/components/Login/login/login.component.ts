import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/shared/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  loading = false;

  constructor(
    private authService: LoginService,
    private fb: FormBuilder,
    private _snackBar: MatSnackBar,
    private _router: Router
  ) {
    this.form = this.fb.group({
      usuario: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  ngOnInit(): void {}

  ingresar() {
    const usuario = this.form.value.usuario;
    const password = this.form.value.password;

    if (usuario == 'entrega2' && password == 'password') {
      this.loginExitoso(usuario);
      this.loading = true;
      this._router.navigate(['/dashboard']);
    } else {
      this.errorLogin();
    }
  }

  doLogin() {
    const user = this.form.value.usuario;
    const password = this.form.value.password;
    console.log(user + '-' + password);
    this.authService.login(user, password).subscribe(
      (data) => {
        console.log(data);
        this.loginExitoso(user);
        console.log('ok');
        this.loading = true;
        this._router.navigate(['/dashboard/user/', user]);
      },
      (error) => {
        console.log(JSON.stringify(error));
      }
    );
  }

  loginExitoso(usuario: string) {
    this._snackBar.open('Bienvenido ' + usuario, '', {
      duration: 5000,
      horizontalPosition: 'center',
      verticalPosition: 'bottom',
    });
  }

  errorLogin() {
    this._snackBar.open('Usuario o contraseña inválidos', '', {
      duration: 5000,
      horizontalPosition: 'center',
      verticalPosition: 'bottom',
    });
    this.form.reset();
  }
}
