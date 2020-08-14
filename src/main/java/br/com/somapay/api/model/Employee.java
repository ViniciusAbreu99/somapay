package br.com.somapay.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Employee {

	public Employee() {

	}

	public Employee(String nome, LocalDate nascimento, String cpf, Enterprise empresa, BigDecimal saldoContaCorrente) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.empresa = empresa;
		this.saldoContaCorrente = saldoContaCorrente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private LocalDate nascimento;

	@Column(nullable = false)
	private String cpf;

	@ManyToOne
	@JoinColumn(nullable = false, referencedColumnName = "id")
	private Enterprise empresa;

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

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Enterprise getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Enterprise empresa) {
		this.empresa = empresa;
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
