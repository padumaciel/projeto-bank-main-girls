package com.accenture.academico.bank.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import br.com.accentbank.accentBank.model.Agencia;
import br.com.accentbank.accentBank.repository.AgenciaRepository;


@Service
public class AgenciaService {

	@Autowired
	AgenciaRepository agenciaRepository;
	
	//listar todas as agencias
	public List<Agencia> getAllAgencia() {

		List<Agencia> agencias = new ArrayList<Agencia>();
		agenciaRepository.findAll().forEach(agencia -> agencias.add(agencia));
		return agencias;

	}
	public ResponseEntity<Agencia> encontrarId(long id) {

		Optional<Agencia> agencia = agenciaRepository.findById(id);
		if (agencia.isPresent())
			return new ResponseEntity<Agencia>(agencia.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public Agencia Save(Agencia agencia) {
		return agenciaRepository.save(agencia);
	}

	public ResponseEntity<Agencia> atualiza(long id, Agencia newAgencia) {
		Optional<Agencia> oldAgencia = agenciaRepository.findById(id);
		if (oldAgencia.isPresent()) {
			Agencia agencia = oldAgencia.get();
			agencia.setNome(newAgencia.getNome());
			agenciaRepository.save(agencia);
			return new ResponseEntity<Agencia>(agencia, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> apagar(long id) {

		Optional<Agencia> agencia = agenciaRepository.findById(id);
		if (agencia.isPresent()) {
			agenciaRepository.delete(agencia.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<com.accenture.academico.bank.model.Agencia> encontraId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
