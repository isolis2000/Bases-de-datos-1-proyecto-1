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

  public getData(){
      return this.http.post<JSON>("http://localhost:8080/api/", {"Id":2})
  }
}
