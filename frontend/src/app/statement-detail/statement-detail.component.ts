import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-statement-detail',
  templateUrl: './statement-detail.component.html',
  styleUrls: ['./statement-detail.component.css']
})
export class StatementDetailComponent implements OnInit {

  constructor() { }
  headers:any = ["Compra","Descripción","Fecha","Moneda","Monto moneda Cuenta","MontoMonedaMovimiento", "Nuevo Saldo", "Operacion","Venta"]
  Rows = JSON.parse(localStorage.getItem("statementXDetail")?.toString() || '{}')
  cuentaActual = (Number(localStorage.getItem("CuentaActual")))

  ngOnInit(): void {
  }

}
