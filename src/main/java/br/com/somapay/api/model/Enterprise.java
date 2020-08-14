package br.com.somapay.api.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Enterprise {

	public Enterprise() {

	}

	public Enterprise(String nome, String razaoSocial, String nomeFantasia, String cnpj, String inscricaoEstadual,
			BigDecimal saldoContaCorrente) {
		super();
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.saldoContaCorrente = saldoContaCorrente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(name = "razao_social", nullable = false)
	private String razaoSocial;

	@Column(name = "nome_fantasia", nullable = false)
	private String nomeFantasia;

	@Column(nullable = false)
	private String cnpj;

	@Column(nullable = false, name = "incricao_estadual")
	private String inscricaoEstadual;

	@OneToMany(mappedBy = "empresa")
	private List<Employee> funcionarios;

	@Column(name = "saldo_conta_corrente")
	private BigDecimal saldoContaCorrente;

	public Long getId() {
		return id;
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

	public List<Employee> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Employee> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public void saqueContaCorrente(BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) == 1 && valor.compareTo(this.saldoContaCorrente) <= 0) {
			this.saldoContaCorrente = this.saldoContaCorrente.subtract(valor);
		}
	}

	public void depositoContaCorrente(BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) == 1) {
			this.saldoContaCorrente = this.saldoContaCorrente.add(valor);
		}
	}

	public BigDecimal getSaldoContaCorrente() {
		return this.saldoContaCorrente;
	}
}
