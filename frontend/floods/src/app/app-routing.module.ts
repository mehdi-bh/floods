import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { NewAccountComponent } from './pages/new-account/new-account.component';
import { OffersComponent } from './pages/offers/offers.component';
import { RequestsComponent } from './pages/requests/requests.component';

const routes: Routes = [
  { path : '', component: HomeComponent },
  { path : 'connexion', component: LoginComponent },
  { path : 'nouveauCompte', component: NewAccountComponent },
  { path : 'offres', component: OffersComponent },
  { path : 'demandes', component: RequestsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
