import { Component } from '@angular/core';
import { Cliente } from '../models/cliente';
import { ActivatedRoute } from "@angular/router"

@Component({
  selector: 'app-detail-cliente',
  templateUrl: './detail-cliente.component.html',
  styleUrls: ['./detail-cliente.component.css']
})
export class DetailClienteComponent {

  cliente: Cliente | null= null;
  constructor(private activatedRoute:ActivatedRoute){
  }

  ngOnInit():void{
    this.activatedRoute.queryParams.subscribe(cli =>{
      
      this.cliente = new Cliente(cli['codigo'],cli['nombre_completo'],cli['clave_acceso'], cli['ingresos'], cli['ciudad'], cli['edad']);
      
    });
  }

}
