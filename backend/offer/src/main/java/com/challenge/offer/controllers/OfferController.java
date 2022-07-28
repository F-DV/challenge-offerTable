package com.challenge.offer.controllers;

import com.challenge.offer.dto.OfferDto;
import com.challenge.offer.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FelipeQG
 * Controlador para exponer nuestra API Json al cliente
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class OfferController {

    @Autowired
    private OfferService offerService;

    /**
     *
     * @return retorna la lista de ofertas de la base de datos
     */
    @GetMapping(path = "offers")
    public List<OfferDto> getOffers(){

        return this.offerService.getOffers();
    }

    /**
     * Controlador para crear una oferta nueva en base de datos
     * @param offerDto se recibe cuerpo de la oferta que se va a crear
     * @return retorna la oferta creada
     */
    @PostMapping(path = "/saveOffer")
    public OfferDto createOffer(@RequestBody OfferDto offerDto){
        return this.offerService.createOffer(offerDto);
    }

    /**
     * Controlador para actualizar una oferta existente en BD
     * @param id de la oferta a actulizar
     * @param offerDto cuerpo de la oferta actualizada
     * @return retorna oferta actualizada
     */
    @PutMapping(path = "/{id}")
    public OfferDto updateOffer(@PathVariable Long id, @RequestBody OfferDto offerDto){

        return this.offerService.updateOffer(id,offerDto);
    }

    /**
     * Controlador para elimnar una oferta de la base de datos
     * @param id de la oferta a elinar
     * @return Retorna un mensaje si la oferta se elimino o no correctamente
     */
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.offerService.deleteOffer(id);
        if(ok){
            return "La Oferta fue elimada con exito";
        }else{
            return "No se elimino la oferta";
        }
    }
}
