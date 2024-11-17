package com.corp.unifyops.hr.pessoa.controller;

import com.corp.unifyops.hr.pessoa.repository.FuncionarioRepository;
import com.corp.unifyops.hr.pessoa.model.DadosFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public DadosFuncionario criarPessoa(@RequestBody DadosFuncionario dadosFuncionario) {
        return funcionarioRepository.save(dadosFuncionario);
    }
}
