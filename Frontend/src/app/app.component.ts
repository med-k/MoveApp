import { KeycloakService } from 'keycloak-angular';
import { Component } from '@angular/core';
import * as $ from 'jquery';
declare interface RouteInfo {
  path: string;
  title: string;
}
export const routesAdmin: RouteInfo[] = [
  {
    path: '/dashboard',
    title: 'Dashboard',
  },
  {
    path: '/collaborateur-list',
    title: 'Collaborateur',
  },
  {
    path: '/deplacement-list',
    title: 'Deplacements',
  },
  {
    path: '/role',
    title: 'Role',
  },
];
export const routesEmployee: RouteInfo[] = [
  {
    path: '/deplacement-encours',
    title: 'Encours',
  },
  {
    path: '/deplacement-list',
    title: 'Historique',
  },
  {
    path: '/deplacement-list',
    title: 'A Venir',
  },
];
export const routesManager: RouteInfo[] = [
  {
    path: '/deplacement-new',
    title: 'Cree-Deplacement',
  },
  {
    path: '/deplacement-list',
    title: 'Deplacements',
  },
];

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  menuItems: RouteInfo[] = [];
  userRole = [''];
  user = '';
  constructor(private keycloakService: KeycloakService) {}
  ngOnInit() {
    this.GetRole();
    //get username from keycloak
    this.user = this.keycloakService.getUsername();

    //sidebar hide function
    $('#menu-toggle').click(function (e) {
      e.preventDefault();
      $('#wrapper').toggleClass('toggled');
    });
  }
  //logout function
  logout(): void {
    this.keycloakService.logout();
  }
  //sidebar items function
  GetRole() {
    this.userRole = this.keycloakService.getUserRoles();
    for (let role of this.userRole) {
      switch (role) {
        case 'admin':
          this.menuItems = routesAdmin.filter((menuItem) => menuItem);
          break;
        case 'collaborater':
          this.menuItems = routesEmployee.filter((menuItem) => menuItem);
          break;
        case 'manager':
          this.menuItems = routesManager.filter((menuItem) => menuItem);
          break;
      }
    }
  }
}
