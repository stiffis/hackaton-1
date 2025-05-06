package com.bitWiseComplexity.bigMeow.Service;

import com.bitWiseComplexity.bigMeow.Domain.Empresa.Empresa;
import com.bitWiseComplexity.bigMeow.Repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

@RequiredArgsConstructor
@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final NativeWebRequest nativeWebRequest;

    public Empresa crearEmpresaAdministrador(Empresa empresa){

        return empresaRepository.save(empresa);

    }

}
