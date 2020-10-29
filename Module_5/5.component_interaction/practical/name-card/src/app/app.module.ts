import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NamecardComponent } from './namecard/namecard.component';
import { ProgessBarComponent } from './progess-bar/progess-bar.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    NamecardComponent,
    ProgessBarComponent,
    RatingBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
