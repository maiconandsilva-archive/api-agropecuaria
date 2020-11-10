package animal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	public Raca raca;
	
	@ManyToOne
	public Lote lote;

	@OneToOne(cascade = CascadeType.ALL)
	public CarteiraVacinacao cateiraVacinacao;

	@Embedded
	private Peso peso;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
}
