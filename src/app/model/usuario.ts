import { Estrella } from "./estrella";
import { Nave } from "./nave";

export class Usuario {
    public uid: number = 0;
    public userName: string = "";
    public password: string = "";
    public rol: string = "";
    public email: string = "";
    public credito: number = 0;
    public tiempoDeJuego: number = 0;
    public id: number = 0;
    public nave: Nave = new Nave(
        "", 0, 0, 0, 0, 0, new Estrella("", 0, 0, 0, 0, 0)
        );

    constructor(uid: number, userName: string, password: string, rol: string, email: string,
        credito: number, tiempoDeJuego: number, id: number, nave: Nave){
            this.uid = uid;
            this.userName = userName;
            this.password = password;
            this.rol = rol;
            this.email = email;
            this.credito = credito;
            this.tiempoDeJuego = tiempoDeJuego;
            this.id = id;
            this.nave = nave;
    }
}
