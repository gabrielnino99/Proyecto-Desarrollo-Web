import { Component, Input, OnInit } from '@angular/core';
import { Estrella } from 'src/app/model/estrella';
import { Nave } from 'src/app/model/nave';
import { Planeta } from 'src/app/model/planeta';
import { Usuario } from 'src/app/model/usuario';
import { AgujeroDeGusano } from 'src/app/model/agujero-de-gusano';
import { EstrellaService } from '../../../../shared/estrella.service';
import { UsuarioService } from '../../../../shared/usuario.service';
import { NaveService } from '../../../../shared/nave.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-planeta',
  templateUrl: './planeta.component.html',
  styleUrls: ['./planeta.component.css']
})
export class PlanetaComponent implements OnInit {
  agujerosDeGusano: AgujeroDeGusano[] = [new AgujeroDeGusano(9999)];
  estrella: Estrella = new Estrella("", 0, 0, 0, 0, 0);
  nave: Nave = new Nave("", 0, 0, 0, 0, 0, this.estrella);
  usuario: Usuario = new Usuario(0,"", "", "", "", 0, 0, 0, this.nave);
  planetas: Planeta[] = [];

  constructor (
    private estrellaService: EstrellaService,
    private naveService: NaveService,
    private usuarioService: UsuarioService,
    private route: ActivatedRoute
  ){}

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
      let id = +params.get('eid')!;
      return this.estrellaService.findPlanetasEstrella(id);
    }
  )).subscribe(planetas => this.planetas = planetas);
    
  }

}
