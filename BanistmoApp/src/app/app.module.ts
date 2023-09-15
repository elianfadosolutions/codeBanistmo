import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {} from '@angular/platform-browser/animations';
import { HttpClientModule} from "@angular/common/http";
import { FormsModule} from '@angular/forms';

import { NgxSpinnerModule } from "ngx-spinner";
import { ListClienteServiciosComponent } from './clienteServicios/list-cliente-servicios.component';
import { DetailClienteComponent } from './cliente/detail-cliente.component';
import { ListClienteComponent } from './cliente/list-cliente.component';
import { CreateClienteComponent } from './cliente/create-cliente.component';
import { UpdateComercialComponent } from './comercial/update-comercial.component';

@NgModule({
  declarations: [
    AppComponent,
    ListClienteServiciosComponent,
    DetailClienteComponent,
    ListClienteComponent,
    CreateClienteComponent,
    UpdateComercialComponent
  ],
  imports: [
    BrowserModule,
    NgxSpinnerModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
