import { Component, Input, OnInit } from '@angular/core';
import { Estrella } from 'src/app/model/estrella';
import { Nave } from 'src/app/model/nave';
import { Planeta } from 'src/app/model/planeta';
import { PlanetaProducto } from '../../../model/planeta-producto';
import { Producto } from '../../../model/producto';
import { Usuario } from 'src/app/model/usuario';
import { EstrellaService } from '../../../shared/estrella.service';
import { NaveService } from '../../../shared/nave.service';
import { PlanetaService } from '../../../shared/planeta.service';
import { UsuarioService } from '../../../shared/usuario.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {
  estrella: Estrella = new Estrella("", 0, 0, 0, 0, 0);
  nave: Nave = new Nave("", 0, 0, 0, 0, 0, this.estrella);
  planeta: Planeta = new Planeta ("", 0, 0);
  planetasProductos: PlanetaProducto[] = [];
  selectedPlanetaProducto: PlanetaProducto = new PlanetaProducto(
    0, 0, 0, 0, 
   new Producto("", 0, 0, 0, 0),
   new Planeta("",0,0)
  );
  usuario: Usuario = new Usuario(0,"", "", "", "", 0, 0, 0, this.nave);
  constructor(
    private estrellaService: EstrellaService,
    private naveService: NaveService,
    private planetaService: PlanetaService,
    private usuarioService: UsuarioService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(switchMap(params => {
      let id = +params.get('uid')!;
      return this.usuarioService.findUsuario(id);
    }
  )).subscribe(usuario => this.usuario = usuario);
    this.route.paramMap.pipe(switchMap(params => {
      let id = +params.get('nid')!;
      return this.naveService.findNave(id);
    }
  )).subscribe(nave => this.nave = nave);
    this.route.paramMap.pipe(switchMap(params => {
      let id = +params.get('eid')!;
      return this.estrellaService.findEstrella(id);
    }
  )).subscribe(estrella => this.estrella = estrella);
    this.route.paramMap.pipe(switchMap(params => {
      let id = +params.get('plid')!;
      return this.planetaService.findPlaneta(id);
    }
  )).subscribe(planeta => this.planeta = planeta);

  this.route.paramMap.pipe(switchMap(params => {
    let id = +params.get('plid')!;
    return this.planetaService.findProductosPlanetas(id);
  }
)).subscribe(planetasProductos => this.planetasProductos = planetasProductos);
  }

  seleccionarProducto(planetaProducto: PlanetaProducto){
    this.selectedPlanetaProducto = planetaProducto;
  }
}
