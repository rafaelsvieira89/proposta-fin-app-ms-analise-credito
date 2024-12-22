package com.vieirarafael.propostafinappmsanalisecredito.services;

import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;
import lombok.AllArgsConstructor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class NotificacaoRabbitService {
    private final RabbitTemplate rabbitTemplate;

    public void notificar(String exchange, Proposta mensagem) {
        rabbitTemplate.convertAndSend(exchange, "", mensagem);
    }
}
