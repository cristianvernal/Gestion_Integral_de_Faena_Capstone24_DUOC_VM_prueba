import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { LayoutComponent } from '../../shared/components/layout/layout.component';
import { SidebarComponent } from '../../shared/components/sidebar/sidebar.component';
import { FooterComponent } from '../../shared/components/footer/footer.component';

interface Trabajador {
  nombre: string;
  apellido: string;
  rut: string;
  edad: number;
  cargo: string;
  disponibilidad: string;
}

@Component({
  selector: 'app-verificacion',
  standalone: true,
  imports: [CommonModule, FormsModule, LayoutComponent, SidebarComponent, FooterComponent],
  templateUrl: './verificacion.component.html',
  styleUrls: ['./verificacion.component.css']
})
export default class ProfileComponent {
  faenas = [
    { nombre: 'Mensaje masivo 1' },
    { nombre: 'Mensaje masivo 2' },
    { nombre: 'Mensaje masivo 3' }
  ];

  trabajadores: Trabajador[] = [
    {
      nombre: 'Juan',
      apellido: 'Perez',
      rut: '12345678-9',
      edad: 30,
      cargo: 'Ingeniero',
      disponibilidad: 'Disponible'
    },
    {
      nombre: 'Maria',
      apellido: 'Gonzalez',
      rut: '98765432-1',
      edad: 25,
      cargo: 'Técnico',
      disponibilidad: 'No Disponible'
    }
    // Puedes agregar más trabajadores aquí
  ];

  buscarTrabajadores() {
    // Lógica de filtrado para trabajadores por faena y disponibilidad, si es necesario
  }
}
