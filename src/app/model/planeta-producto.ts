import { Producto } from 'src/app/model/producto';
import { Planeta } from 'src/app/model/planeta';
export class PlanetaProducto {
   public id: number = 0;
   public factorDemanda: number = 0;
   public stock: number = 0;
   public factorOferta: number = 0;
   public producto: Producto = new Producto("", 0, 0, 0, 0);
   public planeta: Planeta =  new Planeta("", 0, 0);
    constructor(id: number, factorDemanda: number, stock: number, factorOferta: number, producto: Producto, planeta: Planeta){
            this.factorDemanda = factorDemanda;
            this.stock = stock;
            this.factorOferta = factorOferta;
            this.id = id;
            this.producto = producto;
            this.planeta = planeta;
    }
}
