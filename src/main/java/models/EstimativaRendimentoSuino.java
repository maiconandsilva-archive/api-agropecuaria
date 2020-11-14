package models;

public class EstimativaRendimentoSuino
    implements CalculaEstimativaRendimentoCarcaca {
    @Override
    public double calcular(Animal animal) {
        double rendimento = 0.0;
        switch(animal.genero) {
        case FEMEA:
            rendimento = 0.54;
        case MACHO:
            rendimento = 0.55;
        }
        return rendimento;
    }
}

