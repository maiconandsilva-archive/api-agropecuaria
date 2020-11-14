package models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoAnimal {
    SUINO(new EstimativaRendimentoSuino()),
    BOVINO(new EstimativaRendimentoBovino());

    public CalculaEstimativaRendimentoCarcaca estimativaRendimento;
}
