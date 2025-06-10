package com.clinica.medica.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.medica.dto.ConsultasDTO;
import com.clinica.medica.entities.Consultas;
import com.clinica.medica.entities.Medico;
import com.clinica.medica.entities.Paciente;
import com.clinica.medica.repositories.ConsultaRepository;
import com.clinica.medica.repositories.MedicoRepository;
import com.clinica.medica.repositories.PacienteRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Consultas agendar(ConsultasDTO dto) {
        Medico medico = medicoRepository.findById(dto.getMedico()).orElse(null);
        Paciente paciente = pacienteRepository.findById(dto.getPaciente()).orElse(null);

        if (medico == null || paciente == null) {
            return null;
        }

        Consultas consulta = new Consultas();
        consulta.setData(dto.getData());
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        return consultaRepository.save(consulta);
    }

    public List<Consultas> buscarTodas() {
        return consultaRepository.findAll();
    }

    public List<Consultas> buscarPorMedico(Long id) {
        return consultaRepository.findByMedicoId(id);
    }

    public List<Consultas> buscarPorEspecialidade(String especialidade) {
        return consultaRepository.findByMedicoEspecialidade(especialidade);
    }

    public boolean deletar(Long id) {
        consultaRepository.deleteById(id);
		return false;
    }

	public Object listarTodas() {
		
		return null;
	}

	public Consultas salvar(ConsultasDTO dto) {
		
		return null;
	}

	public Consultas atualizar(Long id, ConsultasDTO dto) {
		
		return null;
	}

	public Object buscarPorDataHora(LocalDateTime dataHora) {
		
		return null;
	}

	public Object buscarPorMedicoEData(String nome, LocalDateTime dataHora) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsultasDTO> listarPorProfissional(Long id) {
		
		return null;
	}

	public Object listarPorPaciente(Long pacienteId) {
		
		return null;
	}

	public Object buscarPorMedico(String nome) {
		
		return null;
	}

	public ConsultasDTO buscarPorId(Long id) {
	
		return null;
	}
}
