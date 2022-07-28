package com.challenge.offer.mappers;

import com.challenge.offer.dto.OfferDto;
import com.challenge.offer.entities.OfferEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author FelipeQG
 * Interfaz para mapear la entidad a un dto que sera el que se
 * le entregara al frontend.
 * En este proyecto utilizamos la libreria MapStruct como ayudar para
 * crear la implementacion de esta interfaz
 */
@Mapper
public interface OfferMapper {

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "name",source = "name"),
            @Mapping(target = "price_value",source = "price_value"),
            @Mapping(target = "description",source = "description"),
            @Mapping(target = "characteristic_id",source = "characteristic_id")
    })
    OfferDto offerEntityToOfferDto(OfferEntity offerEntity);

    @InheritInverseConfiguration
    OfferEntity offerDtoToOfferEntity(OfferDto offerDto);
}
