package com.bitWiseComplexity.bigMeow.Domain;

import com.bitWiseComplexity.bigMeow.DTO.JwtAuthenticationResponse;
import com.bitWiseComplexity.bigMeow.DTO.SigninRequest;
import com.bitWiseComplexity.bigMeow.Service.JwtService;
import com.example.PC1.Domain.Empleado.Empleado;
import com.example.PC1.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    EmpleadoRepository empleadoRepository; //Esto va a depender del repositorio de la entidad a autenticar

    @Autowired
    PasswordEncoder passwordEncoder; //Necesita estar configurado

    @Autowired
    JwtService jwtService; //Necesita estar configurado

    @Autowired
    AuthenticationManager authenticationManager; //Necesita estar configurado

    public JwtAuthenticationResponse signup(Empleado empleado) {
        empleado.setPassword(passwordEncoder.encode(empleado.getPassword()));

        empleadoRepository.save(empleado);
        var jwt = jwtService.generateToken(empleado);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);

        return response;
    }

    public JwtAuthenticationResponse signin(SigninRequest request) throws IllegalArgumentException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getPassword())); //Si cambio la forma de registrarme, cambio la carpeta de filter

        var user = empleadoRepository.findByCorreo(request.getCorreo()); //Esto se cambia en el repository

        var jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);

        return response;
    }
}//Copiar y pegar
