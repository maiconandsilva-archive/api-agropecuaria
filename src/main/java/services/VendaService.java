package services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import models.Animal;
import models.AnimalVendido;
import models.Venda;


@GraphQLApi
@ApplicationScoped
public class VendaService {
    @Mutation
    @Transactional
    public List<Long> registrarVenda(
            List<AnimalVendido> animaisVendaInput, Venda vendaInput) {
        List<Long> idsErroAnimal = new ArrayList<>();
        
        Animal animal;
        AnimalVendido animalVenda;

        try (Venda venda = new Venda(vendaInput)) {
            for (AnimalVendido animalVendaInput: animaisVendaInput) {
                animal = Animal.findById(animalVendaInput.id);
                try {
                    animalVenda = new AnimalVendido(
                        animal, animalVendaInput, venda);
                    animalVenda.persist();
                    animal.delete();
                } catch(Exception e) {
                    idsErroAnimal.add(animalVendaInput.id);
                }
            }
        }
        return idsErroAnimal;
    }
}
