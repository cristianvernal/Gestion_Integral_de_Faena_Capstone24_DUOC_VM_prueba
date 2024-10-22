import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DatosUsuarioComponent } from '../../shared/components/datos-usuario/datos-usuario.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css'], // Corrige `styleUrl` a `styleUrls`
})
export class UsuarioComponent {
  selectedImage: string | ArrayBuffer | null = null;
  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      const file = input.files[0];
      const reader = new FileReader();

      reader.onload = (e) => {
        this.selectedImage = reader.result; // Almacena la imagen seleccionada
      };

      reader.readAsDataURL(file); // Lee la imagen como una URL de datos
    }
  }

  isModalOpen = false;
  nombre: string = '';
  apellido: string = '';
  correo: string = '';

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
    this.clearForm(); // Limpiar el formulario al cerrar el modal
  }

  submitForm() {
    console.log('Nombre:', this.nombre);
    console.log('Apellido:', this.apellido);
    console.log('Correo:', this.correo);
    Swal.fire('Datos guardados exitosamente'); // Muestra la alerta
  this.closeModal();

    // Aquí puedes agregar la lógica para guardar los datos en algún servicio o base de datos
    this.closeModal();
  }

  clearForm() {
    this.nombre = '';
    this.apellido = '';
    this.correo = '';
  }
}