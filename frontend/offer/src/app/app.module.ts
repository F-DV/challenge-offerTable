import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OffersComponent } from './components/offers/offers.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UpdateOfferComponent } from './components/update-offer/update-offer.component';
import { CreateOfferComponent } from './components/create-offer/create-offer.component';

@NgModule({
  declarations: [
    AppComponent,
    OffersComponent,
    UpdateOfferComponent,
    CreateOfferComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
