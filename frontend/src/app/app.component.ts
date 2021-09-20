import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <!-- header -->
    

    <!-- routes to other pages -->
    <router-outlet></router-outlet>

    <!-- footer -->
    
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'proyecto1';
}