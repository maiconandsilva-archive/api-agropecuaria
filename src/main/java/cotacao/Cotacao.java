package cotacao;

import java.math.BigDecimal;

import models.AnimalBase;
import models.CotacaoVenda;

public class Cotacao {
    public static CotacaoVenda get(AnimalBase animal) {
        /** TODO: */
        String valor = null;

        switch (animal.raca.tipoAnimal) {
        case SUINO:
            valor = "9.7";
            break;
        case BOVINO:
            valor = "100";
        }
        return new CotacaoVenda(
            new BigDecimal(valor) , "SAO PAULO", animal.raca.tipoAnimal.getUnidadePadrao());
    }
}
