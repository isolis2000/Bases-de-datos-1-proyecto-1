import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from "@angular/forms";

import { CommunicationService } from '../communication/communication.service';


interface Result {
  cantidadDeBeneficiarios:number

}


@Component({
  selector: 'app-client-settings',
  templateUrl: './client-settings.component.html',
  styleUrls: ['./client-settings.component.css']
})
export class ClientSettingsComponent implements OnInit {

  constructor(private CS:CommunicationService) { }
  headers:any = ["Nombre", "Cuenta Asociada", "Parentezco", "Porcentaje"]
   Rows = JSON.parse(localStorage.getItem("beneficiariesData")?.toString() || '{}')
  benValue:number = 0
  msg:string = ''
  cuentaActual:any

  ngOnInit(): void {
  }

  updateBenValue(value:number){
    this.benValue = value;
    if (value == 1) {
      this.msg = 'Padre'
    }
    if (value == 2) {
      this.msg = 'Madre'
    }
    if (value == 3) {
      this.msg = 'Hijo'
    }
    if (value == 4) {
      this.msg = 'Hija'
    }
    if (value == 5) {
      this.msg = 'Hermano'
    }
    if (value == 6) {
      this.msg = 'Hermana'
    }
    if (value == 7) {
      this.msg = 'Amigo'
    }
    if (value == 8) {
      this.msg = 'Amiga'
    }
    
  }

  showData(s1:any,s2:any,s3:any,value:any){
    localStorage.setItem("s1", String(s1))
    localStorage.setItem("s2",String(s2))
    localStorage.setItem("s3",String(s3))
    localStorage.setItem("s4",String(value))


  }
  deleteBen(numCuenta:any, valorDocIdentidad:any, porcentaje:any){
    this.CS.deleteBen(numCuenta,valorDocIdentidad,porcentaje,this.benValue).subscribe()
    this.CS.loadBeneficiariesTable(localStorage.getItem("Name")).subscribe(res =>{
      localStorage.setItem("beneficiariesData", JSON.stringify(res))
      window.location.reload();
    })
  }
  editBen(numCuenta:any, valorDocIdentidad:any, porcentaje:any){
    this.CS.editBen(numCuenta,valorDocIdentidad,porcentaje,this.benValue).subscribe()
    this.CS.loadBeneficiariesTable(localStorage.getItem("Name")).subscribe(res =>{
      localStorage.setItem("beneficiariesData", JSON.stringify(res))
      window.location.reload();
    })
  }
  addBen(numCuenta:any, valorDocIdentidad:any, porcentaje:any){
    this.CS.numberOfBeneficiaries(numCuenta).subscribe(res=>{
      const result: Result = JSON.parse(JSON.stringify(res))
      localStorage.setItem("current_num_ben", String(result.cantidadDeBeneficiarios))
    })
    if(Number(localStorage.getItem("current_num_ben"))<3) {
      this.CS.addBen(Number(numCuenta),Number(valorDocIdentidad),Number(porcentaje),this.benValue).subscribe()
      this.CS.loadBeneficiariesTable(localStorage.getItem("Name")).subscribe(res =>{
      localStorage.setItem("beneficiariesData", JSON.stringify(res))
      window.location.reload();
    })
    }else{
      alert("Este numero de cuenta ya posee el maximo de beneficiarios(3)")
      window.location.reload();
    }
    
  }
}
