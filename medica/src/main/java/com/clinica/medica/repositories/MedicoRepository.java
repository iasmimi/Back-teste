package com.clinica.medica.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.medica.entities.Medico;

@Repository
public interface MedicoRepository extends JpaRepository <Medico, Long>{

	 static Optional<Medico> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	    List<Medico> findByNomeContainingIgnoreCase(String nome);

		Optional<Medico> findByEmailAndSenha(String email, String senha);


}
