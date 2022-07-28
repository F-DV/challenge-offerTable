import { Component, OnInit } from '@angular/core';
import { Offer } from 'src/app/model/offers.model';
import { OffersServiceService } from 'src/app/services/offers-service.service';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {

  offers: Offer[] = [];
  editId:number = 0;

  constructor(
    private offerService:OffersServiceService
  ) { }

  ngOnInit(): void {
    this.getOffers();
  }

  getOffers(){
    this.offerService.getOffers()
    .subscribe(data => {
      this.offers = data;
    })
  }
  deletOffer(id:number){
    this.offerService.delete(id)
    .subscribe(data => console.log(data));
    this.getOffers();
  }

  edit(id:number){
    this.editId = id;
  }


}
