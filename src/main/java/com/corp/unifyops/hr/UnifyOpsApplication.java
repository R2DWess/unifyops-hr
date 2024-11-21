package com.corp.unifyops.hr;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnifyOpsApplication {
    public static void main(String[] args) {
        // Carregar o arquivo .env
        Dotenv dotenv = Dotenv.configure().load();
        // Definir variáveis de ambiente manualmente
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(UnifyOpsApplication.class, args);
    }
}
