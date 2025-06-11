package com.clinica.medica.dto;

import com.clinica.medica.entities.Paciente;
import com.clinica.medica.entities.Roles;

public class PacienteDTO {
    private Long id;
    private String email;
    private String password;
    private Roles role;
    
    public PacienteDTO() {
	}
    
	public PacienteDTO(Long id, String email, String password, Roles role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public PacienteDTO(Paciente entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
		this.role = entity.getRole();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
    
}
