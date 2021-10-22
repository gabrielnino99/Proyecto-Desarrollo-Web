import { AgujeroDeGusano } from "./agujero-de-gusano";
import { Estrella } from "./estrella";

export class AgujeroDeGusanoEstrella {
    public id: number = 0;
    public polo: string = "";
    public estrella: Estrella = new Estrella("", 0, 0, 0, 0, 0);
    public agujeroDeGusano: AgujeroDeGusano = new AgujeroDeGusano(0, 0);

    constructor(id: number, polo: string,estrella: Estrella, agujeroDeGusano: AgujeroDeGusano){
        this.id = id;
        this.polo = polo;
        this.estrella = estrella;
        this.agujeroDeGusano = agujeroDeGusano;
    }
}