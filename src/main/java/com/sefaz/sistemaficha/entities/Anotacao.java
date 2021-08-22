package com.sefaz.sistemaficha.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_anotacao")
public class Anotacao implements Serializable{
	private static final long serialVersionUID = 1L;

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idanotacao", nullable = false)
	private Integer id;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "tipo", nullable = false)
	private String tipo;
	
	@Column(name = "dt_anotacao", nullable = false)
	private Date dataAnotacao;
	
	@ManyToMany(mappedBy = "anotacoes")
	//Association
	private Set<FichaFuncional> fichasFuncionais = new HashSet<>();
	
	//Constructors
	public Anotacao(){
		super();
	}
	
	public Anotacao(Integer id, String descricao, String tipo, Date dataAnotacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		this.dataAnotacao = dataAnotacao;
	}

	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataAnotacao() {
		return dataAnotacao;
	}

	public void setDataAnotacao(Date dataAnotacao) {
		this.dataAnotacao = dataAnotacao;
	}

	//HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anotacao other = (Anotacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
