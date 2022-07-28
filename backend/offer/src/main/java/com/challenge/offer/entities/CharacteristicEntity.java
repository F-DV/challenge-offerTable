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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacteristicEntity that = (CharacteristicEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "CharacteristicEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
