import { Estrella } from './estrella';
import { Nave } from "./nave";
import { Producto } from "./producto";

export class NaveProducto {
    public id: number = 0;
    public cantidad: number = 0;
    public nave: Nave = new Nave("", 0, 0, 0, 0, 0, new Estrella("", 0, 0, 0, 0, 0));
    public producto: Producto = new Producto("", 0, 0, 0, 0);

    constructor(id: number, cantidad: number, nave: Nave, producto: Producto){
        this.id = id;
        this.cantidad = cantidad;
        this.nave = nave;
        this.producto = producto;
    }
}
