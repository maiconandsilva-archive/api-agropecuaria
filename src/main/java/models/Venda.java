package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Venda extends PanacheEntity {
	@OneToOne
	public Lote lote;

	public BigDecimal valorTotal;
	
	public CotacaoVenda cotacao;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date data;
}
