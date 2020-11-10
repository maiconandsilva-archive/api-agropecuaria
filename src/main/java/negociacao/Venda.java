package negociacao;
import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.OneToOne;

import animal.Lote;


@Data
public class Venda {
	@OneToOne
	private Lote lote;

	private BigDecimal valorTotal;
}
