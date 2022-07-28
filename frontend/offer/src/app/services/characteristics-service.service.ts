import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Characteristic_id } from '../model/offers.model';

@Injectable({
  providedIn: 'root'
})
export class CharacteristicsServiceService {

  constructor(
    private httpClient:HttpClient
  ) { }

  private baseUrl = "http://localhost:8082/api/";

  //Obtener Characteristics
  getCharacteristics():Observable<Characteristic_id[]>{
    return this.httpClient.get<Characteristic_id[]>(`${this.baseUrl}offers`);
}
}
