export class Usuario {
    public uid: number = 0;
    public userName: string = "";
    public password: string = "";
    public rol: string = "";
    public email: string = "";
    public credito: number = 0;
    public tiempoDeJuego: number = 0;

    constructor(uid: number, userName: string, password: string, rol: string, email: string,
        credito: number, tiempoDeJuego: number){
            this.uid = uid;
            this.userName = userName;
            this.password = password;
            this.rol = rol;
            this.email = email;
            this.credito = credito;
            this.tiempoDeJuego = tiempoDeJuego;
    }
}
