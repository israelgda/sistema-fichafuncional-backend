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
@Table(name = "tb_dependente")
public class Dependente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddependente")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "parentesco")
	private String parentesco;
	
	@Column(name = "num_cpf")
	private String numCpf;
	
	@Column(name = "registro_civil")
	private String numRegistroCivil;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "dt_nascimento")
	private Date dataNascimento;

	
	//Associations
	@ManyToMany(mappedBy = "dependentes")
	private Set<FichaFuncional> fichasFuncionais = new HashSet<>();
	
	//Constructors
	public Dependente() {
		super();
	}

	public Dependente(Integer id, String nome, String parentesco, String numCpf, String numRegistroCivil,
			String sexo, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.parentesco = parentesco;
		this.numCpf = numCpf;
		this.numRegistroCivil = numRegistroCivil;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getNumCpf() {
		return numCpf;
	}

	public void setNumCpf(String numCpf) {
		this.numCpf = numCpf;
	}

	public String getNumRegistroCivil() {
		return numRegistroCivil;
	}

	public void setNumRegistroCivil(String numRegistroCivil) {
		this.numRegistroCivil = numRegistroCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return id;
	}

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
		Dependente other = (Dependente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
