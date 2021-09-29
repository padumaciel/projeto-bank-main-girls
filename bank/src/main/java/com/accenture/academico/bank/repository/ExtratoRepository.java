package com.accenture.academico.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.academico.bank.model.Extrato;


public interface ExtratoRepository extends JpaRepository<Extrato,Long>{

	List<Extrato> findByContaNumero(String numero);
	
}