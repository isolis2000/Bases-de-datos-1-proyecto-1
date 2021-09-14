import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl:'./login.component.html' ,
  styleUrls: ['./login.component.css']
})



export class LoginComponent implements OnInit {
  user: string ='';
  password!: string;

  constructor() { }

  ngOnInit(): void {
  }

  submitForm() {
    //grab values
    const mesagge = 'my name is ' + this.user;
    alert(mesagge)
  }

}
