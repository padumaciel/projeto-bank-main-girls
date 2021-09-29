package com.accenture.academico.bank.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	@Column(nullable = false)
	private String nome, cpf, telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conta")
	private Conta Conta;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	public Object getNome() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setNome(Object nome2) {
		// TODO Auto-generated method stub
		
	}

}