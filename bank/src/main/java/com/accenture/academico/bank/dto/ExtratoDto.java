package com.accenture.academico.bank.dto;

import java.time.LocalDateTime;

public class ExtratoDto {
	private int idExtrato;
	private LocalDateTime dateHoraMovimento;
	private String operacao;
	private float valorOperacao;
	
	public int getIdExtrato() {
		return idExtrato;
	}
	public void setIdExtrato(int idExtrato) {
		this.idExtrato = idExtrato;
	}
	public LocalDateTime getDateHoraMovimento() {
		return dateHoraMovimento;
	}
	public void setDateHoraMovimento(LocalDateTime dateHoraMovimento) {
		this.dateHoraMovimento = dateHoraMovimento;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public float getValorOperacao() {
		return valorOperacao;
	}
	public void setValorOperacao(float valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

}
