import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Offer, CreateDto, UpdateDto } from '../model/offers.model';
@Injectable({
  providedIn: 'root'
})
export class OffersServiceService {

  constructor(
    private httpClient: HttpClient
  ) { }

  private baseUrl = "http://localhost:8082/api/";

  //Obtener Offertas
  getOffers():Observable<Offer[]>{
    return this.httpClient.get<Offer[]>(`${this.baseUrl}offers`);
  }

  //Crear una oferta
  createOffer(dto:CreateDto){
    return this.httpClient.post<Offer>(`${this.baseUrl}saveOffer`,dto);
  }


  //actualizar una oferta
  updateOffer(id:number,dto:UpdateDto){
    return this.httpClient.put<Offer>(`${this.baseUrl}${id}`,dto);
  }

  //Eliminar una oferta
  delete(id:number){
    return this.httpClient.delete<Offer>(`${this.baseUrl}${id}`);
  }

}
