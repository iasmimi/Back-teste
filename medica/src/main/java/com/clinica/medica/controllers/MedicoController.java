package com.clinica.medica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.medica.entities.Medico;
import com.clinica.medica.repositories.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/cadastrar")
    public ResponseEntity<Medico> cadastrar(@RequestBody Medico medico) {
        medico.setSenha(encoder.encode(medico.getSenha()));
        Medico salvo = medicoRepository.save(medico); 
        return ResponseEntity.ok(salvo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Medico loginRequest) {
        Optional<Medico> profissionalOpt = MedicoRepository.findByEmail(loginRequest.getEmail()); 
        if (profissionalOpt.isPresent()) {
            Medico profissional = profissionalOpt.get();
            if (encoder.matches(loginRequest.getSenha(), profissional.getSenha())) {
                profissional.setSenha(null);
                return ResponseEntity.ok(profissional);
            }
        }
        return ResponseEntity.status(401).body("Email ou senha inválidos");
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Medico>> listarTodos() {
        List<Medico> lista = medicoRepository.findAll(); 
        lista.forEach(p -> p.setSenha(null));
        return ResponseEntity.ok(lista);
    }

    public MedicoRepository getMedicoRepository() {
        return medicoRepository;
    }

    public void setMedicoRepository(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }
}
