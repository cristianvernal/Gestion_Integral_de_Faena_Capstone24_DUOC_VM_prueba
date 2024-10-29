import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MsalService } from '@azure/msal-angular';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [
    RouterModule,
    CommonModule,
    MatButtonModule,
    MatToolbarModule,
    MatListModule,
    MatIconModule,
    MatSidenavModule,
  ],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css',
})
export class SidebarComponent {
  constructor(private authService: MsalService) {}

  logout() {
    this.authService.logoutPopup({
      mainWindowRedirectUri: 'http://localhost:4200',
    });
  }
}
