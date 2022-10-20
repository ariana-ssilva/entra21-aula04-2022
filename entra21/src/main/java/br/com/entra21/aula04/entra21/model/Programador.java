package br.com.entra21.aula04.entra21.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programador")
public class Programador extends MaturidadeNivel3Richardson{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer qtdLinguagem;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdLinguagem() {
		return qtdLinguagem;
	}

	public void setQtdLinguagem(int qtdLinguagem) {
		this.qtdLinguagem = qtdLinguagem;
	}

	public Programador(int id, String nome, int qtd_linguagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtdLinguagem = qtd_linguagem;
	}

	public Programador() {
		super();
	}

}
