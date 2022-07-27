package com.challenge.offer.repositories;

import com.challenge.offer.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author FelipeQG
 * Utilizamos JpaRepository para realizar el crud a la base de datos
 */
@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
