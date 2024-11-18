package com.corp.unifyops.hr.pessoa.controller;

import com.corp.unifyops.hr.pessoa.identifier.GeradorFuncional;
import com.corp.unifyops.hr.pessoa.model.DadosFuncionario;
import com.corp.unifyops.hr.pessoa.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private GeradorFuncional geradorFuncional;

    @PostMapping
    public DadosFuncionario criarPessoa(@RequestBody DadosFuncionario dadosFuncionario) {
        dadosFuncionario.setIdFuncional(geradorFuncional.gerarIdUnico());
        return funcionarioService.cadastrar(dadosFuncionario);
    }

    @PatchMapping("/{idFuncional}")
    public DadosFuncionario atualizarParcial(@PathVariable String idFuncional, @RequestBody DadosFuncionario dadosFuncionario) {
        return funcionarioService.atualizar(idFuncional, dadosFuncionario);
    }

    @DeleteMapping("/{idFuncional}")
    public void deletar(@PathVariable String idFuncional){
        funcionarioService.deletar(idFuncional);
    }
}