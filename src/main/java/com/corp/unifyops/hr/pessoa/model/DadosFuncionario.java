package com.corp.unifyops.hr.pessoa.model;

import jakarta.persistence.*;

@Entity(name = "funcionario")
@Table(name = "dados_funcionario")
public class DadosFuncionario {

    @Id
    private String idFuncional;
    private String name;
    private String idade;
    private EnderecoFuncionarioModel enderecoFuncionario;

    public String getIdFuncional() {
        return idFuncional;
    }

    public void setIdFuncional(String idFuncional) {
        this.idFuncional = idFuncional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public EnderecoFuncionarioModel getEnderecoFuncionario(){
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(EnderecoFuncionarioModel enderecoFuncionario){
        this.enderecoFuncionario = enderecoFuncionario;
    }
}