import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-beneficiaries-page',
  templateUrl: './beneficiaries-page.component.html',
  styleUrls: ['./beneficiaries-page.component.css']
})
export class BeneficiariesPageComponent implements OnInit {

  constructor() { }
  headers:any = ["Nombre", "Parentezco", "Porcentaje"]
  Rows = JSON.parse(localStorage.getItem("benXAccount")?.toString() || '{}')
  numBen = (Number(localStorage.getItem("current_percentage")))

  ngOnInit(): void {
    
  }

}
