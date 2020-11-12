package services;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import models.Animal;


@GraphQLApi
@ApplicationScoped
public class AnimalService {
    @Mutation
    @Transactional
    public List<Animal> cadastrarAnimais(@Source List<Animal> animais) {
		for (Animal animal : animais) {
			animal.persist();
		}
		return animais;
	}
	
	@Query
	public List<Animal> getAnimaisCadastrados() {
		return Animal.listAll();
	}
}
