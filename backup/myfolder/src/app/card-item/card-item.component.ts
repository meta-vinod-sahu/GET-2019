import { Component, OnInit } from '@angular/core';
import { Item } from '../../model/item';
import { HttpClient } from "@angular/common/http";
import { ActivatedRoute } from '@angular/router'

@Component({
  selector : 'app-card-item',
  templateUrl: './card-item.component.html',
  styleUrls: ['./card-item.component.css']
})
export class CardItemComponent  implements OnInit  {
  data: any;
 
 
constructor(private http: HttpClient, private route: ActivatedRoute , private item : Item) {

}
private subscriber: any;
textString:String;

ngOnInit()
	{
   
		this.subscriber = this.route.params.subscribe(params => {
	       
	       this.http.get('http://localhost:3000/getItemCart').subscribe((data:any) => {
          //  cartItem = JSON.parse(JSON.stringify(data));
          
          this.data = data;
          console.log(this.data);
		    });
      });
       
     
	}

}
