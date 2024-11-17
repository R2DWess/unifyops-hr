package com.corp.unifyops.hr.pessoa.service;

import com.corp.unifyops.hr.pessoa.model.DadosFuncionario;
import com.corp.unifyops.hr.pessoa.repository.FuncionarioRepository;
import com.corp.unifyops.hr.pessoa.identifier.GeradorFuncional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private GeradorFuncional geradorFuncional;

    @Override
    public DadosFuncionario cadastrar(DadosFuncionario dadosFuncionario) {

        dadosFuncionario.setIdFuncional(geradorFuncional.gerarIdUnico());
        return funcionarioRepository.save(dadosFuncionario);
    }
}

