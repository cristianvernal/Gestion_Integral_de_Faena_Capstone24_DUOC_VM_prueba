import { Component } from '@angular/core';
import { SidebarComponent } from '../../shared/components/sidebar/sidebar.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrl: './reportes.component.css',
  standalone: true,
  imports: [SidebarComponent, CommonModule, FormsModule]
})
export class ReportesComponent {
  workerName: string = '';
  searched: boolean = false;

  // Ejemplo de datos estáticos
  allFanas = [
    { id: 1, nombre: 'Faena 1', fechaInicio: '2024-01-01', fechaFin: '2024-01-10', estado: 'Completado', trabajador: 'Juan Pérez' },
    { id: 2, nombre: 'Faena 2', fechaInicio: '2024-02-01', fechaFin: '2024-02-10', estado: 'En Proceso', trabajador: 'Juan Pérez' },
    { id: 3, nombre: 'Faena 3', fechaInicio: '2024-03-01', fechaFin: '2024-03-10', estado: 'Pendiente', trabajador: 'Ana López' },
  ];

  workerFanas: any[] = [];

  searchWorker() {
    // Filtrar las faenas según el nombre del trabajador
    this.workerFanas = this.allFanas.filter(faena => faena.trabajador.toLowerCase() === this.workerName.toLowerCase());
    this.searched = true;
  }
}
