package com.docketbrasil.cartorio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_certidao")
public class TipoCertidao {

	@Id
	private long id;
	
	@Column(name = "nome")
	private String nome;

	public TipoCertidao() {		
	}

	public TipoCertidao(long id, String nome) {		
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
