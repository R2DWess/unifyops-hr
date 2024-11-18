package com.corp.unifyops.hr.pessoa.service;

import com.corp.unifyops.hr.pessoa.model.DadosFuncionario;
import com.corp.unifyops.hr.pessoa.repository.FuncionarioRepository;
import com.corp.unifyops.hr.pessoa.identifier.GeradorFuncional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Transactional
    @Override
    public void deletar(String idFuncional) {
        funcionarioRepository.deleteByIdFuncional(idFuncional);
    }

    @Override
    public DadosFuncionario atualizar(String idFuncional, DadosFuncionario dadosFuncionario) {

        Optional<DadosFuncionario> existingEmployee = funcionarioRepository.findByIdFuncional(idFuncional);
        if (existingEmployee.isPresent()){
            DadosFuncionario funcionario = getDadosFuncionario(dadosFuncionario, existingEmployee);
            return funcionarioRepository.save(funcionario);

        } else {
            throw new RuntimeException("Employee not found with idFuncional: " + idFuncional);
        }
    }

    private static DadosFuncionario getDadosFuncionario(DadosFuncionario dadosFuncionario, Optional<DadosFuncionario> existingEmployee) {
        DadosFuncionario funcionario = existingEmployee.get();
        if (dadosFuncionario.getName() != null) {
            funcionario.setName(dadosFuncionario.getName());
        }
        if (dadosFuncionario.getIdade() != null) {
            funcionario.setIdade(dadosFuncionario.getIdade());
        }
        if (dadosFuncionario.getEnderecoFuncionario() != null) {
            funcionario.setEnderecoFuncionario(dadosFuncionario.getEnderecoFuncionario());
        }
        return funcionario;
    }
}

