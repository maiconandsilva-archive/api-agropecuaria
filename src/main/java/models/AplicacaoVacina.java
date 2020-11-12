package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class AplicacaoVacina extends PanacheEntity {
	@OneToOne
	public Vacina vacina;
	
	@ManyToOne
	public Animal animal;

	@Temporal(TemporalType.DATE)
	public Date dataAplicacao;

	public boolean aplicada;

	public void aplicarVacina() {
		this.aplicada = true;
	}
}
