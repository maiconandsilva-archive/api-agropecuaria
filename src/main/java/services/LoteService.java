package services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import models.Lote;

@GraphQLApi
@ApplicationScoped
public class LoteService {
	@Mutation
	@Transactional
	public Lote novoLote(Lote lote) {
        lote.persist();
        return lote;
	}
}
