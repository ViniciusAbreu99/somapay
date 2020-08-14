package br.com.somapay.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.somapay.api.model.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

	boolean existsByCnpj(String cnpj);

}
