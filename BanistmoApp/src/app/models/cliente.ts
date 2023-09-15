export class Cliente {

    codigo: string;
    nombre_completo: string;
    clave_acceso: string;
    ingresos: number;
    ciudad: string;
    edad: number; 
    
    constructor(codigo: string, nombre_completo:string, clave_acceso:string, ingresos: number, ciudad:string, edad:number){
        this.codigo=codigo;
        this.nombre_completo=nombre_completo;
        this.clave_acceso=clave_acceso;
        this.ingresos=ingresos;
        this.ciudad=ciudad;
        this.edad=edad;
    }
}

