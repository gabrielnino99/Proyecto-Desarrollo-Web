import { Component, OnInit } from '@angular/core';
import { Estrella } from 'src/app/model/estrella';
import { Nave } from 'src/app/model/nave';
import { Usuario } from 'src/app/model/usuario';

@Component({
  selector: 'app-navegacion',
  templateUrl: './navegacion.component.html',
  styleUrls: ['./navegacion.component.css']
})
export class NavegacionComponent implements OnInit {
  usuario: Usuario = new Usuario(11,"Nova", "1", "capitan", "nova@gmail.com", 0, 0);
  nave: Nave = new Nave("Prometeo", 0, 300, 21);
  estrellas: Estrella[] = [
    new Estrella("Spica", 10, 10, 10, 1),
    new Estrella("Aldebaran", 20, 20, 20, 2),
    new Estrella("Polaris", 30, 30, 30, 3)
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
