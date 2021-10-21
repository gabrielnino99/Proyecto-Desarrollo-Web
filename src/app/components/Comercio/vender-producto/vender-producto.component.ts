import { Component, Input, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Estrella } from 'src/app/model/estrella';
import { Nave } from 'src/app/model/nave';
import { NaveProducto } from 'src/app/model/nave-producto';
import { Planeta } from 'src/app/model/planeta';
import { PlanetaProducto } from '../../../model/planeta-producto';
import { Producto } from '../../../model/producto';
import { Transaccion } from 'src/app/model/transaccion';
import { Usuario } from 'src/app/model/usuario';
import { EstrellaService } from '../../../shared/estrella.service';
import { NaveService } from '../../../shared/nave.service';
import { NaveProductoService } from '../../../shared/nave-producto.service';
import { PlanetaProductoService } from '../../../shared/planeta-producto.service';
import { PlanetaService } from '../../../shared/planeta.service';
import { TransaccionService } from '../../../shared/transaccion.service';
import { UsuarioService } from '../../../shared/usuario.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-vender-producto',
  templateUrl: './vender-producto.component.html',
  styleUrls: ['./vender-producto.component.css']
})
export class VenderProductoComponent implements OnInit {
  estrella: Estrella = new Estrella("", 0, 0, 0, 0, 0);
  nave: Nave = new Nave("", 0, 0, 0, 0, 0, this.estrella);
  planeta: Planeta = new Planeta ("", 0, 0);
  planetaProducto: PlanetaProducto = new PlanetaProducto(
    0, 0, 0, 0, 
   new Producto("", 0, 0, 0, 0),
   new Planeta("",0,0)
  );
  usuario: Usuario = new Usuario(0,"", "", "", "", 0, 0, 0, this.nave);
  naveProducto: NaveProducto = new NaveProducto(0,0, this.nave, this.planetaProducto.producto);

  constructor(
    private estrellaService: EstrellaService,
    private naveService: NaveService,
    private naveProductoService: NaveProductoService,
    private planetaProductoService: PlanetaProductoService,
    private planetaService: PlanetaService,
    private transaccionService: TransaccionService,
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
    let id = +params.get('ppid')!;
    return this.planetaProductoService.findPlanetaProducto(id);
  }
  )).subscribe(planetasProducto => this.planetaProducto = planetasProducto);
  this.route.paramMap.pipe(switchMap(params => {
    let prid = +params.get('prid')!;
    let nid = +params.get('nid')!;
    return this.naveProductoService.findNaveProducto(nid, prid);
  }
  )).subscribe((naveProducto) => {
      this.naveProducto = naveProducto;
      console.log(naveProducto);
    },
    (error) => {
      console.log("Ocurrio un error");
    }
    );
  }

  formularioVender = new FormGroup({
    cantidad: new FormControl('', Validators.required)
  });

  vender(cantidad: string){
    let cant = +cantidad;
    let precioTotal = cant*(this.planetaProducto.factorDemanda / (1 + this.planetaProducto.stock));
    //Transaccion
    let transaccion: Transaccion = new Transaccion(0,precioTotal, 0, "venta", this.usuario);
    this.transaccionService.addTransaccion(transaccion).subscribe();
    //PlanetaProducto
    this.planetaProducto.stock = this.planetaProducto.stock + cant;
    this.planetaProductoService.updatePlanetaProducto(
      new PlanetaProducto(this.planetaProducto.id, this.planetaProducto.factorDemanda,
        this.planetaProducto.stock, this.planetaProducto.factorOferta, 
        this.planetaProducto.producto, this.planetaProducto.planeta)
    ).subscribe();
    //Usuario
    this.usuario.credito = this.usuario.credito + precioTotal; 
    this.usuarioService.updateUsuario(new Usuario(
      this.usuario.id, this.usuario.userName, this.usuario.password, this.usuario.rol, this.usuario.email,
       this.usuario.credito, this.usuario.tiempoDeJuego, this.usuario.id, this.usuario.nave)).subscribe();
    //Nave   
    this.nave.carga = this.nave.carga - this.planetaProducto.producto.metros3 * cant;
    if(this.nave.carga < 0){
      this.nave.carga = 0;
    }
    this.naveService.updateNave(new Nave(
      this.nave.nombre, this.nave.carga, 
      this.nave.cargaMaxima, this.nave.velocidad, this.nave.nid, this.nave.id, this.nave.estrella
    )).subscribe();
   //Nave Producto
    if(this.naveProducto !== null){
      console.log("No es nulo");
      this.naveProducto.cantidad = this.naveProducto.cantidad - cant;
      this.naveProductoService.updateNaveProducto(
        new NaveProducto(this.naveProducto.id, this.naveProducto.cantidad, 
          this.naveProducto.nave, this.naveProducto.producto)
      ).subscribe((mensaje) => console.log("Salio"));
    }
    else{
     /* console.log("Es nulo");
      this.naveProducto = new NaveProducto(0, cant, this.nave, this.planetaProducto.producto);
      this.naveProductoService.addNaveProducto(
        new NaveProducto(this.naveProducto.id, this.naveProducto.cantidad, 
          this.naveProducto.nave, this.naveProducto.producto)
      ).subscribe();
      this.naveProductoService.findNaveProducto(this.nave.id, this.planetaProducto.producto.id).subscribe(
        (naveProducto) => this.naveProducto = naveProducto
      );*/
    }
  }
}
