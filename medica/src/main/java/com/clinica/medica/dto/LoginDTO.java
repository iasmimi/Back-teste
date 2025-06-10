package com.clinica.medica.dto;

import com.clinica.medica.entities.Paciente;

public class LoginDTO {
	
	 private String email;
	    private String password;
	    
		

		public LoginDTO(String email, String password) {
			this.email = email;
			this.password = password;
		}



		public LoginDTO(Paciente entity) {
			this.email = entity.getEmail();
			this.password = entity.getPassword();
		}



		public LoginDTO() {
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
		
		

}