import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatTooltipModule } from '@angular/material/tooltip';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'
import { SidenavComponent } from "../../components/sidenav/sidenav.component";
import { tableColumn, UiTableComponent } from "../../components/ui-table/ui-table.component";
import { timer } from 'rxjs';
import { FooterComponent } from "../../components/footer/footer.component";

interface Faena {
  nombre: string;
  fechaInicio: string;
  fechaTermino: string;
  encargado: string;

}

@Component({
  selector: 'app-gestion',
  standalone: true,
  imports: [MatPaginator, FormsModule, CommonModule,
    MatTableModule,
    MatPaginatorModule,
    MatButtonModule,
    MatTooltipModule, MatIconModule, SidenavComponent, UiTableComponent, FooterComponent],
  templateUrl: './gestion.component.html',
  styleUrl: './gestion.component.css',
})
export class GestionComponent implements OnInit{
  faenas: Faena[] = [];
  tableColumns: tableColumn<Faena>[] = [];


  constructor( private router: Router) {}
  ngOnInit(): void {
    this.setTableColumns();
    this.getFaenas()
  }

  setTableColumns() {
    this.tableColumns = [
      {
        label: 'Nombre',
        def: 'nombre',
        content: (row) => row.nombre
      },
      {
        label: 'Fecha de inicio',
        def: 'Fecha de Inicio',
        content: (row) => row.fechaInicio
      },
      {
        label: 'Fecha de Termino',
        def: 'Fecha de termino',
        content: (row) => row.fechaTermino
      },
      {
        label: 'Encargado',
        def: 'Encargado',
        content: (row) => row.encargado
      },
    ]
  }
  
  getFaenas() {
    timer(100).subscribe(() => {
      this.faenas = [
        {
          nombre: 'faena 1',
          fechaInicio: '12/08/2024',
          fechaTermino: '12/09/2024',
          encargado: 'Leonel Aranda',
          
        }
      ]
    })

    }
    
    
  }
  
