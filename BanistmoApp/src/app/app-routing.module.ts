import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListClienteComponent } from './cliente/list-cliente.component';
import { DetailClienteComponent } from './cliente/detail-cliente.component';
import { CreateClienteComponent } from './cliente/create-cliente.component';
import { ListClienteServiciosComponent } from './clienteServicios/list-cliente-servicios.component';
import { UpdateComercialComponent } from './comercial/update-comercial.component';

const routes: Routes = [
  {path: '', component:ListClienteComponent},
  {path: 'detailsCliente', component:DetailClienteComponent},
  {path: 'createCliente', component:CreateClienteComponent},
  {path: "listClienteServicio", component:ListClienteServiciosComponent},
  {path: "modifComenrcial", component:UpdateComercialComponent},
  {path: '**', redirectTo:'',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
