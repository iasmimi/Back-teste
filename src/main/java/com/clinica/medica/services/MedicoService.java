package com.clinica.medica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.medica.dto.MedicoDTO;
import com.clinica.medica.entities.Medico;
import com.clinica.medica.repositories.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico salvar(MedicoDTO dto) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setEmail(dto.getEmail());
        medico.setTelefone(dto.getTelefone());
        return medicoRepository.save(medico);
    }

    public List<Medico> buscarTodos() {
        return medicoRepository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }
}
