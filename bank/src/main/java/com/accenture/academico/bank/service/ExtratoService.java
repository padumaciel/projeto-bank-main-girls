package com.accenture.academico.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.bank.model.Extrato;
import com.accenture.academico.bank.repository.ExtratoRepository;



@Service
public class ExtratoService {
	//regras de negocio nos metodos abaixo
	
		
	@Autowired
	private ExtratoRepository repository;
	
	public List<Extrato> buscarExtratosDaConta(String numeroDaConta){
		
		return repository.findByContaNumero(numeroDaConta);
	}
	
	public void saveExtrato(Extrato extrato) {
		
		repository.save(extrato);
	}
}