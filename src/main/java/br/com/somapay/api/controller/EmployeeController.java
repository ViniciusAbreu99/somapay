package br.com.somapay.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class EmployeeController {

	@GetMapping
	public ResponseEntity<?> getEmployees() {
		return ResponseEntity.ok("funcionario");
	}
}
