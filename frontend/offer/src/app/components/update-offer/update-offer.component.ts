import { Component, OnInit, Input } from '@angular/core';
import { Offer, Characteristic_id, UpdateDto, CreateDto, UpdatedCharacteristic } from 'src/app/model/offers.model';
import { OffersServiceService } from 'src/app/services/offers-service.service';
import { CharacteristicsServiceService } from 'src/app/services/characteristics-service.service';

@Component({
  selector: 'app-update-offer',
  templateUrl: './update-offer.component.html',
  styleUrls: ['./update-offer.component.css']
})
export class UpdateOfferComponent implements OnInit {

  //Asignamos un id cuando es presionado el boton editar en el componente padre
  @Input() set assingId(idChosen:number){
    this.idChosen = idChosen;
    console.log(this.idChosen);
  }

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
  offerChosen: Offer = {
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

  update(){

    try{
      //Modelo para actualizar offerta desde la vista
      const change: UpdateDto = {
        name:this.offerChosen.name,
        price_value:this.offerChosen.price_value,
        description:this.offerChosen.description,
        characteristic_id:this.characteristicChosen
      }


      this.offersService.updateOffer(this.idChosen,change)
      .subscribe(data =>{
        const offerIndex = this.offers.findIndex(item => item.id === this.offerChosen.id);
        this.offers[offerIndex] = data;
      })
    }catch(error){
      console.log("La oferta no fue editada",error);
      alert("La tarea no se edito");
    }
  }
  cancel(){
    this.offerChosen = {
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

}
