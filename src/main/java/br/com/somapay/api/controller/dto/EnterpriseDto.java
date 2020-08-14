package br.com.somapay.api.controller.dto;

import java.math.BigDecimal;

import br.com.somapay.api.model.Enterprise;

public class EnterpriseDto {

	private Long id;

	private String nome;

	private String razaoSocial;

	private String nomeFantasia;

	private String cnpj;

	private String inscricaoEstadual;

	private BigDecimal saldoContaCorrente;

	public void converter(Enterprise enterprise) {
		this.id = enterprise.getId();
		this.nome = enterprise.getNome();
		this.razaoSocial = enterprise.getRazaoSocial();
		this.nomeFantasia = enterprise.getNomeFantasia();
		this.cnpj = enterprise.getCnpj();
		this.inscricaoEstadual = enterprise.getInscricaoEstadual();
		this.saldoContaCorrente = enterprise.getSaldoContaCorrente();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getSaldoContaCorrente() {
		return saldoContaCorrente;
	}

	public void setSaldoContaCorrente(BigDecimal saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}

}
