package br.com.somapay.api.model;

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

	public List<Employee> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Employee> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
