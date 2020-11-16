package cotacao;

import java.math.BigDecimal;

import models.CotacaoVenda;
import models.TipoAnimal;

public class Cotacao {
    public static CotacaoVenda get(TipoAnimal tipoAnimal) {
        /** TODO: */
        String valor = null;

        switch (tipoAnimal) {
        case SUINO:
            valor = "9.7";
            break;
        case BOVINO:
            valor = "100";
        }
        return new CotacaoVenda(
            new BigDecimal(valor) , "SAO PAULO", tipoAnimal.unidadePadrao);
    }
}
