export class Producto {
    public nombre: string = "";
    public prid: number = 0;
    public column: number = 0;
    public metros3: number = 0;
    public id: number = 0;
    constructor(nombre: string, prid: number, column: number, metros3: number, id: number){
            this.nombre = nombre;
            this.prid = prid;
            this.column = column;
            this.metros3 = metros3;
            this.id = id;
    }
}
