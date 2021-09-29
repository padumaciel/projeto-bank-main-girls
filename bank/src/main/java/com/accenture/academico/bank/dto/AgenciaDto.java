package com.accenture.academico.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//Aqui irá criar um construtor vazio
@NoArgsConstructor
//Cria um método construtor com todos os parametros 
@AllArgsConstructor

public class AgenciaDto {
	private int id;
	private String nomeAgencia;
	private String endereco;
	private String telefone;
	
	
	}
	

	

