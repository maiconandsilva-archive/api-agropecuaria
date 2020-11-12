package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class AnimalVendido extends Animal {
	public AnimalVendido(Animal animal) {
		this.id = animal.id;
		this.raca = animal.raca;
		this.peso = animal.peso;
		this.genero = animal.genero;
		this.dataNascimento = animal.dataNascimento;
		this.aplicacaoVacinas = animal.aplicacaoVacinas;
	}

	@ManyToOne
	public Lote lote;
}
