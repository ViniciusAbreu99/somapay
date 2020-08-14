package br.com.somapay.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.somapay.api.controller.form.EmployeeForm;
import br.com.somapay.api.service.EmployeeService;

@RestController
@RequestMapping("/funcionario")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/saldo/{id}")
	public ResponseEntity<?> getSaldo(@PathVariable Long id) {
		return employeeService.getSaldo(id);
	}

	@Transactional
	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeForm form) {
		return employeeService.createEmployee(form);
	}
}
