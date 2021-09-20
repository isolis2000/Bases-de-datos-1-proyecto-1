import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from "@angular/forms";

import { CommunicationService } from '../communication/communication.service';

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

  ngOnInit(): void {
  }

  updateBenValue(value:number){
    this.benValue = value;
  }

  showData(s1:any,s2:any,s3:any,value:any){
    localStorage.setItem("s1", String(s1))
    localStorage.setItem("s2",String(s2))
    localStorage.setItem("s3",String(s3))
    localStorage.setItem("s4",String(value))


  }
  deleteBen(numCuenta:number, valorDocIdentidad:number, porcentaje:number){
    this.CS.deleteBen(numCuenta,valorDocIdentidad,porcentaje,this.benValue).subscribe()
  }
  editBen(numCuenta:number, valorDocIdentidad:number, porcentaje:number){

  }
  addBen(numCuenta:any, valorDocIdentidad:any, porcentaje:any){
    this.CS.addBen(Number(numCuenta),Number(valorDocIdentidad),Number(porcentaje),this.benValue).subscribe()
  }
}
