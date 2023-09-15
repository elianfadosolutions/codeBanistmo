import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../services/cliente.service';
import { Cliente } from '../models/cliente';

@Component({
  selector: 'app-list-cliente',
  templateUrl: './list-cliente.component.html',
  styleUrls: ['./list-cliente.component.css']
})
export class ListClienteComponent {

  clientes: Cliente[]=[];
  constructor(private clienteService: ClienteService){
  }

  ngOnInit(): void{
    this.clienteService.list().subscribe(data =>{
      this.clientes = data;
    })
  }
}
