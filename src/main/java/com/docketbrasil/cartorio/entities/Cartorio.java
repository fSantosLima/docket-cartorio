package com.docketbrasil.cartorio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_cartorio")
public class Cartorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O campo nome não pode ser vazio!")
	@Column(unique=true, name = "nome")
	private String nome;
	
	@NotBlank(message = "O campo nome não pode ser vazio!")
	@Column(name = "logradouro")
	private String logradouro;
		
	@ManyToOne()
	@JoinColumn(name = "certidao_id")
	private TipoCertidao certidao;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartorio other = (Cartorio) obj;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Cartorio() {		
	}

	public Cartorio(long id, @NotBlank(message = "O campo nome não pode ser vazio!") String nome,
			@NotBlank(message = "O campo nome não pode ser vazio!") String logradouro, TipoCertidao certidao) {	
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
		this.certidao = certidao;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public TipoCertidao getCertidao() {
		return certidao;
	}

	public void setCertidao(TipoCertidao certidao) {
		this.certidao = certidao;
	}	
	
}
