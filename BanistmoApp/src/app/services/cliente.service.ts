import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../models/cliente';
import { Observable } from 'rxjs'
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  clienteURL = environment.clienteURL;
  constructor(private httpClient:HttpClient) { 
    
  }
  public list(): Observable<Cliente[]>{
      return this.httpClient.get<Cliente[]>(this.clienteURL);
  }
  
  public update(cliente:Cliente){
    return this.httpClient.post<Cliente>(this.clienteURL,cliente);
  } 

  public create(cliente: Cliente){
    return this.httpClient.post<Cliente>(this.clienteURL,cliente);
  }

}
