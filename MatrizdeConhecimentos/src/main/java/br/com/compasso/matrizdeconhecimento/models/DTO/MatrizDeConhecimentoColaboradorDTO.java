package br.com.compasso.matrizdeconhecimento.models.DTO;

import org.springframework.lang.Nullable;



public class MatrizDeConhecimentoColaboradorDTO {
	
	
	private String cpf;
	@Nullable
	private String nome;
	@Nullable
	private String cargo;
	@Nullable
	private String sede;
	@Nullable
	private String data_de_nascimento;
	@Nullable
	private String data_de_admissao;
	@Nullable
	private String competencia;
	@Nullable
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
