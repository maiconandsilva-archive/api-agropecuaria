package animal;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


public abstract class Animal {
	@Getter @Setter private long id;
	@Getter @Setter private long lote;
	@Getter @Setter private long origem;
	@Getter @Setter private BigDecimal peso;
	@Getter @Setter private char genero;
	@Getter @Setter private Date dataNascimento;
	public Raca raca;
	public CarteiraVacinacao cateiraVac;
}
