package br.com.somapay.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.somapay.api.controller.dto.EnterpriseDto;
import br.com.somapay.api.controller.form.EnterpriseForm;
import br.com.somapay.api.controller.form.TransferForm;
import br.com.somapay.api.model.Employee;
import br.com.somapay.api.model.Enterprise;
import br.com.somapay.api.repository.EmployeeRepository;
import br.com.somapay.api.repository.EnterpriseRepository;
import net.minidev.json.JSONObject;

@Service
public class EnterpriseService {

	@Autowired
	private EnterpriseRepository enterpriseRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public ResponseEntity<?> getSaldo(Long id){
		Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(id);
		if (enterpriseOptional.isPresent()) {
			JSONObject response = new JSONObject();
			response.appendField("saldo", enterpriseOptional.get().getSaldoContaCorrente());

			return ResponseEntity.ok().body(response);
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<?> createEnterprise(EnterpriseForm form) {
		Enterprise enterprise = form.converter();

		boolean exists = enterpriseRepository.existsByCnpj(enterprise.getCnpj());

		if (exists) {
			return ResponseEntity.badRequest().body("Empresa já cadastrada.");
		}

		enterpriseRepository.save(enterprise);

		EnterpriseDto enterpriseDto = new EnterpriseDto();
		enterpriseDto.converter(enterprise);
		return ResponseEntity.created(null).body(enterpriseDto);
	}

	public ResponseEntity<?> transferToEmployee(TransferForm form) {
		Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(form.getEmpresaId());
		Optional<Employee> employeeOptional = employeeRepository.findByCpf(form.getCpfFuncionario());

		if (!enterpriseOptional.isPresent()) {
			return ResponseEntity.badRequest().body("Empresa não encontrada.");
		}

		if (!employeeOptional.isPresent()) {
			return ResponseEntity.badRequest().body("Funcionário não encontrado.");
		}

		Enterprise enterprise = enterpriseOptional.get();
		Employee employee = employeeOptional.get();

		if (form.getValorTransferencia().compareTo(enterprise.getSaldoContaCorrente()) == 1) {
			return ResponseEntity.badRequest().body("Saldo insuficiente.");
		}

		enterprise.saqueContaCorrente(form.getValorTransferencia());
		employee.depositoContaCorrente(form.getValorTransferencia());

		enterpriseRepository.save(enterprise);
		employeeRepository.save(employee);

		return ResponseEntity.ok("Transação realizada com sucesso.");
	}
}
