package services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import models.Animal;
import models.AnimalVendido;
import models.Lote;
import models.Venda;


@GraphQLApi
@ApplicationScoped
public class VendaService {
    @Mutation
    @Transactional
    public List<AnimalVendido> registrarVenda(
            List<Long> idAnimais, @Valid Venda venda) {
        Lote lote = new Lote();
        lote.persist();
        
        List<AnimalVendido> animaisVendidos = new ArrayList<>();
        Animal animal;

        for (Long id : idAnimais) {
             animal = Animal.findById(id);
             animaisVendidos.add(mapToVendido(animal, lote));
             animal.delete();
        }
        venda.lote = lote;
        venda.persist();
        return animaisVendidos;
    }

    @Transactional
    public AnimalVendido mapToVendido(Animal animal, Lote lote) {
        if (!animal.isPersistent())
            throw new IllegalArgumentException("Animal doesn't exist");

        AnimalVendido animalVendido = new AnimalVendido(lote, animal, 0.0);
        animalVendido.persist();
        return animalVendido;
    }
}
