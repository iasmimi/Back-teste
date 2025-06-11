package com.clinica.medica.services;

import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinica.medica.dto.LoginDTO;
import com.clinica.medica.entities.Paciente;
import com.clinica.medica.repositories.PacienteRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthService {

    @Autowired
    private PacienteRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final SecretKey jwtSecretKey = Keys.hmacShaKeyFor(
        "minhaChaveSecretaSuperSecreta1234567890".getBytes()
    );

    private final long jwtExpirationMs = 3600000; 
    public String autenticarEGerarToken(LoginDTO login) {
        Optional<Paciente> usuarioOpt = usuarioRepository.findByEmail(login.getEmail());

        if (usuarioOpt.isPresent()) {
            Paciente usuario = usuarioOpt.get();
            if (passwordEncoder.matches(login.getPassword(), (String) usuario.getPassword())) {
                return Jwts.builder()
                        .setSubject(usuario.getEmail())
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                        .signWith(jwtSecretKey, SignatureAlgorithm.HS256)
                        .compact();
            }
        }

        
        throw new RuntimeException("Falha na autenticação: email ou senha inválidos");
    }
}
