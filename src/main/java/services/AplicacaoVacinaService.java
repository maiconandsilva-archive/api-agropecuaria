package services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import models.AplicacaoVacina;

@GraphQLApi
@ApplicationScoped
public class AplicacaoVacinaService {
	@Mutation("agendarAplicacaoVacina")
    @Transactional
    public AplicacaoVacina agendarAplicacao(AplicacaoVacina aplicacaoVacina) {
        aplicacaoVacina.persist();
        return aplicacaoVacina;
    }
}
