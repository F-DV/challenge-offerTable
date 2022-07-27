package com.challenge.offer.daoimpl;

import com.challenge.offer.dao.OfferDao;
import com.challenge.offer.entities.OfferEntity;
import com.challenge.offer.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementador del DAO, En este implementador utilizamos la interfaz
 * OfferRepository para realizar los metodos crud especificamente para
 * bases de datos MySql
 */
@Repository
public class OfferMySqlDaoImpl implements OfferDao {

    //Inyeccion de dependencia OfferRepository
    @Autowired
    private OfferRepository offerRepository;

    //Traemos las ofertas dispoibles en la base de datos
    @Override
    public List<OfferEntity> getOffers() {
        return this.offerRepository.findAll();
    }

    @Override
    public OfferEntity findById(Long id) {
        return this.offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    @Override
    public void saveOffer(OfferEntity offerEntity) {
        this.offerRepository.save(offerEntity);
    }

    @Override
    public void deleteOffer(Long id) {
        this.offerRepository.deleteById(id);
    }
}
