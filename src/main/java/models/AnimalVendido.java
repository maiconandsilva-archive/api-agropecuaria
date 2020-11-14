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

	@ManyToOne
	public Lote lote;

	public double pesoCarcaca;

	@Transient
	public @Getter double rendimentoCarcaca;

	public AnimalVendido(Lote lote, Animal animal, double pesoCarcaca) {
		super(animal.raca, animal.aplicacaoVacinas,
			animal.genero, animal.dataNascimento, animal.peso);
		this.id = animal.id;
		this.lote = lote;
		this.pesoCarcaca = pesoCarcaca;
	}

	@PostLoad
	public void onLoad() {
		this.rendimentoCarcaca = this.pesoCarcaca / this.peso;
	}

	public double pesoArroba() {
		return pesoCarcaca / Double.parseDouble(Config.get("arrobaQuilos"));
	}
}
