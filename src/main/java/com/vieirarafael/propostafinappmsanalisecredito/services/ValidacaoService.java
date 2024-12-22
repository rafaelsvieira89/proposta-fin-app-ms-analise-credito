package com.vieirarafael.propostafinappmsanalisecredito.services;

import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;
import com.vieirarafael.propostafinappmsanalisecredito.validacao.RegraValidacao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@AllArgsConstructor
@Service
public class ValidacaoService {
    private final List<RegraValidacao> regraValidacao;

    public void validarProposta(Proposta proposta) {
        var resultado = regraValidacao.stream().mapToInt(regra -> regra.validar(proposta)).sum();
        log.info("Resultado: {}", resultado);
    }
}
