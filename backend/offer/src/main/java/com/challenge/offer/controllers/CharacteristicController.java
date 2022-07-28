package com.challenge.offer.controllers;

import com.challenge.offer.dto.CharacteristicDto;
import com.challenge.offer.services.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class CharacteristicController {

    @Autowired
    private CharacteristicService characteristicService;

    @GetMapping("/characteristics")
    public List<CharacteristicDto> getCharacteristics(){
        return this.characteristicService.getCharacteristics();
    }
}
