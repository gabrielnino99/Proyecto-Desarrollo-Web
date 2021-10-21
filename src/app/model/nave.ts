import { Estrella } from "./estrella";

export class Nave {
    public nombre: string = "";
    public carga: number = 0;
    public cargaMaxima: number = 0;
    public velocidad: number = 0;
    public nid: number = 0;
    public id: number = 0;
    public estrella: Estrella = new Estrella("", 0, 0, 0, 0, 0);

    constructor(nombre: string, carga: number, cargaMaxima: number, velocidad: number, nid: number, id: number, estrella: Estrella){
        this.nombre = nombre;
        this.carga = carga;
        this.cargaMaxima = cargaMaxima;
        this.velocidad = velocidad;
        this.nid = nid;
        this.id = id;
        this.estrella = estrella;
    }
}
