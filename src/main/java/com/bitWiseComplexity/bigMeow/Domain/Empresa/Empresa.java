package com.bitWiseComplexity.bigMeow.Domain.Empresa;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.time.LocalDateTime;

@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String RUC;

    private LocalDateTime fecha_de_afiliacion;

    @Enumerated(EnumType.STRING)
    private EmpresaRole estado;

    private String  name_administrador;
}
