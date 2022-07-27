package com.challenge.offer.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author FelipeQG
 * Clase que representa la tabla characteristics en la
 * base de datos
 */
@Entity
@Table(name = "characteristics")
public class CharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price_value")
    private Double price_value;

    @Column(name = "Description")
    private String description;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacteristicEntity that = (CharacteristicEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price_value, that.price_value) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price_value, description);
    }

    @Override
    public String toString() {
        return "CharacteristicEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price_value=" + price_value +
                ", description='" + description + '\'' +
                '}';
    }
}
