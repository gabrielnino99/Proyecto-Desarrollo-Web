export class Estrella {
    public nombre: string = "";
    public coordenadaX: number = 0;
    public coordenadaY: number = 0;
    public coordenadaZ: number = 0;
    public eid: number = 0;

    constructor(nombre: string, coordenadaX: number, coordenadaY: number,
        coordenadaZ: number, eid: number){
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.coordenadaZ = coordenadaZ;
        this.eid = eid;
    }
}
