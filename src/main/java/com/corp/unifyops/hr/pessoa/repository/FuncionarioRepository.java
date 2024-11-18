package com.corp.unifyops.hr.pessoa.repository;

import com.corp.unifyops.hr.pessoa.model.DadosFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<DadosFuncionario, Integer> {

    boolean existsByIdFuncional(String id);

    void deleteByIdFuncional(String idFuncional);

    Optional<DadosFuncionario> findByIdFuncional(String idFuncional);
}
