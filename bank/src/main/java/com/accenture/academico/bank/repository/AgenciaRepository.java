package com.accenture.academico.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.academico.bank.model.Agencia;

@Repository
//JpaRepository é um mecanismo de consulta
public interface AgenciaRepository extends JpaRepository<Agencia,Long>{

}
