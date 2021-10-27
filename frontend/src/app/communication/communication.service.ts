import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { NumericLiteral } from 'typescript';

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
    return this.http.post<JSON>("http://localhost:8080/api/removeBeneficiary", ({"numeroCuenta": numCuenta, "valorDocumentoIdentidadBeneficiario":valorDocIdentidad, "parentezcoId":parentezcoId,"porcentaje":porcentaje}))
  }

  public addBen(numCuenta:number, valorDocIdentidad:number, porcentaje:number, parentezcoId: number){
    return this.http.post<JSON>("http://localhost:8080/api/addBeneficiary", ({"numeroCuenta": numCuenta, "valorDocumentoIdentidadBeneficiario":valorDocIdentidad, "parentezcoId":parentezcoId,"porcentaje":porcentaje}))
  }

  public editBen(numCuenta:number, valorDocIdentidad:number, porcentaje:number, parentezcoId: number){
    return this.http.post<JSON>("http://localhost:8080/api/modifyBeneficiary", ({"numeroCuenta": numCuenta, "valorDocumentoIdentidadBeneficiario":valorDocIdentidad, "parentezcoId":parentezcoId,"porcentaje":porcentaje}))
  }

  public totalPercentage(numCuenta:number){
    return this.http.post<JSON>("http://localhost:8080/api/totalPercentage", ({"numeroCuenta": numCuenta}))
  }

  public numberOfBeneficiaries(numCuenta:number){
    return this.http.post<JSON>("http://localhost:8080/api/numberOfBeneficiaries", ({"numeroCuenta": numCuenta}))
  }

  public getStatements(numCuenta:number){
    return this.http.post<JSON>("http://localhost:8080/api/accountStatements", ({"cuenta": numCuenta}))
  }

  public getStatementsDetails(estadoId:number){
    return this.http.post<JSON>("http://localhost:8080/api/individualStatements", ({"id": estadoId}))
  }

  public getSavingsTables(numCuenta:number){
    return this.http.post<JSON>("http://localhost:8080/api/savingsTable", ({"numeroCuenta": numCuenta}))
  }

  public addSavingsTables(numCuenta:number, numCuentaAhorro:number, activado:number, descripcion:string, fechaInicio:string, fechaFinal:string){
    return this.http.post<JSON>("http://localhost:8080/api/addSavingsTable", ({"numeroCuenta":numCuenta,"numeroCuentaAhorro":numCuentaAhorro,"activado":activado,"descripcion":descripcion,"fechaInicio":fechaInicio,"fechaFinal":fechaFinal}))
  }

  public editSavingsTables(numCuenta:number, numCuentaAhorro:number, activado:number, descripcion:string, fechaInicio:string, fechaFinal:string){
    return this.http.post<JSON>("http://localhost:8080/api/editSavingsTable", ({"numeroCuenta":numCuenta,"numeroCuentaAhorro":numCuentaAhorro,"activado":activado,"descripcion":descripcion,"fechaInicio":fechaInicio,"fechaFinal":fechaFinal}))
  }

  public deleteSavingsTables(numCuenta:number, numCuentaAhorro:number, activado:number, descripcion:string, fechaInicio:string, fechaFinal:string){
    return this.http.post<JSON>("http://localhost:8080/api/deleteSavingsTable", ({"numeroCuenta":numCuenta,"numeroCuentaAhorro":numCuentaAhorro,"activado":activado,"descripcion":descripcion,"fechaInicio":fechaInicio,"fechaFinal":fechaFinal}))
  }



}

