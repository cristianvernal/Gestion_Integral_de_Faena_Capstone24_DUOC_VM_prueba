import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  sidebarVisible: boolean = false; // Variable para controlar la visibilidad del sidebar

  toggleSidebar() {
    this.sidebarVisible = !this.sidebarVisible; // Alternar visibilidad
  }
}
