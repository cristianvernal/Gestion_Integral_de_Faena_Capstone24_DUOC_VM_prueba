import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

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
  imports: [CommonModule, FormsModule],
  templateUrl: './verificacion.component.html',
  styleUrls: ['./verificacion.component.css']
})
export default class ProfileComponent {
  faenas = [
    { nombre: 'Faena 1' },
    { nombre: 'Faena 2' },
    { nombre: 'Faena 3' }
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
