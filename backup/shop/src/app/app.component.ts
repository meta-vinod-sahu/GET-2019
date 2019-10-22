import { Component } from '@angular/core';
import { ServiceService } from './service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private service : ServiceService){

  }
  title = 'shopping';
  onChange(value) {
       this.service.getItem(value);
    
}
  
}