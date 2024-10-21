// src/app/business/agregar-trabajador/agregar-trabajador.component.ts
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-agregar-trabajador',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './agregar-trabajador.component.html',
  styleUrls: ['./agregar-trabajador.component.css'] // Asegúrate de tener este archivo o eliminar esta línea si no lo necesitas
})
export  default class AgregarTrabajadorComponent {
  trabajador = {
    nombre: '',
    apellido: '',
    rut: '',
    edad: null,
    direccion: '',
    fechaContratacion: '',
    telefono: '',
    email: '',
    cargo: ''
  };

  cargos = ['Operario', 'Supervisor', 'Gerente', 'Administrativo'];

  agregarTrabajador() {
    // Lógica para guardar el trabajador
    console.log('Trabajador agregado:', this.trabajador);
    // Aquí puedes agregar la lógica para enviar los datos a tu backend o almacenarlos
  }
}