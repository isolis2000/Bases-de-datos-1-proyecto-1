import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommunicationService } from '../communication/communication.service';

@Component({
  selector: 'app-statements',
  templateUrl: './statements.component.html',
  styleUrls: ['./statements.component.css']
})
export class StatementsComponent implements OnInit {

  constructor(private CS:CommunicationService, private router: Router) { }
  currentAccount:any=localStorage.getItem('current_username')
  ngOnInit(): void {
  }

  
}
