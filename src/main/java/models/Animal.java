package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.RequiredArgsConstructor;
import main.Config;


@Entity
@RequiredArgsConstructor
public class Animal extends AnimalBase implements AutoCloseable {
    @Id
    @GeneratedValue
    public Long id;

	public Double getRendimentoCarcaca() {
		return raca.tipoAnimal.estimativaRendimento.calcular(this);
	}

	public Double getPesoCarcacaKg() {
		return this.peso * this.getRendimentoCarcaca();
	}

	public Double getPesoCarcacaArroba() {
		return peso * getRendimentoCarcaca()
			/ Double.parseDouble(Config.get("arrobaQuilos"));
	}

	@Override
	public void close() {
		this.aplicacaoVacinas.forEach(aV -> aV.persist());
		// this.lote.persist();
		this.persist();
	}

	@Override
	public Double getPesoCarcacaUnidadePadrao() {
		return getPesoCarcacaKg();
	}
}
