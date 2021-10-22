import { Component, OnInit } from '@angular/core';
import { Estrella } from 'src/app/model/estrella';
import { Nave } from 'src/app/model/nave';
import { Usuario } from 'src/app/model/usuario';
import { AgujeroDeGusano } from 'src/app/model/agujero-de-gusano';
import { AgujeroDeGusanoEstrella } from 'src/app/model/agujero-de-gusano-estrella';
import { AgujeroDeGusanoEstrellaService } from '../../../../shared/agujero-de-gusano-estrella.service';
import { EstrellaService } from '../../../../shared/estrella.service';
import { UsuarioService } from '../../../../shared/usuario.service';
import { NaveService } from '../../../../shared/nave.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-agujero-de-gusano',
  templateUrl: './agujero-de-gusano.component.html',
  styleUrls: ['./agujero-de-gusano.component.css']
})
export class AgujeroDeGusanoComponent implements OnInit {

  estrella: Estrella = new Estrella("", 0, 0, 0, 0, 0);
  agujeroDeGusanoEstrella: AgujeroDeGusanoEstrella = 
  new AgujeroDeGusanoEstrella(0, "", this.estrella, 
  new AgujeroDeGusano(0, 0));
  nave: Nave = new Nave("", 0, 0, 0, 0, 0, this.estrella);
  usuario: Usuario = new Usuario(0,"", "", "", "", 0, 0, 0, this.nave);

  constructor(
    private agujeroDeGusanoEstrellaService:AgujeroDeGusanoEstrellaService,
    private estrellaService: EstrellaService,
    private naveService: NaveService,
    private usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(switchMap(params => {
      let id = +params.get('uid')!;
      return this.usuarioService.findUsuario(id);
    }
  )).subscribe(usuario =>  this.usuario = usuario);
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
      let id = +params.get('aid')!;
      return this.agujeroDeGusanoEstrellaService.findAgujeroDeGusanoEstrella(id);
    }
  )).subscribe(agujeroDeGusanoEstrella => {
    this.agujeroDeGusanoEstrella = agujeroDeGusanoEstrella;
  });
 
  }

  salir(estrella: Estrella){
    //Nave   
    this.nave.estrella = estrella;
    this.naveService.updateNave(new Nave(
      this.nave.nombre, this.nave.carga, 
      this.nave.cargaMaxima, this.nave.velocidad, this.nave.nid, this.nave.id, this.nave.estrella
    )).subscribe();
    //Usuario
    let distancia = 9.461 * Math.exp(12);
      this.usuario.tiempoDeJuego =  this.usuario.tiempoDeJuego + ((distancia / this.nave.velocidad) * (1 / 86400) );
    this.usuarioService.updateUsuario(new Usuario(
      this.usuario.id, this.usuario.userName, this.usuario.password, this.usuario.rol, this.usuario.email,
       this.usuario.credito, this.usuario.tiempoDeJuego, this.usuario.id, this.usuario.nave)).subscribe(); 
    
       this._router.navigate(['/dashboard/usuario', this.usuario.id,'navegacion', this.nave.id,'estrella', estrella.id]);
  }

}
