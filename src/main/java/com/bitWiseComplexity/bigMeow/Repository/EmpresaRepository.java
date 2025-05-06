package com.bitWiseComplexity.bigMeow.Repository;

import com.bitWiseComplexity.bigMeow.Domain.Empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
