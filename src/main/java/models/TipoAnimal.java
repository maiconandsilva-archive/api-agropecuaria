package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import cotacao.Unidade;


@AllArgsConstructor
public enum TipoAnimal {
    SUINO(new EstimativaRendimentoSuino(), Unidade.KG),
    BOVINO(new EstimativaRendimentoBovino(), Unidade.ARROBA);

    public CalculaEstimativaRendimentoCarcaca estimativaRendimento;
    
    private @Getter Unidade unidadePadrao;
}
