package com.mkyong.stock;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_telefone", unique = true, nullable = false)
	private Integer idTelefone;
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	private Integer numero;
	private Integer ddd;
	
	public Integer getIdTelefone() {
		return idTelefone;
	}
	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

}
