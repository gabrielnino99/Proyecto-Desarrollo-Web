import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/shared/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  constructor(private _router: Router, private authService: LoginService) {}

  ngOnInit(): void {}

  logout() {
    this.authService.logout().subscribe(
      (data) => {
        this._router.navigate(['/login']);
        console.log('logout ok');
      },
      (error) => {
        console.error(error);
        console.log(JSON.stringify(error));
      }
    );
  }
}
