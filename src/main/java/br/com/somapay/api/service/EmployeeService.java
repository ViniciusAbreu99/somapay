package br.com.somapay.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.somapay.api.controller.dto.EmployeeDto;
import br.com.somapay.api.controller.form.EmployeeForm;
import br.com.somapay.api.model.Employee;
import br.com.somapay.api.model.Enterprise;
import br.com.somapay.api.repository.EmployeeRepository;
import br.com.somapay.api.repository.EnterpriseRepository;
import net.minidev.json.JSONObject;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EnterpriseRepository enterpriseRepository;

	public ResponseEntity<?> getSaldo(Long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if (employeeOptional.isPresent()) {
			JSONObject response = new JSONObject();
			response.appendField("saldo", employeeOptional.get().getSaldoContaCorrente());

			return ResponseEntity.ok().body(response);
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<?> createEmployee(EmployeeForm form) {
		Optional<Enterprise> enterprise = enterpriseRepository.findById(form.getEmpresaId());

		if (!enterprise.isPresent()) {
			return ResponseEntity.badRequest().body("Empresa não encontrada.");
		}

		Employee employee = form.converter(enterprise.get());

		boolean exists = employeeRepository.existsByCpf(employee.getCpf());

		if (exists) {
			return ResponseEntity.badRequest().body("Funcionário já cadastrada.");
		}

		employeeRepository.save(employee);

		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.converter(employee);
		return ResponseEntity.created(null).body(employeeDto);
	}
}
