package com.challenge.offer.dao;

import com.challenge.offer.entities.OfferEntity;

import java.util.List;

public interface OfferDao {

    List<OfferEntity> getOffers();
    OfferEntity findById(Long id);
    void saveOffer(OfferEntity offerEntity);
    void deleteOffer(Long id);
}
