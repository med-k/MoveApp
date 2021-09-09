import { RoleComponent } from './components/role/role/role.component';
import { CollaborateurUpdateComponent } from './components/collaborateur/collaborateur-update/collaborateur-update.component';
import { AuthGuard } from './utility/app.guard';
import { DeplacementListComponent } from './components/deplacement/deplacement-list/deplacement-list.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CollaborateurListComponent } from './components/collaborateur/collaborateur-list/collaborateur-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeplacementNewComponent } from './components/deplacement/deplacement-new/deplacement-new.component';
import { DeplacementEncoursComponent } from './components/deplacement/deplacement-encours/deplacement-encours.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent,
        canActivate: [AuthGuard],
        //data: { roles: ['admin'] },
      },
      {
        path: 'collaborateur-list',
        component: CollaborateurListComponent,
        canActivate: [AuthGuard],
        //data: { roles: ['admin', 'manager'] },
      },
      {
        path: 'deplacement-list',
        component: DeplacementListComponent,
        canActivate: [AuthGuard],
        //data: { roles: ['admin', 'collaborater', 'manager'] },
      },
      {
        path: 'collaborateur-list/collaborateur-update/:id',
        component: CollaborateurUpdateComponent,
        canActivate: [AuthGuard],
        //data: { roles: ['admin'] },
      },
      {
        path: 'deplacement-new',
        component: DeplacementNewComponent,
        canActivate: [AuthGuard],
        //data: { roles: ['admin','manager'] },
      },
      {
        path: 'deplacement-encours',
        component: DeplacementEncoursComponent,
        canActivate: [AuthGuard],
        //data: { roles: ['admin','manager',collaborater] },
      },
      {
        path: 'role',
        component: RoleComponent,
        canActivate: [AuthGuard],
        //data: { roles: ['admin'] },
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
