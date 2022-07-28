import { Component, OnInit } from '@angular/core';
import { Characteristic_id, CreateDto, Offer, UpdatedCharacteristic } from 'src/app/model/offers.model';
import { CharacteristicsServiceService } from 'src/app/services/characteristics-service.service';
import { OffersServiceService } from 'src/app/services/offers-service.service';

@Component({
  selector: 'app-create-offer',
  templateUrl: './create-offer.component.html',
  styleUrls: ['./create-offer.component.css']
})
export class CreateOfferComponent implements OnInit {

  //caracteristicas actuales en base de datos
  characteristics:UpdatedCharacteristic[] = [];

  //Id elegido
  idChosen:number = 0;

  offers:Offer[] = [];

  //almacenamos caracteristicas actualizada
  characteristicChosen:Characteristic_id={
    id:0,
    name:""
  }

  //almacenamos offerta con datos actualizados
  offer: Offer = {
    id:0,
    name:"",
    price_value:0,
    description:"",
    characteristic_id:this.characteristicChosen
  }

  constructor(
    private offersService:OffersServiceService,
    private characteristicService:CharacteristicsServiceService
  ) { }

  ngOnInit(): void {
    this.getCharacteristics();
  }
  cancel(){
    this.offer = {
      id:0,
      name:"",
      price_value:0,
      description:"",
      characteristic_id:this.characteristicChosen
    }
  }

  getCharacteristics(){
    this.characteristicService.getCharacteristics()
    .subscribe(data => {
      this.characteristics = data;
    })
  }

  createOffer(){

    try{
      //Modelo para crear offerta
      const change: CreateDto = {
        name:this.offer.name,
        price_value:this.offer.price_value,
        description:this.offer.description,
        characteristic_id:this.characteristicChosen
      }

      this.offersService.createOffer(change)
      .subscribe(data =>{
       this.offer = data;
      });
    }catch(error){
      console.log("La oferta no fue creada");
    }

  }

}
