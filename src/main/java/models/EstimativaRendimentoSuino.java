package models;

public class EstimativaRendimentoSuino
    implements CalculaEstimativaRendimentoCarcaca {
    @Override
    public Double calcular(Animal animal) {
        Double rendimento = 0.0;
        switch(animal.genero) {
        case FEMEA:
            rendimento = 0.52;
        case MACHO:
            rendimento = 0.55;
        }
        return rendimento;
    }
}

