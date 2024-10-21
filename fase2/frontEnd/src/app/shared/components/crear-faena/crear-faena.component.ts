import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; // Import CommonModule

// Definición de la interfaz Faena
interface Faena {
  nombre: string;
  fechaInicio: string;
  fechaTermino: string;
  encargado: string;
}

@Component({
  selector: 'app-crear-faena',
  standalone: true,
  imports: [CommonModule, FormsModule], // Include CommonModule here
  templateUrl: './crear-faena.component.html',
  styleUrls: ['./crear-faena.component.css']
})
export default class CrearFaenaComponent {
  // Propiedades del formulario
  nombre: string = '';
  fechaInicio: string = '';
  fechaTermino: string = '';
  encargado: string = '';
  
  submitted: boolean = false; // Initialize the submitted property

  // EventEmitter para enviar la nueva faena al componente padre
  @Output() faenaCreada = new EventEmitter<Faena>();

  // Método para manejar el envío del formulario
  crearFaena() {
    this.submitted = true; // Set submitted to true when trying to submit

    if (this.isFormValid()) {
      const nuevaFaena: Faena = {
        nombre: this.nombre,
        fechaInicio: this.fechaInicio,
        fechaTermino: this.fechaTermino,
        encargado: this.encargado
      };

      // Emitir el evento hacia el componente padre
      this.faenaCreada.emit(nuevaFaena);
      
      // Limpiar el formulario
      this.resetForm();
    }
  }

  // Método para verificar la validez del formulario
  isFormValid(): boolean {
    return this.nombre !== '' && this.fechaInicio !== '' && this.fechaTermino !== '' && this.encargado !== '';
  }

  // Método para resetear el formulario
  resetForm() {
    this.nombre = '';
    this.fechaInicio = '';
    this.fechaTermino = '';
    this.encargado = '';
    this.submitted = false; // Reset submitted to false
  }
}