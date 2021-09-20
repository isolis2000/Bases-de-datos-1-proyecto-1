import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class CommunicationService {
  constructor(private http: HttpClient) {}

  public postData(){
      return this.http.post<JSON>("http://localhost:8080/api/", {"Id":2})
  }

  public verifyLoginClient(usuario:string, pass:string, esAdministrador : number){
    return this.http.post<JSON>("http://localhost:8080/api/login", ({"usuario": usuario, "pass": pass, "esAdministrador": esAdministrador}))
  }

  public loadAccountsTable(usuario:any){
    return this.http.post<JSON>("http://localhost:8080/api/accountsTable", ({"usuario": usuario}))
  }

  public loadAdminTable(){
    return this.http.get<JSON>("http://localhost:8080/api/adminAccountsTable")
  }

  public loadBeneficiariesTable(usuario:any){
    return this.http.post<JSON>("http://localhost:8080/api/beneficiaries", ({"usuario": usuario}))
  }

  public loadBeneficiariesTableApart(numCuenta:any){
    return this.http.post<JSON>("http://localhost:8080/api/beneficiariesForAccount", ({"numeroCuenta": numCuenta}))
  }

  public deleteBen(numCuenta:number, valorDocIdentidad:number, porcentaje:number, parentezcoId: number){
    return this.http.post<JSON>("http://localhost:8080/api/removeBeneficiary", ({"numeroCuenta": numCuenta, "valorDocumentoIdentidadBeneficiario":valorDocIdentidad, "ParentezcoId":parentezcoId,"porcentaje":porcentaje}))
  }

  public addBen(numCuenta:number, valorDocIdentidad:number, porcentaje:number, parentezcoId: number){
    return this.http.post<JSON>("http://localhost:8080/api/addBeneficiary", ({"numeroCuenta": numCuenta, "valorDocumentoIdentidadBeneficiario":valorDocIdentidad, "ParentezcoId":parentezcoId,"porcentaje":porcentaje}))
  }

  public editBen(numCuenta:number, valorDocIdentidad:number, porcentaje:number, parentezcoId: number){
    return this.http.post<JSON>("http://localhost:8080/api/modifyBeneficiary", ({"numeroCuenta": numCuenta, "valorDocumentoIdentidadBeneficiario":valorDocIdentidad, "ParentezcoId":parentezcoId,"porcentaje":porcentaje}))
  }
}

