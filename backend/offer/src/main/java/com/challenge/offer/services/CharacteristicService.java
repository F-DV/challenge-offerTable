package com.challenge.offer.services;

import com.challenge.offer.dao.CharacteristicDao;
import com.challenge.offer.dto.CharacteristicDto;
import com.challenge.offer.mappers.CharacteristicMapper;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacteristicService {

    @Autowired
    private CharacteristicDao characteristicDao;

    private CharacteristicMapper mapper = Mappers.getMapper(CharacteristicMapper.class);

    public List<CharacteristicDto> getCharacteristics(){
        return this.characteristicDao.getCharacteristic()
                .stream()
                .map(element -> mapper.characteristicEntityToCharacteristicDto(element))
                .collect(Collectors.toList());

    }
}
