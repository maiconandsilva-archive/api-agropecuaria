package models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import cotacao.Unidade;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CotacaoVenda extends PanacheEntity {
	public BigDecimal preco;

    public String praca;

    @Enumerated(EnumType.STRING)
    public Unidade unidade;
}
