package models;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Vacina extends PanacheEntity {
    public String nome;
}
