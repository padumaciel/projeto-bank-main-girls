package com.accenture.academico.bank.controller;



import java.util.List;
import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.bank.dto.ClienteDto;
import com.accenture.academico.bank.model.Cliente;
import com.accenture.academico.bank.service.ClienteService;

@RestController
public class ClienteController {
		@Autowired
		ClienteService clienteService;
		final String BASE_URL = "/clientes";

		@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
		private ResponseEntity<ClienteDto> getClient(@PathVariable("id") long id) 
		{	
			ClienteDto clienteDto = clienteService.getById(id);
			if(clienteDto == null) {
		         throw new RecordNotFoundException("No record found : " + id);
		    }
		    return new ResponseEntity<StudentDto>(clienteDto, HttpStatus.OK);
		}

		@RequestMapping(value = "/cliente", method = RequestMethod.POST)
		public Cliente Post(@Valid @RequestBody Cliente cliente) {
			return clienteService.Save(cliente);
		}

		@RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Cliente> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Cliente newCliente) {
			return clienteService.atualizaCliente(id, newCliente);

		}

		@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

			return clienteService.apagarCliente(id);
		}

}