package com.MatrizDeConhecimento.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;



public class Colaborador{


	@JsonProperty("CPF")
	private String cpf;
	private String nome;
	private String cargo;
	private String sede;
	@JsonFormat(pattern="dd-MM-yyyy")
	private String data_de_nascimento;
	@JsonFormat(pattern="dd-MM-yyyy")
	private String data_de_admissao;
	
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
	
}
