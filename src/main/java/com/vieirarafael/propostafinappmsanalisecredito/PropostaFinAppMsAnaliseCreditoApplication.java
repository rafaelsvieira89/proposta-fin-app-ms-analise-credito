package com.vieirarafael.propostafinappmsanalisecredito;

import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;
import com.vieirarafael.propostafinappmsanalisecredito.services.ValidacaoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
@SpringBootApplication
public class PropostaFinAppMsAnaliseCreditoApplication {

    private final ValidacaoService validacaoService;
    public static void main(String[] args) {
        SpringApplication.run(PropostaFinAppMsAnaliseCreditoApplication.class, args);
    }
@Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            validacaoService.validarProposta(new Proposta());
        };
    }

}
