import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-secondheader',
  templateUrl: './secondheader.component.html',
  styleUrls: ['./secondheader.component.css']
})
export class SecondheaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  cerrarSesion(){
    localStorage.clear();
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() =>
      this.router.navigate(['home']));
  }

}
