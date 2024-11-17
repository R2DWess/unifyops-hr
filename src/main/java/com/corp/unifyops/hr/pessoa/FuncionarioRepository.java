package com.corp.unifyops.hr.pessoa;

import com.corp.unifyops.hr.pessoa.model.DadosFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<DadosFuncionario, Integer> {

    boolean existsByIdFuncional(String id);
}
