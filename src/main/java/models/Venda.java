package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class Venda extends PanacheEntity implements AutoCloseable {
	public BigDecimal valorTotal;
	
	@OneToOne
	public CotacaoVenda cotacao;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date data;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venda")
	public List<AnimalVendido> animaisVendidos;

	public Venda(Venda venda) {
		this.valorTotal = venda.valorTotal;
		this.cotacao = venda.cotacao;
	}

	@Override
	public void close() {
		this.cotacao.persist();
		this.persist();
	}
}
