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
  numeroAdmin: number | undefined;

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

  esAdministrador(validacion:number){
    this.numeroAdmin = validacion;
  }

  validateForm(username: string, password: string){
    var esAdministrador = this.numeroAdmin;
    localStorage.setItem('current_username', username);
    localStorage.setItem('current_password', password);
    if(esAdministrador == 0){
      this.CS.verifyLoginClient(username,password, esAdministrador).subscribe(res  => {
        const result: Result = JSON.parse(JSON.stringify(res))
        if(esAdministrador == 0 && username!='' && password != '' ){
          localStorage.setItem("Name", result.usuario );
          localStorage.setItem("Password", result.pass );
          localStorage.setItem("Admin", result.esAdministrador.toString() );
          this.CS.loadAccountsTable(localStorage.getItem("Name")).subscribe(res => {
            localStorage.setItem("tableData", JSON.stringify(res))
            window.location.reload();
      
          })
          this.CS.loadBeneficiariesTable(localStorage.getItem("Name")).subscribe(res =>{
            localStorage.setItem("beneficiariesData", JSON.stringify(res))
            window.location.reload();
          })
          if(result.usuario == null){
            this.removeAll()
            alert("Usuario o contraseña incorrectos")
            
          }else{
            this.router.navigate(['/clientPage'])
            
          }
          
        }
        else{
          this.removeAll()
          alert("Por favor llenar ambos datos")
        }
        }, error => {
          alert("no existe")
        });
      }
      if (esAdministrador == 1) {
        
        this.CS.verifyLoginClient(username,password, esAdministrador).subscribe(res  => {
          const result: Result = JSON.parse(JSON.stringify(res))
          alert(JSON.stringify(res))
          if(esAdministrador == 1 && username!='' && password != '' ){
            localStorage.setItem("Name", result.usuario );
            this.CS.loadAdminTable().subscribe(res => {
              
              localStorage.setItem("tableData", JSON.stringify(res))
              window.location.reload();
        
            })
            if(result.usuario == null){
              this.removeAll()
              alert("Usuario o contraseña incorrectos")
              
            }else{
              this.router.navigate(['/adminPage'])
              
            }
            
          }
          else{
            this.removeAll()
            alert("Por favor llenar ambos datos")
          }
          }, error => {
            alert("no existe")
          });

      }
    }

  

}
