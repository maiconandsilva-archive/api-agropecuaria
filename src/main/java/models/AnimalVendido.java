package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.NoArgsConstructor;
import main.Config;


@Entity
@NoArgsConstructor
public class AnimalVendido extends AnimalBase {
	@Id
	public Long id;

	public Double pesoCarcacaKg;

	@ManyToOne
	public Venda venda;

	public AnimalVendido(Animal animal, 
			AnimalVendido animalVendaInput, Venda venda) {
		super(animal.raca, animal.lote, animal.aplicacaoVacinas,
			animal.genero, animal.dataNascimento, animal.peso);
		this.id = animal.id;
		this.venda = venda;
		this.pesoCarcacaKg = animalVendaInput.pesoCarcacaKg;
	}

	public Double getRendimentoCarcaca() {
		return this.pesoCarcacaKg / this.peso;
	}

	public Double getPesoCarcacaArroba() {
		return pesoCarcacaKg / Double.parseDouble(Config.get("arrobaQuilos"));
	}

	@Override
	public Double getPesoCarcacaKg() {
		return pesoCarcacaKg;
	}

	@Override
	public Double getPesoCarcacaUnidadePadrao() {
		return getPesoCarcacaArroba();
	}
}
