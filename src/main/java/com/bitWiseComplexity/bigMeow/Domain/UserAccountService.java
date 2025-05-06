package com.bitWiseComplexity.bigMeow.Domain;

import com.example.PC1.Domain.Empleado.Empleado;
import com.example.PC1.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    EmpleadoRepository repository; //Aqui se pone el repositorio de la entidad donde se va a validar

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<Empleado> list() {
        return repository.findAll();
    } //Aqui se pone tu entidad

    public void save(Empleado empleado) {
        empleado.setPassword(passwordEncoder.encode(empleado.getPassword()));
        repository.save(empleado);
    } //Cambias la variable por tu entidad
}
