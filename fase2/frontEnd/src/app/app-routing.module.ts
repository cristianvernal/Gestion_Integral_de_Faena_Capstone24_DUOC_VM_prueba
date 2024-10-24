import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MsalGuard } from '@azure/msal-angular';
import { HomeComponent } from './authentication/home/home.component';
import { UsuarioComponent } from './business/usuario/usuario.component';
import { DashboardComponent } from './business/dashboard/dashboard.component';
import  VerificacionComponent  from './business/verificacion/verificacion.component';
import RegistroComponent from './business/registro/registro.component';
import { ReportesComponent } from './business/reportes/reportes.component';
import AgregarTrabajadorComponent from './shared/components/agregar-trabajador/agregar-trabajador.component';
import  CrearFaenaComponent  from './shared/components/crear-faena/crear-faena.component';



const routes: Routes = [
 
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'verificacion',
    component: VerificacionComponent,
    canActivate: [MsalGuard]
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [MsalGuard]
  },
  {
    path: 'usuario',
    component: UsuarioComponent,
    canActivate: [MsalGuard]
  },
  {
    path: 'registro',
    component: RegistroComponent,
    canActivate: [MsalGuard]
  },
  {
    path: 'reportes',
    component: ReportesComponent,
    canActivate: [MsalGuard]
  },
  {
    path:'agregar-trabajador',
    component: AgregarTrabajadorComponent,
    canActivate: [MsalGuard]
  },
  {
    path:'crear-faena',
    component: CrearFaenaComponent,
    canActivate: [MsalGuard]
  }
  
  
  
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      initialNavigation: 'enabledNonBlocking'
    })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }