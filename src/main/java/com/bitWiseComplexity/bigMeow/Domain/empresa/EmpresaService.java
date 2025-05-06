package com.bitWiseComplexity.bigMeow.Domain.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }
}
