import { Component, OnInit } from '@angular/core';
import { tableColumn, UiTableComponent } from "../../components/ui-table/ui-table.component";
import { timer } from 'rxjs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FooterComponent } from "../../components/footer/footer.component";

interface Customer {
  nombre: string;
  apellido: string;
  rut: string;
  edad: string;
  cargo: string;
  disponibilidad: string
}

interface Food {
  value: string;
  viewValue: string;
}

interface Estado {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-verificacion',
  standalone: true,
  imports: [UiTableComponent, MatFormFieldModule, MatSelectModule, MatInputModule, FormsModule, MatButtonModule, FooterComponent],
  templateUrl: './verificacion.component.html',
  styleUrl: './verificacion.component.css'
})
export class VerificacionComponent implements OnInit{

  foods: Food[] = [
    {value: 'steak-0', viewValue: 'Faena 1'},
    {value: 'pizza-1', viewValue: 'Faena 2'},
    {value: 'tacos-2', viewValue: 'Faena 3'},
  ];

  estados: Estado[] = [
    {value: 'disponible-0,', viewValue: 'Disponible'},
    {value: 'no disponible-1,', viewValue: 'No Disponible'},
  ]

  verificacion: Customer[] = []
  tableColumns: tableColumn<Customer>[] = []

  ngOnInit(): void {
      this.getCustomers()
      this.setTableColumns()
  }

  setTableColumns() {
    this.tableColumns = [
      {
        label: 'Nombre',
        def: 'Nombre',
        content: (row) => row.nombre
      },
      {
        label: 'Apellido',
        def: 'Apellido',
        content: (row) => row.apellido
      },
      {
        label: 'Rut',
        def: 'Rut',
        content: (row) => row.rut,
      },
      {
        label: 'Edad',
        def: 'Edad',
        content: (row) => row.edad
      },
      {
        label: 'Cargo',
        def: 'Cargo',
        content: (row) => row.cargo
      },
      {
        label: 'Disponibilidad',
        def: 'Disponibilidad',
        content: (row) => row.disponibilidad
      },
      
    ]
  }

  getCustomers() {
    timer(100).subscribe(() => {
      this.verificacion = [
        {
          nombre: 'Cristian',
          apellido: 'Vernal',
          rut: '15979732-5',
          edad: '38',
          cargo: 'Ingeniero',
          disponibilidad: 'disponible'
        },
        {
          nombre: 'Leonel',
          apellido: 'Aranda',
          rut: '18782428-4',
          edad: '34',
          cargo: 'Soldador',
          disponibilidad: 'No disponible'
        },
      ]
    })
  }
}
