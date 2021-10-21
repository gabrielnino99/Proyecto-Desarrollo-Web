import { Estrella } from './estrella';
import { Nave } from './nave';
import { Usuario } from './usuario';

export class Transaccion {
    public id: number = 0;
    public precioTotal: number = 0;
    public tid: number = 0;
    public tipo: string = "";
    public usuario: Usuario = new Usuario(0, "", "", "", "", 0, 0, 0, 
    new Nave(
        "", 0, 0, 0, 0, 0, new Estrella("", 0, 0, 0, 0, 0)
        )
    );


    constructor(id: number, precioTotal: number, tid: number, tipo: string, usuario: Usuario){
        this.id = id;
        this.precioTotal = precioTotal;
        this.tid = tid;
        this.tipo = tipo;
        this.usuario = usuario;
    }
}
