package br.com.entra21.aula04.entra21.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entra21.aula04.entra21.model.Programador;
import br.com.entra21.aula04.entra21.model.Superhero;

public interface ISuperheroRepository extends JpaRepository<Superhero, Integer> {

}
