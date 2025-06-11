package com.clinica.medica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.medica.entities.Consultas;

@Repository
public interface ConsultaRepository extends JpaRepository <Consultas, Long>{

	List<Consultas> findByMedicoId(Long id);

	List<Consultas> findByMedicoEspecialidade(String especialidade);

}
