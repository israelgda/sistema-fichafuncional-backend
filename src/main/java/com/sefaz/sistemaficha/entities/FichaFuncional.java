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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fichafuncional")
public class FichaFuncional implements Serializable {
	private static final long serialVersionUID = 1L;

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idfichafuncional")
	private Integer id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "nome_pai", nullable = false)
	private String nomePai;

	@Column(name = "nome_mae", nullable = false)
	private String nomeMae;

	@Column(name = "nome_conjuge", nullable = true)
	private String nomeConjuge;

	@Column(name = "cep", nullable = false)
	private String cep;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@Column(name = "municipio", nullable = false)
	private String municipio;

	@Column(name = "telefone", nullable = false)
	private String telefone;

	@Column(name = "num_titulo_eleitor", nullable = false)
	private String numTituloEleitor;

	@Column(name = "num_rg", nullable = false)
	private String numIdentidade;

	@Column(name = "num_cpf", nullable = false)
	private String numCpf;

	@Column(name = "num_pis", nullable = false)
	private String numPisPasep;

	@Column(name = "dt_nascimento", nullable = false)
	private Date dataNascimento;

	@Column(name = "num_ordem", nullable = false)
	private Integer numOrdem;

	@Column(name = "num_matricula", nullable = false)
	private Integer numMatricula;

	@Column(name = "cargo", nullable = false)
	private String cargo;

	@Column(name = "lotacao", nullable = false)
	private String lotacao;

	@Column(name = "dt_nomeacao", nullable = false)
	private Date dataNomeacao;

	@Column(name = "dt_posse", nullable = false)
	private Date dataPosse;

	@Column(name = "grau_instrucao", nullable = true)
	private String grauInstrucao;

	@Column(name = "formacao", nullable = true)
	private String curso;
	
	@ManyToMany
	@JoinTable(name = "tb_ficha_anotacao", joinColumns = @JoinColumn(name = "idfichafuncional"), inverseJoinColumns = @JoinColumn(name = "idanotacao"))
	//Associations
	private Set<Anotacao> anotacoes = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_ficha_dependente", joinColumns = @JoinColumn(name = "idfichafuncional"), inverseJoinColumns = @JoinColumn(name = "iddepenente"))
	private Set<Dependente> dependentes = new HashSet<>();
	
	
	// Construtores
	public FichaFuncional() {
		super();
	}

	public FichaFuncional(Integer id, String nome, String nomePai, String nomeMae, String nomeConjuge, String cep,
			String endereco, String municipio, String telefone, String numTituloEleitor, String numIdentidade,
			String numCpf, String numPisPasep, Date dataNascimento, Integer numOrdem, Integer numMatricula,
			String cargo, String lotacao, Date dataNomeacao, Date dataPosse, String grauInstrucao, String curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.nomeConjuge = nomeConjuge;
		this.cep = cep;
		this.endereco = endereco;
		this.municipio = municipio;
		this.telefone = telefone;
		this.numTituloEleitor = numTituloEleitor;
		this.numIdentidade = numIdentidade;
		this.numCpf = numCpf;
		this.numPisPasep = numPisPasep;
		this.dataNascimento = dataNascimento;
		this.numOrdem = numOrdem;
		this.numMatricula = numMatricula;
		this.cargo = cargo;
		this.lotacao = lotacao;
		this.dataNomeacao = dataNomeacao;
		this.dataPosse = dataPosse;
		this.grauInstrucao = grauInstrucao;
		this.curso = curso;
	}

	// Getters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNumTituloEleitor() {
		return numTituloEleitor;
	}

	public void setNumTituloEleitor(String numTituloEleitor) {
		this.numTituloEleitor = numTituloEleitor;
	}

	public String getNumIdentidade() {
		return numIdentidade;
	}

	public void setNumIdentidade(String numIdentidade) {
		this.numIdentidade = numIdentidade;
	}

	public String getNumCpf() {
		return numCpf;
	}

	public void setNumCpf(String numCpf) {
		this.numCpf = numCpf;
	}

	public String getNumPisPasep() {
		return numPisPasep;
	}

	public void setNumPisPasep(String numPisPasep) {
		this.numPisPasep = numPisPasep;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getNumOrdem() {
		return numOrdem;
	}

	public void setNumOrdem(Integer numOrdem) {
		this.numOrdem = numOrdem;
	}

	public Integer getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(Integer numMatricula) {
		this.numMatricula = numMatricula;
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

	public Date getDataNomeacao() {
		return dataNomeacao;
	}

	public void setDataNomeacao(Date dataNomeacao) {
		this.dataNomeacao = dataNomeacao;
	}

	public Date getDataPosse() {
		return dataPosse;
	}

	public void setDataPosse(Date dataPosse) {
		this.dataPosse = dataPosse;
	}

	public String getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(String grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public Set<Anotacao> getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(Set<Anotacao> anotacoes) {
		this.anotacoes = anotacoes;
	}

	//HashCode e Equals
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
		FichaFuncional other = (FichaFuncional) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
