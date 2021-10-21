import { Nave } from "./nave";
import { AgujeroDeGusano } from "./agujero-de-gusano";

export class Estrella {
    public nombre: string = "";
    public coordenadaX: number = 0;
    public coordenadaY: number = 0;
    public coordenadaZ: number = 0;
    public eid: number = 0;
    public id: number = 0;

    constructor(nombre: string, coordenadaX: number, coordenadaY: number,
        coordenadaZ: number, eid: number, id: number){
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.coordenadaZ = coordenadaZ;
        this.eid = eid;
        this.id = id;
    }
}
