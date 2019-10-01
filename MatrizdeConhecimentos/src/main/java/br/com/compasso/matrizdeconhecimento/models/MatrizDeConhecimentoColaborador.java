package br.com.compasso.matrizdeconhecimento.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conhecimentos")
public class MatrizDeConhecimentoColaborador {
	
	@Id
	@Column(name = "cpf")
	@Basic(optional = false)
	private String cpf;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cargo")
	private String cargo;
	@Column(name = "sede")
	private String sede;
	@Column(name = "data_de_nascimento")
	private String data_de_nascimento;
	@Column(name = "data_de_admissao")
	private String data_de_admissao;
	@Column(name = "competencia")
	private String competencia;
	@Column(name = "experiencia")
	private String experiencia;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getData_de_nascimento() {
		return data_de_nascimento;
	}
	public void setData_de_nascimento(String data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}
	public String getData_de_admissao() {
		return data_de_admissao;
	}
	public void setData_de_admissao(String data_de_admissao) {
		this.data_de_admissao = data_de_admissao;
	}
	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

}
