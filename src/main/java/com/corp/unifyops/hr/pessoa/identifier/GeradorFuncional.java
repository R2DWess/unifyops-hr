package com.corp.unifyops.hr.pessoa.identifier;

import com.corp.unifyops.hr.pessoa.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeradorFuncional {

    private static final int FUNCIONAL_LENGTH = 9;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    /**
     * Gera um ID funcional único com exatamente 9 dígitos numéricos,
     * verificando se o ID já existe no banco de dados.
     */
    public String gerarIdUnico() {
        String id;
        do {
            id = gerarId();
        } while (funcionarioRepository.existsByIdFuncional(id)); // Verifica se o ID já existe
        return id;
    }

    /**
     * Gera um ID funcional com exatamente 9 dígitos numéricos.
     */
    private String gerarId() {
        StringBuilder id = new StringBuilder(FUNCIONAL_LENGTH);
        Random random = new Random();

        for (int i = 0; i < FUNCIONAL_LENGTH; i++) {
            int digit = random.nextInt(10);  // Gera um número de 0 a 9
            id.append(digit);
        }

        return id.toString();
    }
}