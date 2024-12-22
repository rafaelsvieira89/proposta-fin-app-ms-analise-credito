package com.vieirarafael.propostafinappmsanalisecredito.services;

import com.vieirarafael.propostafinappmsanalisecredito.config.RabbitExchangesProperties;
import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;
import com.vieirarafael.propostafinappmsanalisecredito.validacao.RegraValidacao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ValidacaoService {
    private final List<RegraValidacao> regraValidacao;
    private final NotificacaoRabbitService notificacaoRabbitService;
    private RabbitExchangesProperties rabbitExchangesProperties;

    public void validarProposta(Proposta proposta) {

        try {
            var resultado = regraValidacao.stream().mapToInt(regra -> regra.validar(proposta)).sum();
            var aprovada = resultado > 350;
            proposta.setAprovada(aprovada);
        } catch (StringIndexOutOfBoundsException e) {
            proposta
                    .setAprovada(false)
                    .setObservacao(e.getMessage());
            log.error(e.getMessage());
        }
        notificacaoRabbitService.notificar(rabbitExchangesProperties.getPropostaConcluida(), proposta);
    }
}
