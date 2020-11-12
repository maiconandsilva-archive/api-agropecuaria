package services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Source;

import models.Animal;
import models.AnimalVendido;
import models.Lote;
import models.Venda;

@GraphQLApi
@ApplicationScoped
public class RegistroVenda {
    @Mutation
    @Transactional
    public List<AnimalVendido> registrarVenda(
            @Source List<Integer> idAnimais, @Source Venda venda) {
        Lote lote = new Lote(); lote.persist();
        List<AnimalVendido> animaisVendidos = new ArrayList<>();
        Animal animal;

        for (Integer id : idAnimais) {
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

        AnimalVendido animalVendido = new AnimalVendido(animal);
        animalVendido.lote = lote;
        animalVendido.persist();
        animal.delete();
        return animalVendido;
    }
}
