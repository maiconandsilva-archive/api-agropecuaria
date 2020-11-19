package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;


@MappedSuperclass
@AllArgsConstructor
public abstract class AnimalBase extends PanacheEntityBase {
	@ManyToOne
	public Raca raca;

	@ManyToOne
	public Lote lote;

	@OneToMany(mappedBy = "animal")
	public List<AplicacaoVacina> aplicacaoVacinas;
	
	@Enumerated(EnumType.STRING)
	public Genero genero;

	@Temporal(TemporalType.DATE)
	public Date dataNascimento;

	/** Peso do animal vivo em Kg, 
	 * ou último peso do animal para abate (AnimalVendido)
	 */
	public Double peso;

	public AnimalBase() {
		aplicacaoVacinas = new ArrayList<>();
	}
	
	public abstract Double getRendimentoCarcaca();

	public abstract Double getPesoCarcacaArroba();

	public abstract Double getPesoCarcacaKg();

	public abstract Double getPesoCarcacaUnidadePadrao();
}
