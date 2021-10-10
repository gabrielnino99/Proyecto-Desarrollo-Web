export class Nave {
    public nombre: string = "";
    public carga: number = 0;
    public velocidad: number = 0;
    public nid: number = 0;

    constructor(nombre: string, carga: number, velocidad: number, nid: number){
        this.nombre = nombre;
        this.carga = carga;
        this.velocidad = velocidad;
        this.nid = nid;
    }
}
