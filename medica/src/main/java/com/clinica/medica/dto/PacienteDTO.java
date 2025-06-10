package com.clinica.medica.dto;

import java.time.LocalDate;

import com.clinica.medica.entities.Paciente;

public class PacienteDTO {
	private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    
	public PacienteDTO() {
	}
	
	public PacienteDTO(Long id, String nome, String email, String telefone, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}
	
	public PacienteDTO(Paciente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.telefone = entity.getTeleone();
		this.dataNascimento = entity.getDataNascimento();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
