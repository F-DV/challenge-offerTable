package com.challenge.offer.dto;

import com.challenge.offer.entities.CharacteristicEntity;

import java.util.Objects;

/**
 * @author FelipeQG
 * la clase Dto nos permite de un modelo
 * para la interaccion con el cliente
 */
public class OfferDto {

    private Long id;
    private String name;
    private Double price_value;
    private String description;
    private CharacteristicEntity characteristic_id;

    public OfferDto(Long id, String name, CharacteristicEntity characteristic_id) {
        this.id = id;
        this.name = name;
        this.characteristic_id = characteristic_id;
    }

    public OfferDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice_value() {
        return price_value;
    }

    public void setPrice_value(Double price_value) {
        this.price_value = price_value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CharacteristicEntity getCharacteristic_id() {
        return characteristic_id;
    }

    public void setCharacteristic_id(CharacteristicEntity characteristic_id) {
        this.characteristic_id = characteristic_id;
    }

    @Override
    public String toString() {
        return "OfferDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price_value=" + price_value +
                ", description='" + description + '\'' +
                ", characteristic_id=" + characteristic_id +
                '}';
    }
}
