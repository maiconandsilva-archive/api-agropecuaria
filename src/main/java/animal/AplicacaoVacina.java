package animal;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data
@Entity
public class AplicacaoVacina {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToOne
	public Vacina vacina;
	
	@Temporal(TemporalType.DATE)
	private Date dataAplicada;

	void aplicarVacina() {
		this.dataAplicada = Date.from(Instant.now());
	}

	boolean isVacinaAplicada() {
		return dataAplicada != null;
	}
}
