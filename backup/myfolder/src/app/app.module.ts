import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from '@angular/core';
import {Item} from 'src/model/item'
import { AppComponent } from './app.component';
import { CardItemComponent } from 'src/app/card-item/card-item.component';


import { RouterModule } from '@angular/router';
import { from } from 'rxjs';


@NgModule({
 
  declarations: [
    AppComponent,
    CardItemComponent
   
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([])
   
  ],
  providers: [Item],
  bootstrap: [AppComponent,CardItemComponent]
})
export class AppModule { }
