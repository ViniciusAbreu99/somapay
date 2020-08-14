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

import br.com.somapay.api.controller.form.EnterpriseForm;
import br.com.somapay.api.controller.form.TransferForm;
import br.com.somapay.api.service.EnterpriseService;

@RestController
@RequestMapping("/empresa")
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;

	@GetMapping("/saldo/{id}")
	public ResponseEntity<?> getSaldo(@PathVariable Long id) {
		return enterpriseService.getSaldo(id);
	}

	@Transactional
	@PostMapping
	public ResponseEntity<?> createEnterprise(@RequestBody @Valid EnterpriseForm form) {
		return enterpriseService.createEnterprise(form);
	}

	@Transactional
	@PostMapping("/transferencia")
	public ResponseEntity<?> transferToEmployee(@RequestBody @Valid TransferForm form) {
		return enterpriseService.transferToEmployee(form);
	}
}
