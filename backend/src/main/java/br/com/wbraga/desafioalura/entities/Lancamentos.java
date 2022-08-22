package br.com.wbraga.desafioalura.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.wbraga.desafioalura.entities.enums.TipoLancamento;

@Entity
@Table(name = "tb_lancamentos")
public class Lancamentos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Double valor;
	private Instant data;
	private Integer tipoLancamento; // Despesa ou Receita

	public Lancamentos() {
	}

	public Lancamentos(Long id, String descricao, Double valor, Instant data, TipoLancamento tipoLancamento) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		setTipoLancamento(tipoLancamento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public TipoLancamento getTipoLancamento() {
		return TipoLancamento.valueOf(tipoLancamento);
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento.getCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoLancamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamentos other = (Lancamentos) obj;
		return Objects.equals(id, other.id) && Objects.equals(tipoLancamento, other.tipoLancamento);
	}

}
