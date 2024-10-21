import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DatosUsuarioComponent } from '../../shared/components/datos-usuario/datos-usuario.component';

@Component({
  selector: 'app-usuario',
  standalone: true, 
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class UsuarioComponent {
  constructor(public dialog: MatDialog) {}

  openDialog(): void {
    const dialogRef = this.dialog.open(DatosUsuarioComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log('Datos ingresados:', result);
        // Aquí puedes manejar los datos recibidos (nombre, apellido, correo)
      } else {
        console.log('Diálogo cerrado sin guardar');
      }
    });
  }

}
