package com.challenge.offer.daoimpl;

import com.challenge.offer.dao.CharacteristicDao;
import com.challenge.offer.entities.CharacteristicEntity;
import com.challenge.offer.repositories.CharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacteristicMySqlDaoImpl implements CharacteristicDao {

    @Autowired
    CharacteristicRepository characteristicRepository;


    @Override
    public List<CharacteristicEntity> getCharacteristic() {
        return characteristicRepository.findAll();
    }
}
