package services;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import models.Animal;
import models.AplicacaoVacina;
import models.Genero;


@GraphQLApi
public class RelatorioRebanho {
	@Query
	public long getQuantidadeAnimais() {
		return Animal.count();
	}

	@Query
	public long getQuantidadeAnimaisMacho() {
		return Animal.find("genero", Genero.MACHO).count();
	}

	@Query
	public long getQuantidadeAnimaisFemea() {
		return Animal.find("genero", Genero.FEMEA).count();
	}

	@Query
	public BigDecimal getValorRebanho() {
		return new BigDecimal(1);
	}

	public long quantidadeVacinada() {
		return AplicacaoVacina.find("aplicada", true).count();
	}
}
