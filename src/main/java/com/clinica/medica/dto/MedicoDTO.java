package com.clinica.medica.dto;

import com.clinica.medica.entities.Medico;

public class MedicoDTO {
	private Long id;
	private String nome;
    private String especialidade;
    private String email;
    private String telefone;
    
	public MedicoDTO() {
	}
	
	
	public MedicoDTO(Long id, String nome, String especialidade, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
		this.email = email;
		this.telefone = telefone;
	}
	public MedicoDTO(Medico entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.especialidade = entity.getEspecialidade();
		this.email = entity.getEmail();
		this.telefone = entity.getTelefone();
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
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
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
}
