package services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import cotacao.Cotacao;
import models.Animal;


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

	public Stream<BigDecimal> calcularValor(Stream<Animal> animais) {
		return animais.map(animal -> {
			return Cotacao.get(animal).preco.multiply(
				new BigDecimal(animal.getPesoCarcacaUnidadePadrao()));
		});
	}

	public BigDecimal somarValores(Stream<BigDecimal> valoresAnimais) {
		return valoresAnimais.reduce(
			new BigDecimal(0), (subtotal, el) -> subtotal.add(el))
			.setScale(2, RoundingMode.HALF_UP);
	}

	public Double somarPesos(Stream<Double> pesoAnimais) {
		return pesoAnimais.mapToDouble(Double::valueOf).sum();
	}

	public Stream<Double> calcularPeso(
			Stream<Animal> animais,
			Function<? super Animal, ? extends Double> pesoMapper) {
		return animais.map(pesoMapper);
	}
}
