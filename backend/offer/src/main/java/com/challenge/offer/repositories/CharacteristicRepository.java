package com.challenge.offer.repositories;

import com.challenge.offer.entities.CharacteristicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicRepository extends JpaRepository<CharacteristicEntity,Long> {
}
