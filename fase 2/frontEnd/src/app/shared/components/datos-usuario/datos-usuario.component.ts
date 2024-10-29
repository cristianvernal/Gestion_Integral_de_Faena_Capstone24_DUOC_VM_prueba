import { Component } from '@angular/core';
import Swal from 'sweetalert2'



@Component({
  selector: 'app-datos-usuario',
  templateUrl: './datos-usuario.component.html',
  styleUrl: './datos-usuario.component.css'
})
export class DatosUsuarioComponent {
  selectedImage: string | ArrayBuffer | null = null;
  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      const file = input.files[0];
      const reader = new FileReader();

      reader.onload = (e) => {
        this.selectedImage = reader.result; 
      };

      reader.readAsDataURL(file); 
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
