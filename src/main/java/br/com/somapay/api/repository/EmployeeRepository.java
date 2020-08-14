package br.com.somapay.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.somapay.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByCpf(String cpf);

	Optional<Employee> findByCpf(String cpfFuncionario);
	
}
