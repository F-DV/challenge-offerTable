package com.challenge.offer.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author FelipeQG
 * Clase que representa la tabla de ofertas en la
 * base de datos
 */
@Entity
@Table(name = "offers")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Characteristic_id")
    private CharacteristicEntity characteristic_id;

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

    public CharacteristicEntity getCharacteristic_id() {
        return characteristic_id;
    }

    public void setCharacteristic_id(CharacteristicEntity characteristic_id) {
        this.characteristic_id = characteristic_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferEntity that = (OfferEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(characteristic_id, that.characteristic_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, characteristic_id);
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", characteristic_id=" + characteristic_id +
                '}';
    }
}
