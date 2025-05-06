package com.bitWiseComplexity.bigMeow.Domain.empresa;

import com.bitWiseComplexity.bigMeow.Domain.usuario.*;
import com.bitWiseComplexity.bigMeow.Domain.restricciones.*;
import jakarta.persistence.*;
import com.bitWiseComplexity.bigMeow.Domain.sparky.*;
import java.util.List;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ruc;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "sparky_id")
    private Sparky sparky;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Restricciones> restricciones;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Sparky getSparky() {
        return sparky;
    }

    public void setSparky(Sparky sparky) {
        this.sparky = sparky;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Restricciones> getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(List<Restricciones> restricciones) {
        this.restricciones = restricciones;
    }
}
