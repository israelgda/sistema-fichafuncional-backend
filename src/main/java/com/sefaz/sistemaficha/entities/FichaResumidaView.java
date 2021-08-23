package com.sefaz.sistemaficha.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_listar_fichas")
public class FichaResumidaView implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "matricula", nullable = false)
	private Integer matricula;

	@Column(name = "nome_servidor", nullable = false)
	private String nome;

	@Column(name = "cargo", nullable = false)
	private String cargo;

	@Column(name = "lotacao", nullable = false)
	private String lotacao;
	
	// Construtores
	public FichaResumidaView() {
		super();
	}

	public FichaResumidaView(Integer id, Integer matricula, String nome, String cargo, String lotacao) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.cargo = cargo;
		this.lotacao = lotacao;
	}


	// Getters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}
	

	//HashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
