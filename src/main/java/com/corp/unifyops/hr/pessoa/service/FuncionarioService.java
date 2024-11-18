package com.corp.unifyops.hr.pessoa.service;


import com.corp.unifyops.hr.pessoa.model.DadosFuncionario;
import jakarta.transaction.Transactional;

public interface FuncionarioService {
    DadosFuncionario cadastrar(DadosFuncionario dadosFuncionario);


    @Transactional
    void deletar(String idFuncional);

    DadosFuncionario atualizar(String idFuncional, DadosFuncionario dadosFuncionario);


}
