import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CommunicationService } from '../communication/communication.service';
import { FormGroup, FormControl } from "@angular/forms";

interface Result {
  usuario: string,
  pass: string,
  esAdministrador: number
  //NumeroCuenta: string,
  //TipoDocuIdentidad: string,
  //IdTipoMoneda: string,
  //Saldo: string

}

@Component({
  selector: 'app-login',
  templateUrl:'./login.component.html' ,
  styleUrls: ['./login.component.css']
})



export class LoginComponent implements OnInit {
  myForm!: any;

  constructor(private CS:CommunicationService, private router: Router) { }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')

    });
  }

  submitForm() {
    //grab values
    const mesagge = 'my name is ';
    alert(mesagge)
  }

  sendDataWithThis(){
    this.CS.postData().subscribe(res => {
      alert(res.stringify)
    })
  }

  onSubmit(){
    localStorage.setItem("formdata", JSON.stringify(this.myForm.value));
  }

  removeAll(){
    localStorage.clear();
  }

  validateForm(username: string, password: string, esAdministrador: number){
    localStorage.setItem('current_username', username);
    localStorage.setItem('current_password', password);
    if(esAdministrador == 0){
      this.CS.verifyLoginClient(username,password, esAdministrador).subscribe(res  => {
        const result: Result = JSON.parse(JSON.stringify(res))
        if(esAdministrador == 0 && username!='' && password != '' ){
          localStorage.setItem("Name", result.usuario );
          localStorage.setItem("Password", result.pass );
          localStorage.setItem("Admin", result.esAdministrador.toString() );

          //localStorage.setItem("AccountNumber", JSON.parse(result.NumeroCuenta) );
          //localStorage.setItem("IdDoc", JSON.parse(result.TipoDocuIdentidad) );
          //localStorage.setItem("Currency", JSON.parse(result.IdTipoMoneda) );
          //localStorage.setItem("IdDoc", JSON.parse(result.TipoDocuIdentidad) );
          if(result.usuario == null){
            alert("Usuario no existe")
            
          }else{
            this.router.navigate(['/clientPage'])
          }
          
        }
        else{
          alert("Por favor llenar ambos datos")
        }
        }, error => {
          alert("no existe")
        });
      }
    }

  

}
