package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import main.Config;


@Entity
@NoArgsConstructor
public class AnimalVendido extends AnimalBase {
	@Id
	public Long id;

	public Double pesoCarcacaKg;

	@Transient
	public @Getter Double rendimentoCarcaca;

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

	@PostLoad
	public void onLoad() {
		this.rendimentoCarcaca = this.pesoCarcacaKg / this.peso;
	}

	public Double getPesoCarcacaArroba() {
		return pesoCarcacaKg / Double.parseDouble(Config.get("arrobaQuilos"));
	}

	@Override
	public Double getPesoCarcacaKg() {
		return pesoCarcacaKg;
	}
}
