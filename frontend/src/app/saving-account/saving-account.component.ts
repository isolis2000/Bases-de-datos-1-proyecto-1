import { Component, OnInit } from '@angular/core';
import { CommunicationService } from '../communication/communication.service';

@Component({
  selector: 'app-saving-account',
  templateUrl: './saving-account.component.html',
  styleUrls: ['./saving-account.component.css']
})
export class SavingAccountComponent implements OnInit {

  constructor(private CS:CommunicationService) { }
  headers:any = ["Numero Cuenta de ahorro", "Descripción ", "Activado", "Fecha Inicio", "Fecha Fin"]
  Rows = JSON.parse(localStorage.getItem("savingsTable")?.toString() || '{}')
  cuentaActual = (Number(localStorage.getItem("CuentaActual")))

  ngOnInit(): void {
  }

  addAccount(cuenta:any, cuentaAhorro:any, activado:any, descripcion:any, fechaInicio:any, fechaFinal:any){
    this.CS.addSavingsTables(cuenta,cuentaAhorro,activado,descripcion,fechaInicio,fechaFinal).subscribe()
    this.CS.getSavingsTables(cuenta).subscribe(res=>{
      localStorage.setItem("savingsTable",JSON.stringify(res))
      window.location.reload();
    })
    window.location.reload();
  }

  editAccount(cuenta:any, cuentaAhorro:any, activado:any, descripcion:any, fechaInicio:any, fechaFinal:any){
    this.CS.editSavingsTables(cuenta,cuentaAhorro,activado,descripcion,fechaInicio,fechaFinal).subscribe()
    this.CS.getSavingsTables(cuenta).subscribe(res=>{
      localStorage.setItem("savingsTable",JSON.stringify(res))
      window.location.reload();
    })
  }

  deleteAccount(cuenta:any, cuentaAhorro:any, activado:any, descripcion:any, fechaInicio:any, fechaFinal:any){
    this.CS.deleteSavingsTables(cuenta,cuentaAhorro,activado,descripcion,fechaInicio,fechaFinal).subscribe()
    this.CS.getSavingsTables(cuenta).subscribe(res=>{
      localStorage.setItem("savingsTable",JSON.stringify(res))
      window.location.reload();
    })
  }

}
