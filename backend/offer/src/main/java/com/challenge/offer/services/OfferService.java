package com.challenge.offer.services;

import com.challenge.offer.dao.OfferDao;
import com.challenge.offer.dto.OfferDto;
import com.challenge.offer.entities.OfferEntity;
import com.challenge.offer.mappers.OfferMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FelipeQG
 * Servicio para hacer uso del mapper.
 * Se mapea las entidades a Dto para "enviarselas en Json al frontEnd o
 * mappear Dtos a entidades.
 */
@Service
public class OfferService {



    @Autowired
    private OfferDao offerDao;

    private OfferMapper mapper = Mappers.getMapper(OfferMapper.class);

    /**
     * servicio get para lista de offertas
     * @return retorna Lista de offertas
     */
    public List<OfferDto> getOffers(){
        return this.offerDao.getOffers()
                .stream()
                .map(element -> mapper.offerEntityToOfferDto(element))
                .collect(Collectors.toList());
    }

    /**
     * Servicio para crear una oferta en la base de datos
     * @param offerDto que va a crear
     * @return retorna la oferta creada
     */
    public OfferDto createOffer(OfferDto offerDto){
        OfferEntity newOffer = mapper.offerDtoToOfferEntity(offerDto);
        this.offerDao.saveOffer(newOffer);
        return mapper.offerEntityToOfferDto(newOffer);
    }

    /**
     * Servicio para buscar una oferta por id
     * @param id de la oferta que se desea buscar en la base de datos
     * @return retorna la oferta que corresponde al id entregado por parametro
     */
    public OfferDto findById(Long id){
        OfferDto offerDto = mapper.offerEntityToOfferDto(
                this.offerDao.findById(id));
        return offerDto;
    }

    /**
     * Servicio para Editar una oferta
     * @param id de la oferta a editar
     * @param offerDto oferta con los cambios editados en el frontend
     * @return retorna la oferta editada
     */
    public OfferDto updateOffer(Long id,OfferDto offerDto){

        OfferDto offerDto1 = findById(id);
        offerDto1.setName(offerDto.getName());
        offerDto1.setCharacteristic_id(offerDto.getCharacteristic_id());

        OfferEntity update = mapper.offerDtoToOfferEntity(offerDto1);
        this.offerDao.saveOffer(update);

        return offerDto1;
    }

    /**
     * Servicio para eliminar una oferta
     * @param id de la oferta que se eliminara en base de datos
     * @return verdadero si la oiferta se elimino correctamente
     */
    public boolean deleteOffer(Long id){
        try{
            this.offerDao.deleteOffer(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
