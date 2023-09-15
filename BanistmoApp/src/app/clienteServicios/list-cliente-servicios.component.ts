import { Component } from '@angular/core';
import { ClienteServicioService } from '../services/cliente-servicio.service';
import { Cliente } from '../models/cliente';

@Component({
  selector: 'app-list-cliente-servicios',
  templateUrl: './list-cliente-servicios.component.html',
  styleUrls: ['./list-cliente-servicios.component.css']
})
export class ListClienteServiciosComponent {
  constructor(private clienteServicio: ClienteServicioService){
  }
  clientes: Cliente[]=[];
  ngOnInit(): void{
    this.clienteServicio.list().subscribe(data =>{
      this.clientes = data;
    })
  }
}
