import { Component, Input, OnInit } from '@angular/core';
import { Estrella } from 'src/app/model/estrella';
import { Nave } from 'src/app/model/nave';
import { Usuario } from 'src/app/model/usuario';
import { EstrellaService } from '../../../../shared/estrella.service';
import { NaveService } from '../../../../shared/nave.service';
import { UsuarioService } from '../../../../shared/usuario.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-navegacion',
  templateUrl: './navegacion.component.html',
  styleUrls: ['./navegacion.component.css']
})
export class NavegacionComponent implements OnInit {
  selectedEstrella: Estrella = new Estrella("", 0, 0, 0, 0, 0);
  nave: Nave = new Nave("", 0, 0, 0, 0, 0, this.selectedEstrella);
  usuario: Usuario = new Usuario(0,"", "", "", "", 0, 0, 0, this.nave);
  estrellas: Estrella[] = [];

  constructor(
    private estrellaService: EstrellaService,
    private usuarioService: UsuarioService,
    private naveService: NaveService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    //Usuario 148, Nave 137
    this.route.paramMap.pipe(switchMap(params => {
      let id = +params.get('uid')!;
      return this.usuarioService.findUsuario(id);
    }
  )).subscribe(usuario => this.usuario = usuario);
    //this.usuarioService.findUsuario(148).subscribe(usuario => this.usuario = usuario);
    this.route.paramMap.pipe(switchMap(params => {
      let id = +params.get('nid')!;
      return this.naveService.findNave(id);
    }
  )).subscribe(nave => this.nave = nave);
    this.route.paramMap.pipe(switchMap(params => {
      let id = +params.get('nid')!;
      return this.naveService.findEstrellaNave(id);
    }
  )).subscribe(estrella => {
    this.selectedEstrella = estrella
    this.estrellaService.findEstrellasCercanas(this.selectedEstrella.id).subscribe(
      estrellas => this.estrellas = estrellas
    );

  
  });
    
  }

  seleccionarEstrella(estrella: Estrella){
    //Calcular distancia en KM
    let distancia = Math.sqrt(
      Math.pow(estrella.coordenadaX - this.selectedEstrella.coordenadaX,2)
      + Math.pow(estrella.coordenadaY - this.selectedEstrella.coordenadaY,2)
      + Math.pow(estrella.coordenadaZ - this.selectedEstrella.coordenadaZ,2)
      ) * (9.461 * Math.exp(12));
    //Estrella donde esta la nave
    this.selectedEstrella = estrella;
    this.nave.estrella = this.selectedEstrella;
    //Estrellas más cercanas
    this.estrellaService.findEstrellasCercanas(this.selectedEstrella.id).subscribe(
      estrellas => this.estrellas = estrellas
    );
    //Actualizar Nave
    this.naveService.updateNave(new Nave(
      this.nave.nombre, this.nave.carga, 
      this.nave.cargaMaxima, this.nave.velocidad, this.nave.nid, this.nave.id, this.nave.estrella
    )).subscribe();
    //Actualizar Usuario con el tiempo medido en dias
    this.usuario.tiempoDeJuego =  this.usuario.tiempoDeJuego + ((distancia / this.nave.velocidad) * (1 / 86400) );
    this.usuarioService.updateUsuario(new Usuario(
      this.usuario.id, this.usuario.userName, this.usuario.password, this.usuario.rol, this.usuario.email,
       this.usuario.credito, this.usuario.tiempoDeJuego, this.usuario.id, this.usuario.nave)).subscribe(); 
  }

}