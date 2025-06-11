package com.clinica.medica.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.medica.dto.ConsultasDTO;
import com.clinica.medica.entities.Consultas;
import com.clinica.medica.services.ConsultaService;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<Object> listarTodas() {
        return ResponseEntity.ok(consultaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        ConsultasDTO consulta = consultaService.buscarPorId(id);
        if (consulta != null) {
            return ResponseEntity.ok(consulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody ConsultasDTO dto) {
        try {
            Consultas salvo = consultaService.salvar(dto);
            return ResponseEntity.ok(new ConsultasDTO(salvo));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultasDTO> atualizar(@PathVariable Long id, @RequestBody ConsultasDTO dto) {
        try {
            Consultas atualizada = consultaService.atualizar(id, dto);
            return ResponseEntity.ok(new ConsultasDTO(atualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean ok = consultaService.deletar(id);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/profissional")
    public ResponseEntity<Object> buscarPorProfissional(@RequestParam String nome) {
        return ResponseEntity.ok(consultaService.buscarPorMedico(nome));
    }

    @GetMapping("/especialidade")
    public ResponseEntity<List<Consultas>> buscarPorEspecialidade(@RequestParam String especialidade) {
        return ResponseEntity.ok(consultaService.buscarPorEspecialidade(especialidade));
    }

    @GetMapping("/data")
    public ResponseEntity<Object> buscarPorData(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHora) {
        return ResponseEntity.ok(consultaService.buscarPorDataHora(dataHora));
    }

    @GetMapping("/medicos-data")
    public ResponseEntity<Object> buscarPorProfissionalEData(
        @RequestParam String nome,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHora) {
        return ResponseEntity.ok(consultaService.buscarPorMedicoEData(nome, dataHora));
    }

    @GetMapping("/especialidade-data")
    public ResponseEntity<Object> buscarPorEspecialidadeEData(
        @RequestParam String especialidade,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHora) {
        return ResponseEntity.ok(consultaService.buscarPorMedicoEData(especialidade, dataHora));
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<Object> listarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(consultaService.listarPorPaciente(pacienteId));
    }

    @GetMapping("/mdicos/{id}")
    public ResponseEntity<List<ConsultasDTO>> listarConsultasDoProfissional(@PathVariable Long id) {
        List<ConsultasDTO> consultas = consultaService.listarPorProfissional(id);
        return consultas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(consultas);
    }
}
