package com.clinica.medica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.medica.dto.PacienteDTO;
import com.clinica.medica.entities.Paciente;
import com.clinica.medica.repositories.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvar(PacienteDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefone(dto.getTelefone());
        paciente.setDataNascimento(dto.getDataNascimento());
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }

	public Paciente buscarPorEmail(String email) {
		
		return null;
	}

	public String autenticar(String email, Object senha) {
		
		return null;
	}
}
