package br.com.entra21.aula04.entra21.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sistema")
public class SistemaController {
	@GetMapping()

	@ResponseStatus(HttpStatus.OK)

	public String testar() {

	return "Estou ON baby";

	}



}
