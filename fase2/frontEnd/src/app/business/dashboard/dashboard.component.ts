// src/app/business/dashboard/dashboard.component.ts
import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
// import CrearFaenaComponent from '../../shared/components/crear-faena/crear-faena.component';
import { MatPaginator } from '@angular/material/paginator'; // Importa MatPaginator
import { HttpClientModule } from '@angular/common/http'; // Importa HttpClientModule

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
  imports: [MatPaginator, CommonModule],
// Asegúrate de importar MatPaginator
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export  class DashboardComponent {
  @ViewChild(MatPaginator) paginator: MatPaginator | null = null; // Obtén el paginador

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
    this.router.navigate(['/app/crear-faena']);
  }

  agregarFaena(nuevaFaena: Faena) {
    this.faenas.push(nuevaFaena);
    if (this.paginator) {
      this.paginator.length = this.faenas.length; // Verifica si el paginador está inicializado
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
}
