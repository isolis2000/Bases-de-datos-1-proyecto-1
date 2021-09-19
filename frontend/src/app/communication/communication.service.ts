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
}

