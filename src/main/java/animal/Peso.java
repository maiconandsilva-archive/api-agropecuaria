package animal;

import java.math.BigDecimal;

import javax.persistence.Embeddable;


import lombok.Data;

@Data
@Embeddable
public class Peso {
    /** Peso do animal vivo */
    private BigDecimal peso;
    
    /** Rendimento da carcaca do animal */
    private BigDecimal rendimento;

    /** Formula tirada de https://dicas.boisaude.com.br/como-calcular-arroba-do-boi/ */
    public BigDecimal emArroba() {
        return peso.multiply(rendimento).divide(BigDecimal.valueOf(15));
    }
}
