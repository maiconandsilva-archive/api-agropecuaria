package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class CotacaoVenda extends PanacheEntity {
    public BigDecimal preco;

    @Enumerated(EnumType.STRING)
    public TipoAnimal tipoAnimal;

    @CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date data;
}
