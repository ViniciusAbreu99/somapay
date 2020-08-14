package br.com.somapay.api.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.somapay.api.model.Enterprise;

public class EnterpriseForm {

	@NotNull
	private String nome;

	@NotNull
	private String razaoSocial;

	@NotNull
	private String nomeFantasia;

	@NotNull
	private String cnpj;

	@NotNull
	private String inscricaoEstadual;

	@NotNull
	private BigDecimal saldo;

	public Enterprise converter() {
		Enterprise enterprise = new Enterprise(this.nome, this.razaoSocial, this.nomeFantasia, this.cnpj,
				this.inscricaoEstadual, this.saldo);

		return enterprise;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
}
