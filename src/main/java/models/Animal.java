package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal extends PanacheEntity {
	@ManyToOne
	public Raca raca;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
	public List<AplicacaoVacina> aplicacaoVacinas = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	public Genero genero;

	@Temporal(TemporalType.DATE)
	public Date dataNascimento;

	/** Peso do animal vivo */
	public BigDecimal peso;

	/** Rendimento da carcaca do animal */
	@Transient
	public CalculaRendimentoCarcaca calculaRendimentoCarcaca;

	// public CalculaRendimentoCarcaca getRendimentoCarcaca() {
	// 	return new RendimentoCarcaca(this);
	// 	// return null;
	// }

	// /** Formula tirada de https://dicas.boisaude.com.br/como-calcular-arroba-do-boi/ */
	// public BigDecimal pesoCarcacaArroba() {
	// 	return peso
	// 			.multiply(rendimentoCarcaca.calcularRendimento(this))
	// 			.divide(BigDecimal.valueOf(15));
	// }

	// public BigDecimal pesoCarcacaQuilo() {
	// 	return peso
	// 	.multiply(rendimentoCarcaca.calcularRendimento(this))
	// 	.divide(BigDecimal.valueOf(15));
	// }
}
