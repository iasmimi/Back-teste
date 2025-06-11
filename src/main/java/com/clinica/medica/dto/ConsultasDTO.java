package com.clinica.medica.dto;

import java.time.LocalDateTime;

import com.clinica.medica.entities.Consultas;

public class ConsultasDTO {
	private Long id;
    private LocalDateTime dataConsulta;
    private Long medico;
    private Long paciente;
    private String especialidade;
    
	public ConsultasDTO() {
	}
	
	public ConsultasDTO(Long id, LocalDateTime dataConsulta, Long medico, Long paciente, String especialidade) {
		this.id = id;
		this.dataConsulta = dataConsulta;
		this.medico = medico;
		this.paciente = paciente;
		this.especialidade = especialidade;
	}

	public ConsultasDTO(Consultas entity) {
		this.id = entity.getId();
		this.dataConsulta = entity.getDataHora();
		this.medico = entity.getMedico().getId();
		this.paciente = entity.getPaciente().getId();
		this.especialidade = entity.getEspecialidade();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(LocalDateTime dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public Long getMedico() {
		return medico;
	}
	public void setMedico(Long medico) {
		this.medico = medico;
	}
	public Long getPaciente() {
		return paciente;
	}
	public void setPaciente(Long paciente) {
		this.paciente = paciente;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
