// src/app/business/dashboard/dashboard.component.ts
import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
// import CrearFaenaComponent from '../../shared/components/crear-faena/crear-faena.component';
import { MatPaginator } from '@angular/material/paginator'; // Importa MatPaginator
import { HttpClientModule } from '@angular/common/http'; // Importa HttpClientModule
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2'
import { LayoutComponent } from "../../shared/components/layout/layout.component";
import { SidebarComponent } from '../../shared/components/sidebar/sidebar.component';

import { HeaderComponent } from '../../shared/components/header/header.component';



// Definición de la interfaz Faena
interface Faena {
  nombre: string;
  fechaInicio: string;
  fechaTermino: string;
  encargado: string;
}

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [MatPaginator, CommonModule, FormsModule, LayoutComponent, LayoutComponent, SidebarComponent, HeaderComponent],
// Asegúrate de importar MatPaginator
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export  class DashboardComponent {
  @ViewChild(MatPaginator) paginator: MatPaginator | null = null; // Obtén el paginador
  isModalOpen = false;
  nombre: string = '';
  fechaInicio: string = '';
  fechaTermino: string = '';
  encargado: string = '';

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
    this.clearForm(); // Limpiar el formulario al cerrar el modal
  }

  submitForm() {
    console.log('Nombre:', this.nombre);
    console.log('Apellido:', this.fechaInicio);
    console.log('Correo:', this.fechaTermino);
    console.log('Correo:', this.encargado);
    Swal.fire('Faena guardada exitosamente'); // Muestra la alerta
  this.closeModal();

    // Aquí puedes agregar la lógica para guardar los datos en algún servicio o base de datos
    this.closeModal();
  }

  faenas: Faena[] = [
    { nombre: 'Faena 1', fechaInicio: '01/01/2024', fechaTermino: '01/02/2024', encargado: 'Juan Pérez' },
    { nombre: 'Faena 2', fechaInicio: '01/03/2024', fechaTermino: '01/04/2024', encargado: 'Ana Gómez' },
    // Agrega más faenas según sea necesario
  ];

  // Variables para la paginación
  pageSize = 5; // Número de faenas por página
  currentPage = 0; // Página actual (comienza en 0)

  constructor(private router: Router) {}

  irACrearFaena() {
    this.router.navigate(['crear-faena']);
  }

  agregarFaena(nuevaFaena: Faena) {
    this.faenas.push(nuevaFaena);
    if (this.paginator) {
      this.paginator.length = this.faenas.length; 
    }
  }
  // Método para obtener las faenas de la página actual
  get paginatedFaenas(): Faena[] {
    const startIndex = this.currentPage * this.pageSize;
    return this.faenas.slice(startIndex, startIndex + this.pageSize);
  }

  onPageChange(event: any) {
    this.currentPage = event.pageIndex; // Actualiza la página actual
    this.pageSize = event.pageSize; // Actualiza el tamaño de página
  }
  clearForm() {
    this.nombre = '';
    this.fechaInicio = '';
    this.fechaTermino = '';
    this.encargado = '';
  }
}
