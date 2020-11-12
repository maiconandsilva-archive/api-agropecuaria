package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Lote extends PanacheEntity {
    public String info;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lote")
    public List<AnimalVendido> animais;
}
