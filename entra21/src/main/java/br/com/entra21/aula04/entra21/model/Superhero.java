package br.com.entra21.aula04.entra21.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "superhero")

public class Superhero extends MaturidadeNivel3Richardson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String super_name;
	private String super_power;

	public Superhero() {
		super();
	}

	public Superhero(Integer id, String super_name, String super_power) {
		super();
		this.id = id;
		this.super_name = super_name;
		this.super_power = super_power;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSuper_name() {
		return super_name;
	}

	public void setSuper_name(String super_name) {
		this.super_name = super_name;
	}

	public String getSuper_power() {
		return super_power;
	}

	public void setSuper_power(String super_power) {
		this.super_power = super_power;
	}
}
