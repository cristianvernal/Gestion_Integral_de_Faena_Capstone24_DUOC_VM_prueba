import { CommonModule } from '@angular/common';
import { Component, computed, Input, signal } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list'
import { Router, RouterLink, RouterModule } from '@angular/router';
import { MsalService } from '@azure/msal-angular';

export type menuItem = {

  icon: string;
  label: string;
  route: string;
}

@Component({
  selector: 'app-custom-sidenav',
  standalone: true,
  imports: [CommonModule, MatListModule, MatIconModule, RouterLink, RouterModule, MatButtonModule],
  templateUrl: './custom-sidenav.component.html',
  styleUrl: './custom-sidenav.component.css'
})
export class CustomSidenavComponent {

  constructor(private route: Router, private authService: MsalService){}

  sideNavCollapsed = signal(false)
  @Input() set collapsed(val:boolean) {
    this.sideNavCollapsed.set(val)
  }

  menuItems = signal<menuItem[]>([
    {
      icon: 'home',
      label: 'gestion',
      route: 'gestion',
    },
    {
      icon: 'check',
      label: 'verificacion',
      route: 'verificacion',
    },
    {
      icon: 'person',
      label: 'registro',
      route: 'registro',
    },
    // {
    //   icon: 'analytics',
    //   label: 'reportes',
    //   route: 'reportes',
    // },
  ])

  profilePicSize = computed(() => this.sideNavCollapsed() ? '30' : '100')

  logout() {
    this.authService.logoutPopup({
      mainWindowRedirectUri: 'login',
    });
  }

}
