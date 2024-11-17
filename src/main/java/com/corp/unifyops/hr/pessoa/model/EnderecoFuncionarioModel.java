package com.corp.unifyops.hr.pessoa.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public record EnderecoFuncionarioModel(

        @NotBlank(message = "O campo Rua é obrigatório")
        String rua,

        @NotBlank(message = "O campo Numero é obrigatório")
        String numero,

        String complemento,

        @NotBlank(message = "O campo Bairro é obrigatório")
        String bairro,

        @NotBlank(message = "O campo cidade é obrigatório")
        String cidade,

        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$", message = "Estado deve ter 2 letras maiúsculas")
        String estado,

        @NotBlank
        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "CEP inválido, formato esperado: 00000-000")
        String cep
) {}