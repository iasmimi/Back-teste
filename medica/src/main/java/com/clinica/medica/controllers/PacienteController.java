package com.clinica.medica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.medica.dto.PacienteDTO;
import com.clinica.medica.entities.Paciente;
import com.clinica.medica.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody PacienteDTO paciente) {
        Paciente salvo = pacienteService.salvar(paciente);
        return ResponseEntity.ok(salvo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginPaciente(@RequestBody Paciente paciente) {
        String token = pacienteService.autenticar(paciente.getEmail(), paciente.getSenha());
        if (token != null) {
            Paciente autenticado = pacienteService.buscarPorEmail(paciente.getEmail());
            return ResponseEntity.ok(autenticado);
        } else {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }
    }
}
