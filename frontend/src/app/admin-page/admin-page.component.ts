import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  constructor() { }
  headers:any = ["Numero de Cuenta", "Tipo de cuenta", "Moneda", "Saldo"]
  Rows = JSON.parse(localStorage.getItem("tableData")?.toString() || '{}')

  ngOnInit(): void {
  }



}
