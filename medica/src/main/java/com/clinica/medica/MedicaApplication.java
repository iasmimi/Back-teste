package com.clinica.medica;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicaApplication {

	 @Autowired
	    private DataSource dataSource;

	    public static void main(String[] args) {
	        SpringApplication.run(MedicaApplication.class, args);
	    }

	    public void run(String... args) throws Exception {
	        try (Connection conn = dataSource.getConnection()) {
	            System.out.println("✅ Conectado ao banco: " + conn.getCatalog());
	        }
	    }

}
