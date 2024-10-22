import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Importa FormsModule
import { Router } from '@angular/router';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [CommonModule, FormsModule], // Asegúrate de incluir FormsModule aquí
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export default class RegistroComponent {
  trabajador = {
    nombre: 'Juan',
  apellido: 'Pérez',
  rut: '12.345.678-9',
  edad: 30,
  direccion: '123 Calle Falsa',
  fechaContratacion: new Date(),
  telefono: '123456789',
  email: 'juan.perez@example.com',
  hospedaje: '',
  cargo: '',
  faena: '',
    fotoUrl: 'img/istockphoto-1386479313-612x612.jpg' // Reemplaza esto con la ruta a la foto del trabajador
  };
  isModalOpen = false;
  nombre: string = '';
  apellido: string = '';
  rut: string = '';
  edad: string = '';
  direccion: string = '';
  fechaContratacion: string = '' ;
  telefono: string = '';
  email: string = '';
  cargo: string = '';

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
    this.clearForm(); // Limpiar el formulario al cerrar el modal
  }

  submitForm() {
    Swal.fire('Datos guardados exitosamente'); // Muestra la alerta
  this.closeModal();

    // Aquí puedes agregar la lógica para guardar los datos en algún servicio o base de datos
    this.closeModal();
  }

  clearForm() {
    this.nombre = '';
    this.apellido = '';
    this.rut = '';
    this.edad = '';
    this.direccion = '';
    this.fechaContratacion = '';
    this.telefono = '';
    this.email = '';
    this.cargo = '';
  }

  faenas = [
    { nombre: 'Faena 1' },
    { nombre: 'Faena 2' },
    { nombre: 'Faena 3' }
  ]; // Aquí define las faenas disponibles
  cargos = ['Operario', 'Supervisor', 'Gerente', 'Administrativo'];
  hospedajes = ['Hospedaje 1', 'Hospedaje 2'];
  

  
}
