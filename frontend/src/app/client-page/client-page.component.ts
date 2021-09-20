import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommunicationService } from '../communication/communication.service';



interface Result {
  usuario: string,
  pass: string,
  esAdministrador: number,
  tableData: string,
  porcentaje:number,
  cantidadDeBeneficiarios:number

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
   userStr:any=localStorage.getItem('current_username')
   accountPercentage:any
   numBen:any
   

  
  
  
  ngOnInit(): void {
  }

  refresh(): void {
    window.location.reload();
  }

  goToBen(numCuenta:any){
    

      

      this.CS.loadBeneficiariesTableApart(Number(numCuenta)).subscribe(res =>{
        if(numCuenta != ''){
          localStorage.setItem("benXAccount", JSON.stringify(res))  
          if(localStorage.getItem("benXAccount") != '[]'){
            this.router.navigate(['/beneficiariesPage'])

            this.CS.totalPercentage(Number(numCuenta)).subscribe(res => {
              const result: Result = JSON.parse(JSON.stringify(res))
              localStorage.setItem("current_percentage", String(result.porcentaje))
              this.accountPercentage = localStorage.getItem("current_percentage")
              

              if(this.accountPercentage<100){
                alert("Porcentaje total de los beneficiarios de esta cuenta es menor a 100")
              }
              if(this.accountPercentage>100){
                alert("Porcentaje total de los beneficiarios de esta cuenta es mayor a 100")
              }
              this.refresh()
            })

            this.CS.numberOfBeneficiaries(Number(numCuenta)).subscribe(res => {
              const result: Result = JSON.parse(JSON.stringify(res))
              localStorage.setItem("current_num_ben", String(result.cantidadDeBeneficiarios))
            })

          }
          if(localStorage.getItem("benXAccount") == '[]'){
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
  
  


