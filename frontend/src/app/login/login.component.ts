import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CommunicationService } from '../communication/communication.service';

@Component({
  selector: 'app-login',
  templateUrl:'./login.component.html' ,
  styleUrls: ['./login.component.css']
})



export class LoginComponent implements OnInit {
  user: string ='';
  password!: string;

  constructor(private CS:CommunicationService) { }

  ngOnInit(): void {
  }

  submitForm() {
    //grab values
    const mesagge = 'my name is ' + this.user;
    alert(mesagge)
  }

  sendDataWithThis(){
    this.CS.getData().subscribe(res => {
      alert(res.stringify)
    })
  }

}
