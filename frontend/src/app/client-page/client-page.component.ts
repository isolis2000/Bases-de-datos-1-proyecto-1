import { Component, OnInit } from '@angular/core';
import { CommunicationService } from '../communication/communication.service';



interface Result {
  usuario: string,
  pass: string,
  esAdministrador: number,
  tableData: string
  //NumeroCuenta: string,
  //TipoDocuIdentidad: string,
  //IdTipoMoneda: string,
  //Saldo: string

}


@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css']
})

export class ClientPageComponent implements OnInit {
  

  

  constructor(private CS:CommunicationService) { }
   headers:any = ["numCuenta", "tipoCuenta", "Moneda", "Saldo"]

  Rows = [
  {
    "numCuenta": 111,
    "tipoCuenta": "Ahorro",
    "Moneda": "$",
    "Saldo": 1000.00
  },
  {
    "numCuenta": 222,
    "tipoCuenta": "Pago",
    "Moneda": "$$$",
    "Saldo": 2000.00
  },
  {
    "numCuenta": 333,
    "tipoCuenta": "Pago",
    "Moneda": "euros",
    "Saldo": 3000.00
  }
]
  

  ngOnInit(): void {
    this.CS.loadAccountsTable(localStorage.getItem("Name")).subscribe(res => {
      const result: Result = JSON.parse(JSON.stringify(res))
      localStorage.setItem("tableData", result.tableData)
      alert(JSON.stringify(res))
    })
    
  }
  }
  


