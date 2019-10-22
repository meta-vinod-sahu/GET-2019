import { Injectable, EventEmitter, Optional } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpParams} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  $cartItemData = new EventEmitter();
  $addItem = new EventEmitter();
  subscriber: any;
  data: any;
  allCategory : string;
 
  
  
  constructor(private http : HttpClient, private route: ActivatedRoute ) {
    this.allCategory = "allCategory";
  }

  sendDataToService(cart:any){
    
  
   this.$addItem.emit(cart) ; 
  }

  getItem(value){
   
    if(value=='allCategory'){
     
      this.subscriber = this.route.params.subscribe(params => {
	       
        this.http.get('http://localhost:3000/getAllItemCart').subscribe((data:any) => {
          //  cartItem = JSON.parse(JSON.stringify(data));
         
         this.data = data;
         this.$cartItemData.emit(this.data);
        
       });
      });
    }
    else{
      let param = new HttpParams().set("category",value);

      this.subscriber = this.route.params.subscribe(params => {
           
        this.http.get('http://localhost:3000/getItemCart',{params:param}).subscribe((data:any) => {
         //  cartItem = JSON.parse(JSON.stringify(data));
         this.data = data;
         this.$cartItemData.emit(this.data);
        
       
       });
     });
    }
    
    
   
  }
}
