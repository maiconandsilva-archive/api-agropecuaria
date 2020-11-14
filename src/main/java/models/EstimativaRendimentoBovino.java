package models;

public class EstimativaRendimentoBovino
    implements CalculaEstimativaRendimentoCarcaca{

    @Override
    public double calcular(Animal animal) {
        return 0.5;
    }
}
