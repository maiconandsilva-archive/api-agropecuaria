package services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import cotacao.Cotacao;
import models.Animal;
import models.AplicacaoVacina;
import models.Genero;


@GraphQLApi
@ApplicationScoped
public class AnimalService {
    @Mutation
    @Transactional
    public List<Animal> cadastrarAnimais(List<Animal> animais) {
		for (Animal animal : animais) {
			animal.persist();
		}
		return animais;
	}
	
	@Query
	public List<Animal> getAnimaisCadastrados() {
		return Animal.listAll();
	}

	@Query("quantidadeAnimais")
	public long contarAnimais() {
		return Animal.count();
	}

	@Query("quantidadeAnimaisVacinados")
	public long contarAnimaisVacinados() {
		return AplicacaoVacina.find("aplicada", true).count();
	}

	@Query
	public long contarAnimaisPorGenero(Genero genero) {
		return Animal.find("genero", genero).count();
	}

	@Query("valorTotalRebanho")
	@Transactional
	public BigDecimal calcularValorTotalRebanho() {
		return Animal.findAll().stream()
			.map( _animal -> {
				Animal animal = ((Animal) _animal);
				return Cotacao.get(animal.raca.tipoAnimal).preco
					.multiply(new BigDecimal(animal.getPesoCarcacaUnidadePadrao()));
			}).reduce(new BigDecimal(0), (subtotal, el) -> subtotal.add(el))
			.setScale(2, RoundingMode.UP);
	}

	@Query("pesoTotalQuilo")
	public Double calcularPesoTotalQuilo() {
		return Animal.findAll().stream()
			.mapToDouble((animal) -> ((Animal) animal).getPesoCarcacaKg()).sum();
	}

	@Query("pesoTotalArroba")
	public Double calcularPesoTotalArroba() {
		return Animal.findAll().stream()
			.mapToDouble((animal) -> {
				return ((Animal) animal).getPesoCarcacaArroba();
			}).sum();
	}
}
