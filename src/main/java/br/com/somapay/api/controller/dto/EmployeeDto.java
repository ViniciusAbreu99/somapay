package br.com.somapay.api.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.somapay.api.model.Employee;

public class EmployeeDto {

	private Long id;

	private String nome;

	private LocalDate nascimento;

	private String cpf;

	private Long empresaId;

	private BigDecimal saldoContaCorrente;

	public void converter(Employee employee) {
		this.id = employee.getId();
		this.nome = employee.getNome();
		this.nascimento = employee.getNascimento();
		this.cpf = employee.getCpf();
		this.empresaId = employee.getEmpresa().getId();
		this.saldoContaCorrente = employee.getSaldoContaCorrente();
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
