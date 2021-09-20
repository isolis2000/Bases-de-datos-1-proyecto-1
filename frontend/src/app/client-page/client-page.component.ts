import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  

  

  constructor(private CS:CommunicationService, private router: Router) { }
   headers:any = ["numCuenta", "tipoCuenta", "Moneda", "Saldo"]
   Rows = JSON.parse(localStorage.getItem("tableData")?.toString() || '{}')
   
   

  
  
  
  ngOnInit(): void {
  }

  refresh(): void {
    window.location.reload();
  }

  goToBen(numCuenta:any){
    this.CS.loadBeneficiariesTableApart(Number(numCuenta)).subscribe(res =>{
      localStorage.setItem("benXAccount", JSON.stringify(res))
      this.router.navigate(['/beneficiariesPage'])
    })
  }

  }
  
  


