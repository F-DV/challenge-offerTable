package com.challenge.offer.mappers;

import com.challenge.offer.dto.CharacteristicDto;
import com.challenge.offer.entities.CharacteristicEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CharacteristicMapper {

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "name",source = "name"),

    })
    CharacteristicDto characteristicEntityToCharacteristicDto(CharacteristicEntity characteristicEntity);

    @InheritInverseConfiguration
    CharacteristicEntity characteristicDtoToCharacteristicEntity(CharacteristicDto characteristicDto);
}
