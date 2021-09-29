package com.accenture.academico.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accenture.academico.bank.dto.ClienteDto;
import com.accenture.academico.bank.model.Cliente;
import com.accenture.academico.bank.repository.ClienteRepository;


@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	//listar todas as agencias
	public List<Cliente> getAllCliente() {

		List<Cliente> client = new ArrayList<Cliente>();
		clienteRepository.findAll().forEach(cliente-> client.add(cliente));
		return client;
	}
	
	public ResponseEntity<Cliente> encontrarIdCliente(long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent())
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public Cliente save(ClienteDto clientDto) {
		return clienteRepository.save(clientDto);
	}

	public ResponseEntity<Cliente> atualizaCliente(long id, Cliente newCliente) {
		Optional<Cliente> oldCliente = clienteRepository.findById(id);
		if (oldCliente.isPresent()) {
			Cliente cliente = oldCliente.get();
			cliente.setNome(newCliente.getNome());
			clienteRepository.save(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> apagarCliente(long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public Cliente Save(@Valid Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	
	}

	public ClienteDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
