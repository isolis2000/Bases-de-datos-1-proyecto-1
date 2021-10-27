import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ClientPageComponent } from './client-page/client-page.component';
import { ClientSettingsComponent } from './client-settings/client-settings.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { CommonModule } from "@angular/common";
import { SecondheaderComponent } from './secondheader/secondheader.component';
import { BeneficiariesPageComponent } from './beneficiaries-page/beneficiaries-page.component';
import { StatementsComponent } from './statements/statements.component';
import { IndividualStatementComponent } from './individual-statement/individual-statement.component';
import { StatementDetailComponent } from './statement-detail/statement-detail.component';
import { SavingAccountComponent } from './saving-account/saving-account.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    ClientPageComponent,
    ClientSettingsComponent,
    AdminPageComponent,
    SecondheaderComponent,
    BeneficiariesPageComponent,
    StatementsComponent,
    IndividualStatementComponent,
    StatementDetailComponent,
    SavingAccountComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
