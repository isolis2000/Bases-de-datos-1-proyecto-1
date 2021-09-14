import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientPageComponent } from './client-page/client-page.component';
import { ClientSettingsComponent } from './client-settings/client-settings.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
