import { RouterModule } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CollaborateurListComponent } from './components/collaborateur/collaborateur-list/collaborateur-list.component';
import { CollaborateurUpdateComponent } from './components/collaborateur/collaborateur-update/collaborateur-update.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DeplacementListComponent } from './components/deplacement/deplacement-list/deplacement-list.component';
import { DeplacementUpdateComponent } from './components/deplacement/deplacement-update/deplacement-update.component';
import { HttpClientModule } from '@angular/common/http';
import { KeycloakAngularModule } from 'keycloak-angular';
import { initializeKeycloak } from './utility/app.init';
import { FormsModule } from '@angular/forms';
import { DeplacementNewComponent } from './components/deplacement/deplacement-new/deplacement-new.component';
import { DeplacementEncoursComponent } from './components/deplacement/deplacement-encours/deplacement-encours.component';
import { AgmCoreModule } from '@agm/core';
import { ItineraireListComponent } from './components/itineraire/itineraire-list/itineraire-list.component';
import { ItineraireNewComponent } from './components/itineraire/itineraire-new/itineraire-new.component';
import { RoleComponent } from './components/role/role/role.component';

@NgModule({
  declarations: [
    AppComponent,
    CollaborateurListComponent,
    CollaborateurUpdateComponent,
    DashboardComponent,
    DeplacementListComponent,
    DeplacementUpdateComponent,
    DeplacementNewComponent,
    DeplacementEncoursComponent,
    ItineraireListComponent,
    ItineraireNewComponent,
    RoleComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,
    RouterModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAW1j9LFpVDsdl_BACbYe62aDH93RI6Lhw',
    }),
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
