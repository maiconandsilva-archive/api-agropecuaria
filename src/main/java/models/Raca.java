package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Raca extends PanacheEntity {
    public String nome;

    @Enumerated(EnumType.STRING)
    public TipoAnimal tipoAnimal;
}
