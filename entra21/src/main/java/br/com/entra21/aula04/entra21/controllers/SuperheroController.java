package br.com.entra21.aula04.entra21.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.entra21.aula04.entra21.model.ItemNivel3;
import br.com.entra21.aula04.entra21.model.Programador;
import br.com.entra21.aula04.entra21.model.Superhero;
import br.com.entra21.aula04.entra21.repository.ISuperheroRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/superheroes")
public class SuperheroController {
	private final String SUPERPATH = "localhost:8080/superheroes";

	@Autowired
	private ISuperheroRepository superheroRepository;

	@GetMapping("")
	// @ResponseStatus(HttpStatus.OK);
	public List<Superhero> listAll() {
		List<Superhero> response = superheroRepository.findAll();
		response.forEach(superhero -> {
			setMaturidadeNivel3(superhero);
		});
		return response;
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Superhero> get (@PathVariable("id") int id){
		List<Superhero> response = superheroRepository.findById(id).stream().toList();
		response.forEach(superhero -> {
			setMaturidadeNivel3(superhero);
		});
		return response;
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Superhero create(@RequestBody Superhero novoSuper) {
		Superhero response = superheroRepository.save(novoSuper);
		return response;
	}

	@PutMapping("/{id}")

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody Superhero update(@PathVariable("id") int id,
			@RequestBody Superhero superEdited) {
		Superhero atual = superheroRepository.findById(id).get();
		atual.setSuper_name(superEdited.getSuper_name());
		atual.setSuper_power(superEdited.getSuper_power());
		atual = superheroRepository.save(atual);
		setMaturidadeNivel3(atual);
		return atual;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody boolean delete(@PathVariable("id") int id) {
		superheroRepository.deleteById(id);
		return !superheroRepository.existsById(id);
	}

	private void setMaturidadeNivel3(Superhero superhero) {
		ArrayList<String> headers = new ArrayList<String>();
		headers.add("Accept : application/json");
		headers.add("Content-type : application/json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		try {
			superhero.setLinks(null);
			String nomeAtual = superhero.getSuper_name();
			superhero.setSuper_name("Nome diferente");
			String jsonUpdate = mapper.writeValueAsString(superhero);
			superhero.setSuper_name(nomeAtual);
			superhero.setId(null);
			String jsonCreate = mapper.writeValueAsString(superhero);
			superhero.setLinks(new ArrayList<>());
			superhero.getLinks().add(new ItemNivel3("GET", SUPERPATH, null, null));
			superhero.getLinks().add(new ItemNivel3("GET", SUPERPATH + "/" + superhero.getId(), null, null));
			superhero.getLinks().add(new ItemNivel3("POST", SUPERPATH, headers, jsonCreate));
			superhero.getLinks().add(new ItemNivel3("PUT", SUPERPATH + "/" + superhero.getId(), headers, jsonUpdate));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
