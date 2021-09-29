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

import com.accenture.academico.bank.model.Agencia;
import com.accenture.academico.bank.service.AgenciaService;

@RestController
public class AgenciaController {
	@Autowired
	AgenciaService agenciaService;

	@GetMapping("/agencia")
	public List<Agencia> getAllAgencia() {
		return agenciaService.getAllAgencia();
	}

	@RequestMapping(value = "/agencia/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agencia> getById(@PathVariable(value = "id") long id) {
		return agenciaService.encontrarId(id);

	}

	@RequestMapping(value = "/agencia", method = RequestMethod.POST)
	public Agencia Post(@Valid @RequestBody Agencia agencia) {
		return agenciaService.Save(agencia);
	}

	@RequestMapping(value = "/agencia/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Agencia> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Agencia newAgencia) {
		return agenciaService.atualiza(id, newAgencia);

	}
//botei apagar mas vamos levantar a exceção quando  for apagar devido aos cliente ou também pode ser uma implementação 
	// para o admin  e somente ele, excluir.
	@RequestMapping(value = "/agencia/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

		return agenciaService.apagar(id);
	}

}
