import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { BeneficiariesPageComponent } from './beneficiaries-page/beneficiaries-page.component';
import { ClientPageComponent } from './client-page/client-page.component';
import { ClientSettingsComponent } from './client-settings/client-settings.component';
import { HomeComponent } from './home/home.component';
import { IndividualStatementComponent } from './individual-statement/individual-statement.component';
import { LoginComponent } from './login/login.component';
import { SecondheaderComponent } from './secondheader/secondheader.component';
import { StatementsComponent } from './statements/statements.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'clientPage',
    component: ClientPageComponent
  },
  {
    path: 'clientSettings',
    component: ClientSettingsComponent
  },
  {
    path: 'adminPage',
    component: AdminPageComponent
  },
  {
    path: 'secondheader',
    component: SecondheaderComponent
  },
  {
    path: 'beneficiariesPage',
    component: BeneficiariesPageComponent
  },
  {
    path: 'statements',
    component: StatementsComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'individualStatement',
    component: IndividualStatementComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
