package br.com.somapay.api.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.somapay.api.model.Employee;
import br.com.somapay.api.model.Enterprise;

public class EmployeeForm {

	@NotNull
	private String nome;

	@NotNull
	private LocalDate nascimento;

	@NotNull
	private String cpf;

	@NotNull
	private Long empresaId;

	@NotNull
	private BigDecimal saldoContaCorrente;

	public Employee converter(Enterprise enterprise) {
		Employee employee = new Employee(this.nome, this.nascimento, this.cpf, enterprise, this.saldoContaCorrente);
		return employee;
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

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

	public BigDecimal getSaldoContaCorrente() {
		return saldoContaCorrente;
	}

	public void setSaldoContaCorrente(BigDecimal saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}

}
