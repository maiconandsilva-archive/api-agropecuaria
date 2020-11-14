package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.RequiredArgsConstructor;
import main.Config;


@Entity
@RequiredArgsConstructor
public class Animal extends AnimalBase {
    @Id
    @GeneratedValue
    public Long id;

	public double getRendimentoCarcaca() {
		return raca.tipoAnimal.estimativaRendimento.calcular(this);
	}

	public double pesoArroba() {
		return peso * getRendimentoCarcaca()
			/ Double.parseDouble(Config.get("arrobaQuilos"));
	}
}
