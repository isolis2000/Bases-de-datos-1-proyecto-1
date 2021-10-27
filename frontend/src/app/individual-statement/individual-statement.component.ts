import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommunicationService } from '../communication/communication.service';

@Component({
  selector: 'app-individual-statement',
  templateUrl: './individual-statement.component.html',
  styleUrls: ['./individual-statement.component.css']
})
export class IndividualStatementComponent implements OnInit {

  constructor(private CS:CommunicationService, private router: Router) { }
  headers:any = ["IdEstadoCuenta","Fecha Inicio", "Fecha Final", "Saldo mínimo", "Saldo Inicio", "Saldo Final", "Operaciones en ATM", "Operacion en cajero Humano"]
  Rows = JSON.parse(localStorage.getItem("AccountXStatements")?.toString() || '{}')
  cuentaActual = (Number(localStorage.getItem("CuentaActual")))

  ngOnInit(): void {
  }

  refresh(): void {
    window.location.reload();
  }

  goToDetails(cuentaId:any){
    this.CS.getStatementsDetails(Number(cuentaId)).subscribe(res=>{
      if(cuentaId != ''){
        localStorage.setItem("statementXDetail", JSON.stringify(res))
        if(localStorage.getItem("statementXDetail") != '[]'){
          this.router.navigate(['/statementDetail'])
        }
        if(localStorage.getItem("statementXDetail") == '[]'){
          alert("La Cuenta no existe")
          this.refresh()
        }
      }
      else{
        alert("Por favor ingrese el numero de una cuenta")
      } 
      
    })
  }

}
