export interface Offer{
  id:number;
  name:string;
  price_value:number;
  description:string;
  characteristic_id:Characteristic_id;

}

export interface Characteristic_id{
  id:number;
  name:string;

}

export interface UpdatedCharacteristic extends Partial<Characteristic_id>{

}

export interface CreateDto extends Omit<Offer, 'id'>{

}
export interface UpdateDto extends Partial<CreateDto>{

}
