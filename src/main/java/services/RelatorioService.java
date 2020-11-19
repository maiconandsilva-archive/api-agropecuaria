package services;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import models.Animal;
import models.AplicacaoVacina;
import models.Genero;


@GraphQLApi
public class RelatorioService {
    @Inject
    AnimalService animalService;

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
	public BigDecimal calcularValorTotalRebanho() {
		return animalService.somarValores(
            animalService.calcularValor(Animal.streamAll()));
    }
    
    @Query("pesoTotalRebanhoQuilo")
	public Double calcularPesoTotalRebanhoQuilo() {
        return somarPesoQuilo(Animal.listAll());
    }
    
    @Query("somaPesoQuilo")
    public Double somarPesoQuilo(List<Animal> animais) {
        return animalService.somarPesos(animalService.calcularPeso(
                animais.stream(), Animal::getPesoCarcacaKg));
	}

	@Query("pesoTotalRebanhoArroba")
	public Double calcularPesoTotalRebanhoArroba() {
        return somarPesoArroba(Animal.listAll());
    }
    
    @Query("somaPesoArroba")
	public Double somarPesoArroba(List<Animal> animais) {
        return animalService.somarPesos(animalService.calcularPeso(
            Animal.streamAll(), Animal::getPesoCarcacaArroba));
	}
}
