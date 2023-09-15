import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { Cliente } from '../models/cliente';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class ClienteServicioService {

  clienteServiceURL = environment.clienteServiceURL;
  constructor(private httpClient:HttpClient) { 
    
  }
  public list(): Observable<Cliente[]>{
      return this.httpClient.get<Cliente[]>(this.clienteServiceURL);
  }
  
}
